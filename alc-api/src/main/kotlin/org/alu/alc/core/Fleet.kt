package org.alu.alc.core

import org.alu.alc.core.helper.Buff
import org.alu.alc.core.helper.BuffCalculator

class Fleet(
    val isSurface: Boolean
) {
    private val ships =
        if (isSurface) Array(6) { Warship.makeDefaultWarship() }
        else Array(3) { Warship.makeDefaultWarship() }

    fun getMaximumTypes(): Int = this.buffCalculator.maximumTypes

    private val buffCalculator = BuffCalculator()

    /**
     * 将一艘舰船放入指定位置，如果指定位置已有舰船，则覆盖
     *
     * 当放入舰船时，会重新计算舰队技能优先级最大值
     *
     * @throws InitException 当目标位置不存在或放入角色已经存在时，抛出此异常
     * */
    fun putShip(pos: Position, ship: Warship) {
        if (pos.toInt() > this.ships.size)
            throw InitException(
                "target postion is not existed.(with index ${pos.toInt() - 1}, maximum ${ships.size})"
            )
        if (this.ships.contains(ship)) {
            throw InitException("this fleet had the ship.")
        }
        this.ships[pos.toInt() - 1] = ship
        for (skill in ship.skills) {
            for ((loopFlag, _) in skill.effects.values.withIndex()) {
                if (buffCalculator.maximumTypes < skill.priorities[loopFlag]) {
                    buffCalculator.maximumTypes = 0
                    buffCalculator.maximumTypes = skill.priorities[loopFlag]
                }
            }
        }
    }

    /**
     * 获取指定位置的舰船
     *
     * @throws InitException 当目标位置不存在时，抛出此异常
     * */
    fun getShip(pos: Position): Warship {
        if (pos.toInt() > this.ships.size)
            throw InitException(
                "target postion is not existed.(with index ${pos.toInt() - 1}, maximum: ${ships.size})"
            )
        return this.ships[pos.toInt() - 1]
    }

    /**
     * 通过舰船实例获取该舰船的位置
     *
     * **特别注意**:
     * 当[Fleet]被放入[Chapter]时，调用此函数的返回值是不确定的。
     * 因为[Chapter]要求每个[Fleet.ships]的元素互异，因此在初始化[Chapter]时，会自动更新相同元素。
     * 此时使用`getPosition(旧值)`很可能引发异常。
     *
     * 在使用此函数时，必须确保[Fleet.ships]的元素不被更新
     * */
    fun getPosition(ws: Warship): Position {
        if (!this.ships.contains(ws)) {
            throw IllegalArgumentException("this fleet does not have ship:${ws.name}")
        }
        return Position.toPosition(this.ships.indexOf(ws) + 1)
    }

    fun haveWarship(ws: Warship): Boolean = this.ships.contains(ws)

    /**
     * 判断舰队是否为空
     * */
    fun isEmpty(): Boolean {
        val ds = Warship.makeDefaultWarship()
        for (e in ships) {
            if (e != ds) {
                return false
            }
        }
        return true
    }

    /** 该函数获取的是**游戏内舰队面板**看到的炮击总值 */
    fun totalFirepower(): Int = ships[0].attributes.firepower +
            ships[1].attributes.firepower +
            ships[2].attributes.firepower +
            ships[3].attributes.firepower +
            ships[4].attributes.firepower +
            ships[5].attributes.firepower

    // todo: all `total` function

    /**
     * 计算出舰船被buff后的真实属性
     * */
    fun actualAttrOfOne(btype: Type.BonusType, pos: Position): Double {
        if (isEmpty() || btype == Type.BonusType.DAMAGE) return 0.0
        val ship = getShip(pos)
        val buff = this.getBuffOfTypeToAffectObject(btype, ship)
        val abuff = buffCalculator.actualBuffOfOne(buff)
        val source: Double = ship.getTrulyAttr(btype).toDouble()
        return source * abuff
    }

    /**
     * 计算直接伤增伤buff(包括敌人的debuff和己方给予的buff)
     * */
    fun damageBuff(pos: Position): Double {
        if (isEmpty()) return 0.0
        val ship = this.getShip(pos)
        val buff = this.getBuffOfTypeToAffectObject(Type.BonusType.DAMAGE, ship)
        return buffCalculator.actualBuffOfOne(buff)
    }

    /**
     * 获取作用于任意舰队一船上的buff
     *
     * 由于跨队计算的特殊性，我们保留技能的优先级
     * */
    fun getBuffOfTypeToAffectObject(btype: Type.BonusType, ws: Warship): Buff {
        if (isEmpty()) return Buff(ArrayList(), ArrayList())
        val buff = ArrayList<Double>()
        val ps = ArrayList<Int>()
        var p = 0
        while (p <= buffCalculator.maximumTypes) {
            for (ship in ships) {
                for (skill in ship.skills) {
                    // 如果技能未开启或不满足作用条件，则考虑下一个技能
                    if (!skill.isEnable) continue
                    if (!skill.affectTargets.affectShips.contains(ws.shipType)
                        || !skill.affectTargets.affectFactions.contains(ws.faction)
                    ) continue
                    // 如果舰船属于其他舰队
                    if (!ships.contains(ws)) {
                        // 则该技能必须满足`作用于另一舰队对象`，且满足`阵营和舰船类型需求`
                        if (skill.affectTargets.toOtherFleets) {
                            // 获取技能的加成值和其索引
                            for ((lf, eff) in skill.effects.values.withIndex()) {
                                // 如果该技能在`lf`处的加成类型匹配，且优先级匹配当前优先级
                                if (skill.effects.type[lf] == btype
                                    && skill.priorities[lf] == p
                                ) {
                                    buff.add(eff)
                                    ps.add(skill.priorities[lf])
                                }
                            }
                        }
                    } else {
                        // 如果舰船属于当前舰队
                        // 如果舰船不是自身
                        if (ship != ws) {
                            // 则技能必须满足作用于`本舰队的其他对象`
                            if (!skill.affectTargets.toOthers) continue
                        } else {
                            // 如果舰船是自身，则技能必须满足`作用于自身`
                            if (!skill.affectTargets.toSelf) continue
                        }
                        for ((lf, eff) in skill.effects.values.withIndex()) {
                            // 如果该技能在`lf`处的加成类型匹配，且优先级匹配当前优先级
                            if (skill.effects.type[lf] == btype
                                && skill.priorities[lf] == p
                            ) {
                                buff.add(eff)
                                ps.add(skill.priorities[lf])
                            }
                        }
                    }

                }
            }
            // 更新当前优先级
            ++p
        }
        return Buff(buff, ps)
    }

    companion object {
        const val IS_SURFACE = true
        const val IS_SUBMARINE = false
    }

    /**
     * 舰船的位置信息
     *
     * 在游戏中，其成员对应如下: <br/>
     * B1 B2 B3 <br/>
     * F1 F2 F3 <br/>
     *
     * 如果是潜艇舰队，那么B1-B3是**禁用**的
     * */
    enum class Position {
        F1, F2, F3, B1, B2, B3;

        fun toInt(): Int = when (this) {
            F1 -> 1
            F2 -> 2
            F3 -> 3
            B1 -> 4
            B2 -> 5
            B3 -> 6
        }

        companion object {
            fun toPosition(i: Int): Position = when (i) {
                1 -> F1
                2 -> F2
                3 -> F3
                4 -> B1
                5 -> B2
                6 -> B3
                else -> throw IllegalArgumentException("invalid number: $i")
            }
        }
    }
}


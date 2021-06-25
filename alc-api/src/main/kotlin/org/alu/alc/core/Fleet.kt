package org.alu.alc.core

class Fleet {
    private val ships = Array(6) { Warship.makeDefaultWarship() }

    /** 该舰队中技能优先级的最大值 */
    private var maximumTypes: Int = 1

    // todo
    fun putShip(pos: Position, ship: Warship) {
        this.ships[pos.toInt()] = ship
        for (skill in ship.skills) {
            for ((loopFlag, _) in skill.effects.withIndex()) {
                if (maximumTypes < skill.priorities[loopFlag] + 1) {
                    maximumTypes = 0
                    maximumTypes = skill.priorities[loopFlag] + 1
                }
            }
        }
    }

    fun getShip(pos: Position): Warship {
        return this.ships[pos.toInt()]
    }

    /** 该函数获取的是**游戏内舰队面板**看到的炮击总值 */
    fun totalFirepower(): Int =
        ships[0].firepower + ships[1].firepower + ships[2].firepower +
                ships[3].firepower + ships[4].firepower + ships[5].firepower

    /**
     * 计算出舰船被buff后的真实属性
     *
     * 如果是**直接增伤buff**，那么应使用[damageBuff]去单独获取
     *
     * todo: 放在Chapter内计算
     * */
    fun trueAttrOfOne(btype: Type.BonusType, pos: Position): Double {
        // todo
        val ship = getShip(pos)
        var flag = 0
        val bonus = DoubleArray(maximumTypes)
        while (flag < maximumTypes) {
            bonus[flag] = allBuffOfThisKindToOne(flag, btype, ship)
            flag++
        }
        var source: Double = ship.getTrulyAttr(btype).toDouble()
        for (b in bonus) {
            source *= (1 + b)
        }
        return source
    }

    fun damageBuff(btype: Type.BonusType, pos: Position): Double {
        val ship = this.getShip(pos)
        var flag = 0
        val bonus = DoubleArray(maximumTypes)
        while (flag < maximumTypes) {
            bonus[flag] = allBuffOfThisKindToOne(flag, btype, ship)
            flag++
        }
        var buff: Double = 0.0
        for (e in bonus) {
            buff *= (1 + e)
        }
        return buff
    }

    /** 舰船的位置信息 */
    enum class Position {
        F1, F2, F3, B1, B2, B3;

        fun toInt(): Int = when (this) {
            F1 -> 0
            F2 -> 1
            F3 -> 2
            B1 -> 3
            B2 -> 4
            B3 -> 5
        }
    }

    // todo: move it to another kt file.
    private fun allBuffOfThisKindToOne(priority: Int, btype: Type.BonusType, ws: Warship): Double {
        var bonus = 0.0
        for (ship in ships) {
            for (skill in ship.skills) {
                // 如果技能不开启，直接考虑下一个技能
                if (!skill.isEnable) continue
                if (ship != ws) {
                    // 如果该舰船不是当前舰船，则buff不作用于其他对象时，考虑下一个buff
                    if (!skill.affectTargets.toOthers) continue
                    // 如果该舰船不受该buff作用，考虑下一个buff
                    if (!skill.affectTargets.affectShips.contains(ws.shipType)) continue
                    if (!skill.affectTargets.affectFactions.contains(ws.faction)) continue
                } else {
                    // 如果该舰船是当前舰船，则buff不作用于自己时，考虑下一个buff
                    if (!skill.affectTargets.toSelf) continue
                }
                for ((loopFlag, effect) in skill.effects.withIndex()) {
                    // 当该buff属于目标加成buff且优先级匹配时，加上buff
                    if (effect.first.contains(btype) && skill.priorities[loopFlag] == priority) {
                        bonus += effect.second
                    }
                }
            }
        }
        return bonus
    }

}

// todo: 在计算buff的时候发现，有跨队buff的舰船影响了实际buff的计算

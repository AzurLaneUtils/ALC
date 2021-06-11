package org.alu.alc.core

class Fleet {
    private val ships = Array(6) { Warship.makeDefaultWarship() }
    private var maximumTypes: Int = 0

    fun putShip(pos: Position, ship: Warship) {
        this.ships[pos.toInt()] = ship
        var tempFlag = 0
        for (aship in ships) {
            for (skill in aship.skills) {
                for ((loopFlag, _) in skill.effects.withIndex()) {
                    if (tempFlag < skill.priorities[loopFlag]) {
                        tempFlag = 0
                        tempFlag += skill.priorities[loopFlag]
                    }
                }
            }
        }
        maximumTypes = tempFlag
    }

    /** 该函数获取的是**游戏内舰队面板**看到的炮击总值 */
    fun totalFirepower(): Int =
        useIf(ships[0]).firepower + useIf(ships[1]).firepower + useIf(ships[2]).firepower +
                useIf(ships[3]).firepower + useIf(ships[4]).firepower + useIf(ships[5]).firepower

    fun trueAttrOfOne(btype: Type.BonusType, pos: Position): Double {
        val ship = useIf(ships[pos.toInt()])
        var flag = 0
        val bonus = DoubleArray(maximumTypes)
        while (flag < maximumTypes) {
            bonus[flag] = allBuffOfThisKind(flag, btype)
            flag++
        }
        var source: Double = ship.getAttr(btype).toDouble()
        for (b in bonus) {
            source *= (1 + b)
        }
        return source
    }

    enum class Position {
        F1, F2, F3, B1, B2, B3;

        fun toInt(): Int = when(this) {
            F1 -> 0
            F2 -> 1
            F3 -> 2
            B1 -> 3
            B2 -> 4
            B3 -> 5
        }
    }

    private fun useIf(w: Warship?): Warship {
        return w ?: Warship.makeDefaultWarship()
    }

    private fun allBuffOfThisKind(priority: Int, btype: Type.BonusType): Double {
        var bonus = 0.0
        for (ship in ships) {
            for (skill in ship.skills) {
                if (!skill.isEnable) continue
                for ((loopFlag, effect) in skill.effects.withIndex()) {
                    if (effect.first == btype && skill.priorities[loopFlag] == priority) {
                        bonus += effect.second
                    }
                }
            }
        }
        return bonus
    }

}

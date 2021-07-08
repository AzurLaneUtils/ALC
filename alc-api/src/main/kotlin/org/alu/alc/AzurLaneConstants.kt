package org.alu.alc

interface AzurLaneConstants {
    /** 该类表示装备的稀有度(1*-6*) */
    class EquipableRarities : AzurLaneConstants {
        companion object : AzurLaneConstants {
            const val UNEQUIPPED = 0

            /** T1的装备会额外提供35的战力 */
            const val T1 = 35

            /** T2的装备会额外提供58的战力 */
            const val T2 = 58

            /** T3的装备会额外提供90的战力 */
            const val T3 = 90

            /** T4的装备会额外提供132的战力 */
            const val T4 = 132

            /** T5的装备会额外提供195的战力 */
            const val T5 = 195

            /** T6的装备会额外提供320的战力 */
            const val T6 = 320

            fun getBonus(i: Int): Int {
                return when (i) {
                    UNEQUIPPED -> StrengtheningBonus.UNEQUIPPED
                    T1 -> StrengtheningBonus.T1
                    T2 -> StrengtheningBonus.T2
                    T3 -> StrengtheningBonus.T3
                    T4 -> StrengtheningBonus.T4
                    T5 -> StrengtheningBonus.T5
                    T6 -> StrengtheningBonus.T6
                    else -> throw IllegalArgumentException()
                }
            }
        }
    }

    /** 该类表示装备的强化次数 */
    class StrengtheningLevel : AzurLaneConstants {
        companion object : AzurLaneConstants {
            const val PLUS0 = 0
            const val PLUS1 = 1
            const val PLUS2 = 2
            const val PLUS3 = 3
            const val PLUS4 = 4
            const val PLUS5 = 5
            const val PLUS6 = 6
            const val PLUS7 = 7
            const val PLUS8 = 8
            const val PLUS9 = 9
            const val PLUS10 = 10
            const val PLUS11 = 11
            const val PLUS12 = 12
            const val PLUS13 = 13
        }
    }

    class StrengtheningBonus : AzurLaneConstants {
        companion object : AzurLaneConstants {
            const val UNEQUIPPED = 0
            const val T1 = 5
            const val T2 = 8
            const val T3 = 10
            const val T4 = 12
            const val T5 = 15
            const val T6 = 20
        }
    }
}

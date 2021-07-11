package org.alu.alc

import org.alu.alc.internal.units.Buff
import org.alu.alc.internal.units.BuffCalculator

/**
 * 该类代表一个**主线**或**大型作战**的关卡
 *
 * 要求：各舰队元素互异
 * */
data class Chapter(
    val fleets: ArrayList<Fleet>,
    val submarine: Fleet = Fleet(Fleet.IS_SUBMARINE)
) {
    private val buffCalculator = BuffCalculator()

    /**
     * 获取在舰队中特定角色的buff后的真实属性
     * */
    fun actualAttrOfOne(btype: Type.BonusType, fpos: Int, spos: Fleet.Position): Double {
        if (fleets[fpos].isEmpty()) return 0.0
        val fleet = fleets[fpos]
        val thisShip = fleet.getShip(spos)
        val buffList = arrayListOf<Buff>()
        for (fl in fleets) {
            buffList.add(fl.getBuffOfTypeToAffectObject(btype, thisShip))
        }
        val mergedBuff = buffCalculator.mergeBuffs(buffList)
        buffCalculator.maximumTypes = max(mergedBuff.priorities.toIntArray())
        return fleet.getShip(spos).getTrulyAttr(btype) * buffCalculator.actualBuffOfOne(mergedBuff)
    }

    private fun max(numbers: IntArray): Int {
        var maximum: Int = numbers[0]
        for (e in numbers) {
            if (e > maximum) {
                maximum = e
            }
        }
        return maximum
    }
}
package org.alu.alc.core.chapters

import org.alu.alc.core.*
import org.alu.alc.core.helper.BuffCalculator

/**
 *
 * */
class MainlineChapter(
    private val first: Fleet,
    private val second: Fleet,
    private val submarine: Fleet
) : Chapter {
    private val buffCalculator = BuffCalculator()

    init {
        if (!first.isSurface || !second.isSurface) {
            throw InitException("the first fleet and the second fleet must be surface fleet.")
        }
        // 使俩舰队元素不同
        var p1: Fleet.Position
        var p2: Fleet.Position
        for (i in 1..6) {
            p1 = Fleet.Position.toPosition(i)
            for (j in 1..6) {
                p2 = Fleet.Position.toPosition(j)
                if (second.getShip(p2) == first.getShip(p1)) {
                    second.putShip(
                        second.getPosition(second.getShip(p2)),
                        Warship.makeDifference(second.getShip(p2))
                    )
                }
            }
        }
        // make different

    }

    fun actualAttrOfOne(btype: Type.BonusType, fpos: Int, spos: Fleet.Position): Double {
        if (fleetOf(fpos).isEmpty()) return 0.0
        val fleet = fleetOf(fpos)
        val thisShip = fleet.getShip(spos)
//        if (fleet.isSurface) {
//            val another = another(fleet)
//            if (another.haveWarship(thisShip)) {
//                another.putShip(another.getPosition(thisShip), Warship.makeDifference(fleet.getShip(spos)))
//            }
//        }
        val buff1 = this.first.getBuffOfTypeToAffectObject(btype, thisShip)
        val buff2 = this.second.getBuffOfTypeToAffectObject(btype, thisShip)
        val buffs = this.submarine.getBuffOfTypeToAffectObject(btype, thisShip)
        buffCalculator.maximumTypes = maximumOf(
            this.first.getMaximumTypes(),
            this.second.getMaximumTypes(),
            this.submarine.getMaximumTypes()
        )
        return fleet.getShip(spos).getTrulyAttr(btype) * buffCalculator.actualBuffOfOne(
            buffCalculator.mergeBuffs(buff1, buff2, buffs)
        )
    }

    override fun fleetOf(fpos: Int): Fleet =
        when (fpos) {
            1 -> first
            2 -> second
            3 -> submarine
            else -> Fleet(true)
        }

    private fun another(f: Fleet): Fleet =
        if (f == first) {
            second
        } else {
            first
        }

    private fun maximumOf(vararg numbers: Int): Int {
        var maximum: Int = numbers[0]
        for (e in numbers) {
            if (e > maximum) {
                maximum = e
            }
        }
        return maximum
    }
}
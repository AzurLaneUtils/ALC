package org.alu.alc.core

import org.alu.alc.core.internal.ShipSet

data class Fleet(
    val front: ShipSet,
    val rear: ShipSet
) {
    fun totalFirepower(): Int =
        useIf(front[0]).firepower + useIf(front[1]).firepower + useIf(front[2]).firepower +
                useIf(rear[0]).firepower + useIf(rear[1]).firepower + useIf(rear[2]).firepower

    private fun useIf(w: Warship?): Warship {
        return w ?: Warship.makeDefaultWarship()
    }
}

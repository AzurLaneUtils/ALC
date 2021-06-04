package org.alu.alc.core.units

import org.alu.alc.core.Warship

class ShipSet(
    private val _1: Warship?,
    private val _2: Warship?,
    private val _3: Warship?
) {
    operator fun get(i: Int): Warship? {
        if (i > 2 || i < 0) {
            return null
        } else {
            when (i) {
                0 -> _1
                1 -> _2
                2 -> _3
            }
        }
        return null
    }
}
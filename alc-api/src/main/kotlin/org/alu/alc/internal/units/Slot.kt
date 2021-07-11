package org.alu.alc.internal.units

import org.alu.alc.Equipable
import org.alu.alc.internal.Equipment

/**
 * 表示一个装备插槽
 * */
data class Slot(
    /** 当前的装备 */
    var equipment: Equipable,
    /** 该插槽的效率 */
    val efficiency: Double,
    /** 该插槽的底座 */
    val max: Int,
    /** 该是否预装填 */
    val isPrefilled: Boolean
) {
    constructor(equipment: Equipment) : this(equipment, 0.0, 0, false)
}

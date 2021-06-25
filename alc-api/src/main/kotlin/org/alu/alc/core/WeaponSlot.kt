package org.alu.alc.core

import org.alu.alc.core.Weapon

/**
 * 表示一个武器插槽
 *
 * */
data class WeaponSlot(
    /** 当前装备的武器 */
    var weapon: Weapon,
    /** 该武器插槽的效率 */
    val efficiency: Double,
    /** 该武器插槽的底座 */
    val max: Int,
    /** 该插槽是否预装填 */
    val isPrefilled: Boolean
)

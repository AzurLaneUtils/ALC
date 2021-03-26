package org.alu.AzurLaneCalculator.core.internal

import org.alu.AzurLaneCalculator.core.Weapon

/**
 * 表示一个武器插槽
 *
 * 如果您要构建该类的实例，您应该调用[com.xymul.AzurLaneCalculator.core.Warship.createWeaponSlot]
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

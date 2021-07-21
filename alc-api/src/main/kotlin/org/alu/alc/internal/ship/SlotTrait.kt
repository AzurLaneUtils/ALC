package org.alu.alc.internal.ship

import org.alu.alc.internal.annotations.ALUnit
import org.alu.alc.internal.annotations.IncorrectlyImplementation
import org.alu.alc.internal.annotations.Specialization
import org.alu.alc.internal.equ.Ammunition
import org.alu.alc.internal.equ.Equipment
import org.alu.alc.internal.equ.Equippable
import org.alu.alc.internal.equ.Weapon

@ALUnit
sealed class SlotTrait {
    /** 代表插槽中的物品 */
    @IncorrectlyImplementation
    abstract val item: Equippable?
}

// todo: make default weapon or equipment
@Specialization
data class WeaponSlot(
    /** 插槽中装备的武器 */
    override val item: Weapon<Ammunition>? = null,
    /** 插槽的效率 */
    val efficiency: Double = 0.0,
    /** 插槽的底座 */
    val max: Int = 0,
    /** 插槽是否提供预装填 */
    val isPrefilled: Boolean = false,
) : SlotTrait()

@Specialization
data class EquipmentSlot(
    override val item: Equipment? = null
) : SlotTrait()

package org.alu.alc.internal.units

import org.alu.alc.EquipableFactory
import org.alu.alc.Type
import org.alu.alc.internal.bonus
import org.alu.alc.internal.combatPower

/**
 * 作为舰船设备插槽的存储类
 * */
class EquipmentSlots {
    val equipments: Array<Slot> = Array(5) { Slot(EquipableFactory().newFilledEquipment()) }

    fun totalCombatPower(): Int {
        var cp = 0
        for (e in equipments) {
            cp += e.equipment.combatPower()
        }
        return cp
    }

    fun totalBonus(btype: Type.BonusType): Int {
        var bonus = 0
        for (slot in equipments) {
            bonus += slot.equipment.bonus(btype)
        }
        return bonus
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EquipmentSlots

        if (!equipments.contentEquals(other.equipments)) return false

        return true
    }

    override fun hashCode(): Int {
        return equipments.contentHashCode()
    }
}

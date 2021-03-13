package com.xymul.AzurLaneCalculator.core.helper

import com.xymul.AzurLaneCalculator.core.Equipment

/**
 * 作为舰船设备插槽的存储类
 * */
data class EquipmentSlots(
    var equipment: Array<Equipment>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EquipmentSlots

        if (!equipment.contentEquals(other.equipment)) return false

        return true
    }

    override fun hashCode(): Int {
        return equipment.contentHashCode()
    }
}

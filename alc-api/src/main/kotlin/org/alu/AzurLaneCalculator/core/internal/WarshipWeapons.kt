package org.alu.AzurLaneCalculator.core.internal

/**
 * 作为舰船武器插槽的存储类
 * */
data class WarshipWeapons(
    val slots: Array<WeaponSlot>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WarshipWeapons

        if (!slots.contentEquals(other.slots)) return false

        return true
    }

    override fun hashCode(): Int {
        return slots.contentHashCode()
    }
}

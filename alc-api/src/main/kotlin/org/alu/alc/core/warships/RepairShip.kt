package org.alu.alc.core.warships

import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.internal.EquipmentSlots
import org.alu.alc.core.internal.WarshipWeapons

/**
 * 表示一个维修舰
 * **Note**
 * */
class RepairShip(
    override val weaponSlots: WarshipWeapons,
    override val equipmentSlots: EquipmentSlots,
    override val name: String,
    override val level: Int,
    override val health: Int,
    override val armorType: Type.ArmorType,
    override val reload: Int,
    override val lucky: Int,
    override val evasion: Int,
    override val speed: Int,
    override val antiAircraft: Int,
    override val cost: Int,
    override val accuracy: Int,
    override val antiSubmarine: Int,
    override val affection: Warship.Affection
) : Warship {
    override val shipType: Type.ShipType = Type.ShipType.AR
    override val hasMainGun: Boolean = false
    override val hasTorpedo: Boolean = false
    override val hasSecondaryGun: Boolean = false
    override val hasAntiAircraftGun: Boolean = true
    override val aviation: Int = 0
    override val firepower: Int = 0
    override val torpedo: Int = 0
}
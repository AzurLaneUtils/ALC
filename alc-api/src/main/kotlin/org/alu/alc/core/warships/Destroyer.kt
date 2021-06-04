package org.alu.alc.core.warships

import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.units.EquipmentSlots
import org.alu.alc.core.units.WarshipWeapons

/**
 * 表示该舰船属于**驱逐舰**
 * */
class Destroyer(
    override val weaponSlots: WarshipWeapons,
    override val equipmentSlots: EquipmentSlots,
    override val name: String,
    override val level: Int,
    override val health: Int,
    override val armorType: Type.ArmorType,
    override val reload: Int,
    override val lucky: Int,
    override val firepower: Int,
    override val torpedo: Int,
    override val evasion: Int,
    override val speed: Int,
    override val antiAircraft: Int,
    override val cost: Int,
    override val accuracy: Int,
    override val antiSubmarine: Int,
    override val affection: Warship.Affection
) : Warship {
    override val shipType = Type.ShipType.DD
    override val hasAntiAircraftGun: Boolean = true
    override val hasTorpedo: Boolean = true
    override val hasSecondaryGun: Boolean = false
    override val hasMainGun: Boolean = true
    override val aviation: Int = 0
}

package org.alu.alc.core.warships

import org.alu.alc.core.Skill
import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.units.EquipmentSlots
import org.alu.alc.core.units.WarshipWeapons

/**
 * 表示一艘轻航
 * */
class LightAircraftCarrier(
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
    override val aviation: Int,
    override val cost: Int,
    override val accuracy: Int,
    override val antiSubmarine: Int,
    override val affection: Warship.Affection,
    override val skills: Array<Skill>,
    override val faction: Type.Faction
) : Warship {
    override val shipType: Type.ShipType = Type.ShipType.CVL
    override val hasMainGun: Boolean = false
    override val hasTorpedo: Boolean = false
    override val hasSecondaryGun: Boolean = false
    override val hasAntiAircraftGun: Boolean = true
    override val firepower: Int = 0
    override val torpedo: Int = 0
}
package org.alu.alc.core.warships

import org.alu.alc.core.Skill
import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.EquipmentSlots
import org.alu.alc.core.WarshipWeapons

/**
 * 表示该舰船属于轻巡洋舰或带有鱼雷的轻巡洋舰
 * */
class LightCruiser(
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
    override val hasTorpedo: Boolean,
    override val hasAntiAircraftGun: Boolean,
    override val affection: Warship.Affection,
    override val skills: Array<Skill>,
    override val faction: Type.Faction
) : Warship {
    override val shipType: Type.ShipType =
        if (hasTorpedo) Type.ShipType.CLT
        else Type.ShipType.CL
    override val hasMainGun: Boolean = true
    override val hasSecondaryGun: Boolean = !hasTorpedo
    override val aviation: Int = 0
}
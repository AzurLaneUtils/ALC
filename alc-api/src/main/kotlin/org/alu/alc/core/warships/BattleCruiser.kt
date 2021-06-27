package org.alu.alc.core.warships

import org.alu.alc.core.Skill
import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.helper.AttributesSet
import org.alu.alc.core.helper.EquipmentSlots
import org.alu.alc.core.helper.WarshipWeapons

data class BattleCruiser(
    override val weaponSlots: WarshipWeapons,
    override val equipmentSlots: EquipmentSlots,
    override val name: String,
    override val level: Int,
    override val attributes: AttributesSet,
    override val affection: Warship.Affection,
    override val skills: Array<Skill>,
    override val faction: Type.Faction
) : Warship {
    override val shipType: Type.ShipType = Type.ShipType.BC
    override val hasMainGun: Boolean = true
    override val hasTorpedo: Boolean = false
    override val hasSecondaryGun: Boolean = true
    override val hasAntiAircraftGun: Boolean = true
    override var flag: Long = System.nanoTime()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BattleCruiser

        if (weaponSlots != other.weaponSlots) return false
        if (equipmentSlots != other.equipmentSlots) return false
        if (name != other.name) return false
        if (level != other.level) return false
        if (attributes != other.attributes) return false
        if (affection != other.affection) return false
        if (!skills.contentEquals(other.skills)) return false
        if (faction != other.faction) return false
        if (shipType != other.shipType) return false
        if (hasMainGun != other.hasMainGun) return false
        if (hasTorpedo != other.hasTorpedo) return false
        if (hasSecondaryGun != other.hasSecondaryGun) return false
        if (hasAntiAircraftGun != other.hasAntiAircraftGun) return false
        if (flag != other.flag) return false

        return true
    }

    override fun hashCode(): Int {
        var result = weaponSlots.hashCode()
        result = 31 * result + equipmentSlots.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + level
        result = 31 * result + attributes.hashCode()
        result = 31 * result + affection.hashCode()
        result = 31 * result + skills.contentHashCode()
        result = 31 * result + faction.hashCode()
        result = 31 * result + shipType.hashCode()
        result = 31 * result + hasMainGun.hashCode()
        result = 31 * result + hasTorpedo.hashCode()
        result = 31 * result + hasSecondaryGun.hashCode()
        result = 31 * result + hasAntiAircraftGun.hashCode()
        result = 31 * result + flag.hashCode()
        return result
    }
}
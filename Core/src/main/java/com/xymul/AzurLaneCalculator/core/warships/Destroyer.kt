package com.xymul.AzurLaneCalculator.core.warships

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Warship
import com.xymul.AzurLaneCalculator.core.helper.EquipmentSLots
import com.xymul.AzurLaneCalculator.core.helper.WeaponSlots

/**
 * 表示该舰船属于**驱逐舰**
 * */
class Destroyer(
    override val affection: Warship.Affection,
    override val level: Int,
    override val name: String,
    override val health: Int,
    override val armorType: Type.ArmorType,
    override val reload: Int,
    override val lucky: Int,
    override val firepower: Int,
    override val torpedo: Int,
    override val evasion: Int,
    override val speed: Int,
    override val antiAircraft: Int,
    override val aviation: Int,
    override val cost: Int,
    override val accuracy: Int,
    override val antiSubmarine: Int,
    override val hasAntiAircraftGun: Boolean,
    override val weaponSlots: WeaponSlots,
    override val equipmentSLots: EquipmentSLots
) : Warship {
    override val shipType = Type.ShipType.DD
    override val hasTorpedo: Boolean = true
    override val hasSecondaryGun: Boolean = false
    override val hasMainGun: Boolean = true
}

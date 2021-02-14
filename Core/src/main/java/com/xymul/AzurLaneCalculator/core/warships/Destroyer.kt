package com.xymul.AzurLaneCalculator.core.warships

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Warship
import com.xymul.AzurLaneCalculator.core.helper.EquipmentSLots
import com.xymul.AzurLaneCalculator.core.helper.WeaponSlots

/**
 * 表示该舰船属于**驱逐舰**
 * */
class Destroyer(
    override var affection: Warship.Affection,
    override var level: Int,
    override var name: String,
    override var health: Int,
    override var armorType: Type.ArmorType,
    override var reload: Int,
    override var lucky: Int,
    override var firepower: Int,
    override var torpedo: Int,
    override var evasion: Int,
    override var speed: Int,
    override var antiAircraft: Int,
    override var aviation: Int,
    override var cost: Int,
    override var accuracy: Int,
    override var antiSubmarine: Int,
    override var hasMainGun: Boolean,
    override var hasTorpedo: Boolean,
    override var hasSecondaryGun: Boolean,
    override var hasAntiAircraftGun: Boolean,
    override val weaponSlots: WeaponSlots,
    override val equipmentSLots: EquipmentSLots
) : Warship {
    override val shipType = Type.ShipType.DD
}
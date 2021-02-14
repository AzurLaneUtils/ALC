package com.xymul.AzurLaneCalculator.core.weapons

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Weapon
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

/**
 * 表示该武器属于**防空炮**
 * */
class AntiAircraftGun(
    override val basicDamage: Int,
    override val shellType: Type.AntiAircraftType,
    override val efficiencyToArmor: ShellEfficiency,
    override val hit: Int,
    override val cd: Double,
    override val coefficient: Double,
    override val majorAttr: Int,
    override val levelOfWeapon: Int,
    override val name: String,
    override val rarity: Int,
    override val applicability: Array<Type.ShipType>
) : Weapon {
}
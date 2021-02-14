package com.xymul.AzurLaneCalculator.core.weapons

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Weapon
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

/**
 * 表示武器属于**舰载鱼雷**
 * */
class Torpedo(
    override val basicDamage: Int,
    override val shellType: Type.TorpedoType,
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
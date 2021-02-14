package com.xymul.AzurLaneCalculator.core.weapons

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Weapon
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

/**
 * 表示该武器属于**主炮/战列副炮**
 * */
class MainGun(
    override val basicDamage: Int,
    override val shellType: Type.ShellType,
    override val efficiencyToArmor: ShellEfficiency,
    override val hit: Int,
    override val cd: Double,
    override val coefficient: Double,
    override val majorAttr: Int,
    override val minorAttr: Int,
    override val minorAttrType: Type.BonusType?,
    override val levelOfWeapon: Int,
    override val name: String,
    override val rarity: Int,
    override val applicability: Array<Type.Applicability>
) : Weapon {
}
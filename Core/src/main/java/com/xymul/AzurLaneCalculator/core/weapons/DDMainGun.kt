package com.xymul.AzurLaneCalculator.core.weapons

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Weapon
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

/**
 * 表示该武器属于**dd主炮/战列副炮**
 * */
class DDMainGun(
    override val basicDamage: Int,
    override val shellType: Type.ShellType,
    override val efficiencyToArmor: ShellEfficiency,
    override val hit: Int,
    override val cd: Double,
    override val coefficient: Double,
    override val majorAttr: Int,
    override val minorAttr: Int,
    override val minorAttrType: Type.BonusType?,
    override val level: Int,
    override val name: String,
    override val rarity: Int,
) : Weapon {
    override val applicability: Array<Type.Applicability> = arrayOf(
        Type.Applicability.DD, Type.Applicability.BB,
        Type.Applicability.BC, Type.Applicability.CA,
        Type.Applicability.CL, Type.Applicability.CB // 目前游戏CB仅[吾妻]一艘，暂且认定为CB都可以装备DD炮
    )
}
package com.xymul.AzurLaneCalculator.core.weapons

import com.xymul.AzurLaneCalculator.core.Type
import com.xymul.AzurLaneCalculator.core.Weapon
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

class CLMainGun(
    override val basicDamage: Int,
    override val shellType: Type,
    override val efficiencyToArmor: ShellEfficiency,
    override val hit: Int,
    override val cd: Double,
    override val coefficient: Double,
    override val majorAttr: Int,
    override val level: Int,
    override val name: String,
    override val rarity: Int
) : Weapon {
    override val applicability: Array<Type.Applicability> = arrayOf(
        Type.Applicability.CL, Type.Applicability.BB, Type.Applicability.BC
    )
}
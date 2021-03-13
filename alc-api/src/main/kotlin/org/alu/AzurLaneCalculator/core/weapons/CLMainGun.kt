package org.alu.AzurLaneCalculator.core.weapons

import org.alu.AzurLaneCalculator.core.Type
import org.alu.AzurLaneCalculator.core.Weapon
import org.alu.AzurLaneCalculator.core.helper.ShellEfficiency

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
    override val applicability: Array<Type.Applicability> = Weapon.CLMainGunApplicability
}
package org.alu.alc.core.weapons

import org.alu.alc.core.Type
import org.alu.alc.core.Weapon
import org.alu.alc.core.helper.ShellEfficiency

/**
 * 表示该武器属于**dd主炮/战列副炮**
 *
 * **其主属性必须是炮击**
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
    override val applicability: Array<Type.Applicability> = Weapon.DDMainGunApplicability
}
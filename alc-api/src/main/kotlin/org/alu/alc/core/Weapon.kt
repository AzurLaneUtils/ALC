package org.alu.alc.core

import org.alu.alc.core.Type.Applicability.*
import org.alu.alc.core.internal.ShellEfficiency
import org.alu.alc.core.weapons.DDMainGun
import org.alu.alc.core.AzurLaneConstants.Companion.DEFAULT_NUMBER

interface Weapon {
    /** 武器的单发子弹伤害 */
    val basicDamage: Int

    /**
     * 武器的子弹类型，该类型必须是[Type.ShellType]、[Type.TorpedoType]、[Type.AerialBombType]或
     * [Type.AntiAircraftType]
     * */
    val shellType: Type

    /** 武器的对甲效率，可以使用[Weapon.makeEfficiencyToArmor]构造 */
    val efficiencyToArmor: ShellEfficiency

    /** 武器的子弹数 */
    val hit: Int

    /** 武器的cd */
    val cd: Double

    /** 武器系数 */
    val coefficient: Double

    /**
     * 武器的主属性
     * - 如果是舰炮，则该项属性类型必定是[Type.BonusType.FIREPOWER]
     * - 如果是鱼雷，则该项属性必定是[Type.BonusType.TORPEDO]，以此类推
     * - 目前已知武器除**可高平两用的舰炮**外，不存在副属性
     * */
    val majorAttr: Int

    /** 武器的副属性 */
    val minorAttr: Int
        get() = 0

    /** 武器的副属性类型 */
    val minorAttrType: Type.BonusType?
        get() = null

    /** 武器的等级，该属性必须是[AzurLaneConstants.StrengtheningLevel]中的一项 */
    val level: Int

    /** 武器的名字 */
    val name: String

    /** 武器的稀有度，该属性必须是[AzurLaneConstants.Rarities]中的一项 */
    val rarity: Int

    /** 武器的适用性，表示武器可以用于哪些舰船 */
    val applicability: Array<Type.Applicability>

    companion object {
        val aircraftApplicability: Array<Type.Applicability> = arrayOf(CV, CVL, CAV, BBV)
        val DDMainGunApplicability: Array<Type.Applicability> = arrayOf(DD, BB, BC, CA, CL, CB)
        val CLMainGunApplicability: Array<Type.Applicability> = arrayOf(CL, BB, BC)
        val CAMainGunApplicability: Array<Type.Applicability> = arrayOf(CA, CAT, CB)
        val BBMainGunApplicability: Array<Type.Applicability> = arrayOf(BB, BC, BBV, BM)
        val torpedoApplicability: Array<Type.Applicability> = arrayOf(DD, CLT, CAT)
        val antiAircraftGunApplicability: Array<Type.Applicability> = arrayOf(ALL)

        fun makeDefaultWeapon(): Weapon = DDMainGun(
            DEFAULT_NUMBER,
            Type.ShellType.COMMON,
            ShellEfficiency(
                DEFAULT_NUMBER.toDouble(),
                DEFAULT_NUMBER.toDouble(),
                DEFAULT_NUMBER.toDouble()
            ),
            DEFAULT_NUMBER,
            DEFAULT_NUMBER.toDouble(),
            DEFAULT_NUMBER.toDouble(),
            DEFAULT_NUMBER,
            DEFAULT_NUMBER,
            Type.BonusType.FIREPOWER,
            DEFAULT_NUMBER,
            "DEFAULT_WEAPON",
            AzurLaneConstants.Rarities.T6
        )
    }
}
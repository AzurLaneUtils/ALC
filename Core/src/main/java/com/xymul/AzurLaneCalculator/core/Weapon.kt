package com.xymul.AzurLaneCalculator.core

import com.sun.imageio.plugins.tiff.TIFFT4Compressor
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

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

    /** 武器的等级，该属性必须是[Weapon.WeaponLevel.Companion]中的一项 */
    val levelOfWeapon: Int

    /** 武器的名字 */
    val name: String
    /** 武器的稀有度，该属性必须是[Weapon.Rarities.Companion]中的一项 */
    val rarity: Int

    /** 武器的适用性，表示武器可以用于哪些舰船 */
    val applicability: Array<Type.Applicability>

    /**
     * 该类存储武器强化等级的常量。
     * 从PLUS0到PLUS13，依次对应+0到+13
     * */
    class WeaponLevel {
        companion object {
            const val PLUS0 = 0
            const val PLUS1 = 1
            const val PLUS2 = 2
            const val PLUS3 = 3
            const val PLUS4 = 4
            const val PLUS5 = 5
            const val PLUS6 = 6
            const val PLUS7 = 7
            const val PLUS8 = 8
            const val PLUS9 = 9
            const val PLUS10 = 10
            const val PLUS11 = 11
            const val PLUS12 = 12
            const val PLUS13 = 13
        }
    }

    /**
     * 该类存储武器稀有度的常量。
     * 从T1到T6，依次对应游戏中武器装备的星级
     * */
    class Rarities {
        companion object {
            const val T1 = 35
            const val T2 = 58
            const val T3 = 90
            const val T4 = 132
            const val T5 = 195
            const val T6 = 320
        }
    }

    companion object {
        /**
         * 创建[ShellEfficiency]的实例
         * */
        fun makeEfficiencyToArmor(light: Double, medium: Double, heavy: Double): ShellEfficiency =
            ShellEfficiency(light, medium, heavy)
    }
}
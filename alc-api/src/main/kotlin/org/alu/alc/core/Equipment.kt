package org.alu.alc.core

/**
 * 表示一个设备
 * @author Xymul
 *
 * // TODO: impl this
 */
interface Equipment {
    /**
     * 该属性表示该装备提供哪些加成，以及加成的值
     * */
    val attributes: Array<Pair<Type.BonusType, Int>> // todo

    /**
     * 该属性表示装备的强化等级，该值必须是[AzurLaneConstants.StrengtheningLevel]的一项
     */
    val level: Int

    /**
     * 表示装备的适用性(即可以装备于哪些舰船上)
     */
    val applicability: Array<Type.Applicability>

    /**
     * 表示装备的稀有度，该值必须是[AzurLaneConstants.Rarities]的一项
     * */
    val rarity: Int
}

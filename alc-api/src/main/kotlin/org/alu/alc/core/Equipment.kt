package org.alu.alc.core

import org.alu.alc.core.helper.AttributesSet

/**
 * 表示一个设备
 * @author Xymul
 *
 */
data class Equipment(
    val attributes: AttributesSet,
    /**
     * 该属性表示装备的强化等级，该值必须是[AzurLaneConstants.StrengtheningLevel]的一项
     */
    val level: Int,

    /**
     * 表示装备的适用性(即可以装备于哪些舰船上)
     */
    val applicability: Array<Type.Applicability>,

    /**
     * 表示装备的稀有度，该值必须是[AzurLaneConstants.Rarities]的一项
     * */
    val rarity: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Equipment

        if (attributes != other.attributes) return false
        if (level != other.level) return false
        if (!applicability.contentEquals(other.applicability)) return false
        if (rarity != other.rarity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = attributes.hashCode()
        result = 31 * result + level
        result = 31 * result + applicability.contentHashCode()
        result = 31 * result + rarity
        return result
    }
}

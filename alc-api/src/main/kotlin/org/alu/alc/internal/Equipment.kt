package org.alu.alc.internal

import org.alu.alc.Equipable
import org.alu.alc.Type
import org.alu.alc.internal.units.Attributes

/**
 * 表示一个设备
 * @author Xymul
 *
 */
data class Equipment(
    /** 装备的名称 */
    override val name: String,

    /**
     * 装备的属性列表
     * */
    override val attributes: Attributes,

    /**
     * 该属性表示装备的强化等级，该值必须是[AzurLaneConstants.StrengtheningLevel]的一项
     */
    override val level: Int,

    /**
     * 表示装备的稀有度，该值必须是[AzurLaneConstants.EquipableRarities]的一项
     * */
    override val rarity: Int,

    /**
     * 表示装备的适用性(即可以装备于哪些舰船上)
     */
    override val equippedShips: Array<Type.ShipType>
) : Equipable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Equipment

        if (attributes != other.attributes) return false
        if (level != other.level) return false
        if (!equippedShips.contentEquals(other.equippedShips)) return false
        if (rarity != other.rarity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = attributes.hashCode()
        result = 31 * result + level
        result = 31 * result + equippedShips.contentHashCode()
        result = 31 * result + rarity
        return result
    }
}

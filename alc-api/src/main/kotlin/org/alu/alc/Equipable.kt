package org.alu.alc

import org.alu.alc.Type
import org.alu.alc.internal.units.AttributesSet

interface Equipable {
    /** 加成属性列表 */
    val attributes: AttributesSet

    /** 等级，该属性必须是[AzurLaneConstants.StrengtheningLevel]中的一项 */
    val level: Int

    /** 名称 */
    val name: String

    /** 稀有度，该属性必须是[AzurLaneConstants.EquipableRarities]中的一项 */
    val rarity: Int

    /** 适用性，表示可以用于哪些舰船 */
    val equippedShips: Array<Type.ShipType>
}
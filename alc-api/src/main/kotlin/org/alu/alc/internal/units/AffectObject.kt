package org.alu.alc.internal.units

import org.alu.alc.Type
import java.io.Serializable

/**
 * 表示一个技能的应用对象
 * */
data class AffectObject(
    /** 技能是否作用于他人，这里的`他人`特指`本舰队`的其他舰船 */
    val toOthers: Boolean,
    /** 技能是否作用于自己 */
    val toSelf: Boolean,
    /** 该buff是否跨队 */
    val toOtherFleets: Boolean,
    /** 表示技能可作用的舰船，如果技能只作用于自己，则该值必须包含自己的舰船类型 */
    val affectShips: ArrayList<Type.ShipType>,
    /** 表示技能可作用的阵营，如果技能只作用于自己，则该值必须包含自己的阵营类型 */
    val affectFactions: ArrayList<Type.Faction>
) : Serializable

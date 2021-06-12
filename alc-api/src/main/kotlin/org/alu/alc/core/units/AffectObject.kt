package org.alu.alc.core.units

import org.alu.alc.core.Type
import java.io.Serializable

data class AffectObject(
    val toOthers: Boolean,
    val toSelf: Boolean,
    /** 表示技能可作用的舰船，如果技能只作用于自己，则该值必须包含自己的舰船类型 */
    val affectShips: ArrayList<Type.ShipType>,
    /** 表示技能可作用的阵营，如果技能只作用于自己，则该值必须包含自己的阵营类型 */
    val affectFactions: ArrayList<Type.Faction>
) : Serializable

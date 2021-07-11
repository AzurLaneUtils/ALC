package org.alu.alc.internal.units

import org.alu.alc.Type

data class Effect(
    /** 效果的加成类型 */
    val type: ArrayList<Type.BonusType>,
    /** 效果的加成值 */
    val values: ArrayList<Double>
)

package org.alu.alc.core.helper

import org.alu.alc.core.Type

data class Effects(
    /** 效果的加成类型 */
    val type: ArrayList<Type.BonusType>,
    /** 效果的加成值 */
    val values: ArrayList<Double>
)

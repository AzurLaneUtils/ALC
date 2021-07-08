package org.alu.alc.internal.units

/**
 * 作为炮弹补正的存储类
 * */
data class ShellEfficiency(
    val toLightArmor: Double,
    val toMediumArmor: Double,
    val toHeavyArmor: Double
)

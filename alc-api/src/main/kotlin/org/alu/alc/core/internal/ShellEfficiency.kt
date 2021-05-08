package org.alu.alc.core.internal

/**
 * 作为炮弹补正的存储类
 * */
data class ShellEfficiency(
    val toLightArmor: Double,
    val toMediumArmor: Double,
    val toHeavyArmor: Double
)

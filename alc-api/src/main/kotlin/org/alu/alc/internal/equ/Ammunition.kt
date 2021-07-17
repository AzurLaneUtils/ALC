package org.alu.alc.internal.equ

import org.alu.alc.internal.annotations.ALUnit

/**
 * 代表一个炮弹实体
 *
 * 该类记录了一个[Weapon]所拥有炮弹的伤害、炮弹数量、以及三甲补正
 * */
@ALUnit
data class Ammunition(
    var damage: Int,
    var hits: Int,
    var toLight: Double,
    var toMedium: Double,
    var toHeavy: Double,
)

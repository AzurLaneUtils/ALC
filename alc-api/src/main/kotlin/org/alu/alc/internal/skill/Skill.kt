package org.alu.alc.internal.skill

import org.alu.alc.internal.BonusType
import org.alu.alc.internal.ShipType

data class Skill(
    val name: String,
    val desc: String,
    val cd: Double,
    private val number: Int
) {
    // buff的作用效果
    private val buffs = ArrayList<Double>(number)
    // buff的作用对象
    private val types = ArrayList<BonusType>(number)
    // buff的作用级别
    private val ranks = ArrayList<Int>(number)
    // buff的作用舰船
    private val ships = ArrayList<ShipType>(number)
    // buff的作用阵营
    private val factions = ArrayList<ShipType>(number)
    // 对应buff是否开启
    private val flags = ArrayList<Boolean>(number)
}

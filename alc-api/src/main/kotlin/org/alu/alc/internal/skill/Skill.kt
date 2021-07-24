/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.skill

import org.alu.alc.internal.Faction
import org.alu.alc.internal.BonusType
import org.alu.alc.internal.ShipType

data class Skill(
    /** 技能的名称 */
    val name: String,
    /** 技能的描述 */
    val desc: String,
    /** 技能的cd */
    val cd: Double,
    /** 技能所拥有buff的数量 */
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
    private val factions = ArrayList<Faction>(number)
    // 对应buff是否开启
    private val flags = ArrayList<Boolean>(number)
}

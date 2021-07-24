package org.alu.alc.internal.equ

import org.alu.alc.internal.Faction
import org.alu.alc.internal.skill.Skill

/**
 * 表示一个可装备对象
 *
 * 一个可装备对象包含以下基础属性:
 * 1) 名称
 * 2) 属性加成
 * 3) 技能 `(列表) **<待决>**`
 * 4) 装备所属阵营
 * */
interface Equippable {
    val name: String
    val bonuses: BonusAttributes
    val skill: Skill
    val faction: Faction
}

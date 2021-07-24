/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.equ

import org.alu.alc.internal.Faction
import org.alu.alc.internal.skill.Skill

/**
 * 表示*AzurLane*中的一个武器
 *
 * 武器所包含的基本属性如下:
 * 1) 伤害列表
 * 2) cd
 * 3) 个体补正
 * 4) 大型作战塞壬增伤
 * 5) 索敌角度
 * 6) 索敌范围
 * 10) 伤害类型 **<待决>**
 * */
sealed class Weapon<At : Ammunition> : Equippable {
    abstract override val name: String
    abstract override val bonuses: BonusAttributes
    abstract override val skill: Skill
    abstract override val faction: Faction
    /** 武器的炮弹列表 */
    abstract val ammunitionList: ArrayList<At>
    abstract val cd: Double
    abstract val coef: Double
    abstract val bonusToSeren: Double
    abstract val angle: Int
    abstract val range: IntRange
    // wait for discuss: abstract val dmgType: BonusType
}

/**
 * 表示一个攻击模式为**锁定**的主炮
 *
 * 这类主炮的结构如下:
 * 1) 伤害 * HITs
 * 2) CD
 * 3) 加成
 * 4) 大型作战增伤
 * 5) 弹药 : { 飞行速度, 对甲比例 }
 * 6) 索敌范围
 * 7) 索敌角度
 * 8) 弹药射程 <- wait for impl
 * 9) 散步角度
 * 10) 阵营
 * 11) 个体补正
 * 12) 属性效率
 * */
data class LockOnGun(
    override val name: String,
    override val bonuses: BonusAttributes,
    override val skill: Skill,
    override val faction: Faction,
    override val ammunitionList: ArrayList<Cannon>,
    override val cd: Double,
    override val coef: Double,
    override val bonusToSeren: Double,
    override val angle: Int,
    override val range: IntRange
) : Weapon<Cannon>()

/**
 * 表示一个攻击模式为**跨射**的主炮
 *
 * 这类主炮的结构如下:
 * 1) 伤害 * HITs
 * 2) CD
 * 3) 加成
 * 4) 大型作战增伤
 * 5) 弹药 : { 飞行速度, 对甲比例, 伤害范围 }
 * 6) 散步范围
 * 7) 索敌范围
 * 8) 索敌角度
 * 9) 阵营
 * 10) 个体补正
 * 11) 属性效率
 * */
data class BracketingGun(
    override val name: String,
    override val bonuses: BonusAttributes,
    override val skill: Skill,
    override val faction: Faction,
    override val ammunitionList: ArrayList<Cannon>,
    override val cd: Double,
    override val coef: Double,
    override val bonusToSeren: Double,
    override val angle: Int,
    override val range: IntRange
) : Weapon<Cannon>()

data class AntiAircraft(
    override val name: String,
    override val bonuses: BonusAttributes,
    override val skill: Skill,
    override val faction: Faction,
    override val ammunitionList: ArrayList<AACannon>,
    override val cd: Double,
    override val coef: Double,
    override val bonusToSeren: Double,
    override val angle: Int,
    override val range: IntRange
) : Weapon<AACannon>()

data class Aircraft(
    override val name: String,
    override val bonuses: BonusAttributes,
    override val skill: Skill,
    override val faction: Faction,
    override val ammunitionList: ArrayList<Cannon>,
    override val cd: Double,
    override val coef: Double,
    override val bonusToSeren: Double,
    override val angle: Int,
    override val range: IntRange
) : Weapon<Cannon>()
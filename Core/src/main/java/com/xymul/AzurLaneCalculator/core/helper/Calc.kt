package com.xymul.AzurLaneCalculator.core

import com.xymul.AzurLaneCalculator.core.Type.ArmorType
import com.xymul.AzurLaneCalculator.core.helper.CalculateResult
import com.xymul.AzurLaneCalculator.core.helper.ShellEfficiency

import kotlin.random.Random

private val randomGenerator = Random(31);

// 战斗相关

/**
 * 基本伤害计算
 *
 * @param totalAttribute 角色的某项属性(加上装备加成的数值)
 * @param attributeEfficiency 属性效率
 * @param weaponBasicDamage 武器单发伤害
 * @param weaponCoefficient 武器系数
 * @param slotEfficiency 装备效率
 * @param efficiencyToArmor 该武器弹药的对甲效率
 * @param armorType 敌人的装甲类型
 * @param ownLevel 自身的等级
 * @param enemyLevel 地方的等级
 * @param isCrit 是否暴击
 * @param critMultiplier 如果暴击，暴击的倍率
 * */
fun basicActualDamage(
    totalAttribute: Int,
    attributeEfficiency: Double,
    weaponBasicDamage: Int,
    weaponCoefficient: Double,
    slotEfficiency: Double,
    efficiencyToArmor: ShellEfficiency,
    armorType: ArmorType,
    ownLevel: Int = 120,
    enemyLevel: Int = 120,
    isCrit: Boolean = false,
    critMultiplier: Double = 1.5
): CalculateResult {
    val lb = levelBonus(ownLevel - enemyLevel)
    val r = randomGenerator.nextInt(0, 2)
    val basicDmg = when (armorType) {
        ArmorType.LIGHT_ARMOR ->
            ((1 + totalAttribute / 100 * attributeEfficiency) * weaponBasicDamage * slotEfficiency * weaponCoefficient + r) * efficiencyToArmor.toLightArmor * lb
        ArmorType.MEDIUM_ARMOR ->
            ((1 + totalAttribute / 100 * attributeEfficiency) * weaponBasicDamage * slotEfficiency * weaponCoefficient + r) * efficiencyToArmor.toMediumArmor * lb
        ArmorType.HEAVY_ARMOR ->
            ((1 + totalAttribute / 100 * attributeEfficiency) * weaponBasicDamage * slotEfficiency * weaponCoefficient + r) * efficiencyToArmor.toHeavyArmor * lb
    }
    return if (isCrit) {
        CalculateResult(basicDmg * critMultiplier, true, null)
    } else {
        CalculateResult(basicDmg, true, null)
    }
}

/**
 * 获取等级加成的系数，
 * 如果[levelDifference] > 25，返回1.5，如果[levelDifference] < -25，返回0.5
 *
 * @param levelDifference 敌我等级差(我方等级 - 敌方等级)
 */
fun levelBonus(levelDifference: Int): Double =
    when {
        levelDifference > 25 -> 1.5
        levelDifference < -25 -> 0.5
        else -> levelDifference * 0.02
    }

fun burnDamage() : CalculateResult {
    TODO()
}

// todo: 减伤公式


// todo: 属性相关


// todo: 战斗相关


// todo: 经验相关


// todo: 油耗相关
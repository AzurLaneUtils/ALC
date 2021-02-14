package com.xymul.AzurLaneCalculator.core

/**
 * 表示一个设备
 * @author Xymul
 */
interface Equipment {
    val attributes: Map<Type.BonusType, Int>
    val rarity: Int
}

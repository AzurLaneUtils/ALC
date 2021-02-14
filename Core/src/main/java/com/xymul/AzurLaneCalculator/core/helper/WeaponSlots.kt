package com.xymul.AzurLaneCalculator.core.helper

import com.xymul.AzurLaneCalculator.core.Weapon

/**
 * 作为舰船武器插槽的存储类
 * */
data class WeaponSlots(
    var weaponSlot1: Weapon,
    var slot1Efficiency: Double,
    var slot1Max: Int,
    var weaponSlot2: Weapon,
    var slot2Efficiency: Double,
    var slot2Max: Int,
    var weaponSlot3: Weapon,
    var slot3Efficiency: Double,
    var slot3Max: Int
)

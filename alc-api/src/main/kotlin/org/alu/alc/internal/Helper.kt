package org.alu.alc.internal

import org.alu.alc.AzurLaneConstants
import org.alu.alc.Equipable
import org.alu.alc.Type

fun Equipable.bonus(bonusType: Type.BonusType): Int {
    return when (bonusType) {
        Type.BonusType.FIREPOWER -> this.attributes.firepower
        Type.BonusType.TORPEDO -> this.attributes.torpedo
        Type.BonusType.ANTI_AIRCRAFT -> this.attributes.antiAircraft
        Type.BonusType.HEALTH -> this.attributes.health
        Type.BonusType.RELOAD -> this.attributes.reload
        Type.BonusType.LUCK -> this.attributes.luck
        Type.BonusType.AVIATION -> this.attributes.aviation
        Type.BonusType.ACCURACY -> this.attributes.accuracy
        Type.BonusType.SPEED -> this.attributes.speed
        Type.BonusType.EVASION -> this.attributes.evasion
        Type.BonusType.ANTI_SUBMARINE -> this.attributes.antiSubmarine
        else -> throw IllegalArgumentException()
    }
}

/** 获取装备/武器的综合性能加成值 */
fun Equipable.combatPower(): Int =
    this.rarity
        .plus(this.level * AzurLaneConstants.EquipableRarities.getBonus(this.rarity))
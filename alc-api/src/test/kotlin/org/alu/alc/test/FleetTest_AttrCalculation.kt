package org.alu.alc.test

import org.alu.alc.core.Fleet
import org.alu.alc.core.Skill
import org.alu.alc.core.Type.*
import org.alu.alc.core.Warship
import org.alu.alc.core.units.AffectObject
import org.alu.alc.core.units.EquipmentSlots
import org.alu.alc.core.units.WarshipWeapons
import org.alu.alc.core.warships.BattleShip

fun main() {
    val fuso = BattleShip(
        WarshipWeapons(arrayOf()),
        EquipmentSlots(arrayOf()),
        "Fuso",
        120,
        7266,
        ArmorType.HEAVY_ARMOR,
        134,
        13,
        390,
        0,
        31,
        23,
        303,
        13,
        // unknown accuracy
        100,
        0,
        Warship.Affection.LOVE,
        arrayOf(
            Skill(
                "自身炮击提高10.0%(20.0%)",
                arrayOf(Pair(arrayListOf(BonusType.FIREPOWER), 0.2)),
                10,
                true,
                intArrayOf(0),
                AffectObject(false, true, arrayListOf(ShipType.BB), arrayListOf(Faction.SAKURA_EMPIRE))
            )
        ),
        Faction.SAKURA_EMPIRE
    )
    val nagato = BattleShip(
        WarshipWeapons(arrayOf()),
        EquipmentSlots(arrayOf()),
        "Nagato",
        120,
        7266,
        ArmorType.HEAVY_ARMOR,
        134,
        13,
        390,
        0,
        31,
        23,
        303,
        13,
        // unknown accuracy
        100,
        0,
        Warship.Affection.LOVE,
        arrayOf(
            Skill(
                "作为旗舰出击时，队伍中的重樱角色炮击提高4.0%（10.0%），" +
                        "装填、命中提高5.0%（20.0%），" +
                        "重樱航母造成的伤害提高5.0%（20.0%）",
                arrayOf(
                    Pair(arrayListOf(BonusType.FIREPOWER), 0.1),
                    Pair(arrayListOf(BonusType.ACCURACY, BonusType.RELOAD), 0.2),
                    Pair(arrayListOf(BonusType.DAMAGE), 0.2)
                ),
                10,
                true,
                intArrayOf(0, 0, 1),
                AffectObject(
                    true,
                    true,
                    arrayListOf(ShipType.BB, ShipType.BB, ShipType.CV),
                    arrayListOf(Faction.SAKURA_EMPIRE)
                )
            )
        ),
        Faction.SAKURA_EMPIRE
    )
    val fleet = Fleet()
    fleet.putShip(Fleet.Position.B1, fuso)
    fleet.putShip(Fleet.Position.B2, nagato)
    println(
        fleet.trueAttrOfOne(BonusType.FIREPOWER, Fleet.Position.B1)
    )
}
package org.alu.alc.test

import org.alu.alc.core.Fleet
import org.alu.alc.core.Skill
import org.alu.alc.core.Type
import org.alu.alc.core.Warship
import org.alu.alc.core.chapters.MainlineChapter
import org.alu.alc.core.helper.*
import org.alu.alc.core.warships.*

fun main() {
    val warship1 = BattleShip(
        WarshipWeapons(
            arrayOf()
        ),
        EquipmentSlots(
            arrayOf()
        ),
        "SelfBuffShip",
        120,
        AttributesSet(
            100,
            Type.ArmorType.HEAVY_ARMOR,
            120,
            0,
            400,
            0,
            0,
            10,
            0,
            0,
            10,
            100,
            0
        ),
        Warship.Affection.LOVE,
        arrayOf(
            Skill(
                "炮击+20%",
                Effects(arrayListOf(Type.BonusType.FIREPOWER), arrayListOf(0.2)),
                +10,
                true,
                arrayListOf(0),
                AffectObject(
                    false,
                    true,
                    false,
                    arrayListOf(Type.ShipType.BB),
                    arrayListOf(Type.Faction.SAKURA_EMPIRE)
                ),
                0.0
            )
        ),
        Type.Faction.SAKURA_EMPIRE
    )
    val warship2 = BattleShip(
        WarshipWeapons(
            arrayOf()
        ),
        EquipmentSlots(
            arrayOf()
        ),
        "OtherBuffShip",
        120,
        AttributesSet(
            100,
            Type.ArmorType.HEAVY_ARMOR,
            120,
            0,
            400,
            0,
            0,
            10,
            0,
            0,
            10,
            100,
            0
        ),
        Warship.Affection.LOVE,
        arrayOf(
            Skill(
                "炮击+20%",
                Effects(arrayListOf(Type.BonusType.FIREPOWER), arrayListOf(0.2)),
                +10,
                true,
                arrayListOf(0),
                AffectObject(
                    true,
                    false,
                    true,
                    arrayListOf(Type.ShipType.BB),
                    arrayListOf(Type.Faction.SAKURA_EMPIRE)
                ),
                0.0
            )
        ),
        Type.Faction.SAKURA_EMPIRE
    )

    val fleet = Fleet(Fleet.IS_SURFACE)
    fleet.putShip(Fleet.Position.B1, warship1)
    fleet.putShip(Fleet.Position.B2, warship2)

    println(
        fleet.actualAttrOfOne(
            Type.BonusType.FIREPOWER,
            fleet.getPosition(warship1)
        )
    )

    val fleet2 = Fleet(Fleet.IS_SURFACE)
    fleet2.putShip(Fleet.Position.B1, warship1)
    fleet2.putShip(Fleet.Position.B2, warship2)

    val f2ps1 = fleet2.getPosition(warship1)

    val attr = MainlineChapter(
        fleet,
        fleet2,
        Fleet(Fleet.IS_SUBMARINE)
    ).actualAttrOfOne(Type.BonusType.FIREPOWER, 2, f2ps1)

    println(attr)
}
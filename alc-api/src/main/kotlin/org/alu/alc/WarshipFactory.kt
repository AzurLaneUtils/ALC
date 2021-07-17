package org.alu.alc

import org.alu.alc.internal.ArmorType
import org.alu.alc.internal.Faction
import org.alu.alc.internal.ShipType
import org.alu.alc.internal.ship.ShipAttributes
import org.alu.alc.internal.ship.*
import org.alu.alc.internal.ship.Warship

fun Warship(
    shipType: ShipType,
    name: String,
    faction: Faction,
    affection: Double = 100.0,
    level: Int = 120,
    attrConfig: (attr: ShipAttributes) -> Unit
): Warship {
    val attr = ShipAttributes()
    attrConfig(attr)
    return when (shipType) {
        // todo: remove arrayListOf()
        ShipType.DD -> DD(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CL -> CL(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CLT -> CL(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CA -> CA(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CAT -> CAT(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CB -> CB(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.BB -> BB(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.BC -> BC(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.BBV -> BBV(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.BM -> BM(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.AR -> AR(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.SS -> SS(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.AS -> AS(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.AP -> AP(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CV -> CV(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
        ShipType.CVL -> CVL(name, faction, attr, affection, level, arrayListOf(), arrayListOf())
    }
}

fun Warship(other: Warship): Warship {
    return when (other.type) {
        ShipType.DD -> DD(other as DD)
        ShipType.CL -> CL(other as CL)
        ShipType.CLT -> CL(other as CL)
        ShipType.CA -> CA(other as CA)
        ShipType.CAT -> CAT(other as CAT)
        ShipType.CB -> CB(other as CB)
        ShipType.BB -> BB(other as BB)
        ShipType.BC -> BC(other as BC)
        ShipType.BBV -> BBV(other as BBV)
        ShipType.BM -> BM(other as BM)
        ShipType.AR -> AR(other as AR)
        ShipType.SS -> SS(other as SS)
        ShipType.AS -> AS(other as AS)
        ShipType.AP -> AP(other as AP)
        ShipType.CV -> CV(other as CV)
        ShipType.CVL -> CVL(other as CVL)
    }
}

fun newUniversalBulin(): Warship {
    return DD(
        name = "泛用性布里-200-120-100.0-FULL",
        Faction.OTHERS,
        ShipAttributes(
            health = 232,
            ArmorType.LIGHT,
            reload = 116,
            firepower = 23,
            torpedo = 23,
            evasion = 116,
            antiAircraft = 23,
            aviation = 23,
            cost = 3,
            antiSubmarine = 23,
            speed = 35,
            luck = 100,
            accuracy = 50
        ),
        100.0,
        120,
        arrayListOf(),
        arrayListOf()
    )
}

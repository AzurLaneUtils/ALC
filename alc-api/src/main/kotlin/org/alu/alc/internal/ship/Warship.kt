package org.alu.alc.internal.ship

import org.alu.alc.internal.Faction
import org.alu.alc.internal.ShipType
import org.alu.alc.internal.skill.Barrage
import org.alu.alc.internal.skill.Skill

sealed class Warship(
    val name: String,

    val type: ShipType,

    val faction: Faction,

    val attributes: ShipAttributes,

    val affection: Double,

    val level: Int,

    val skills: List<Skill>,

    val barrages: List<Barrage>
) {
    private val slots: ShipSlots = ShipSlots.makeSlotsByShipType(this.type)

    operator fun component1(): String = String(this.name.toCharArray())
    operator fun component2(): ShipType = this.type
    operator fun component3(): Faction = this.faction
    operator fun component4(): ShipAttributes = ShipAttributes(this.attributes)
    operator fun component5(): Double = this.affection
    operator fun component6(): Int = this.level
    operator fun component7(): List<Skill> = this.skills
    operator fun component8(): List<Barrage> = this.barrages
    operator fun component9(): ShipSlots = this.slots
}

class DD(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.DD, faction, attributes, affection, level, skills, barrages) {
    constructor(other: DD) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CL(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CL, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CL) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CA(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CA, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CA) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CB(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CB, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CB) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CLT(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CLT, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CLT) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CAT(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CAT, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CAT) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class BB(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.BB, faction, attributes, affection, level, skills, barrages) {
    constructor(other: BB) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class BC(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.BC, faction, attributes, affection, level, skills, barrages) {
    constructor(other: BC) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class BM(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.BM, faction, attributes, affection, level, skills, barrages) {
    constructor(other: BM) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class BBV(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.BBV, faction, attributes, affection, level, skills, barrages) {
    constructor(other: BBV) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CV(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CV, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CV) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class CVL(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.CVL, faction, attributes, affection, level, skills, barrages) {
    constructor(other: CVL) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class AR(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.AR, faction, attributes, affection, level, skills, barrages) {
    constructor(other: AR) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class SS(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.SS, faction, attributes, affection, level, skills, barrages) {
    constructor(other: SS) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class AS(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.AS, faction, attributes, affection, level, skills, barrages) {
    constructor(other: AS) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}

class AP(
    name: String,
    faction: Faction,
    attributes: ShipAttributes,
    affection: Double,
    level: Int,
    skills: List<Skill>,
    barrages: List<Barrage>
) : Warship(name, ShipType.AP, faction, attributes, affection, level, skills, barrages) {
    constructor(other: AP) : this(
        other.name,
        other.faction,
        ShipAttributes(other.attributes),
        other.affection,
        other.level,
        ArrayList<Skill>(other.skills),
        other.barrages,
    )
}
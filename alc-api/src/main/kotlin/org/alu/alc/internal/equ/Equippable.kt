package org.alu.alc.internal.equ

import org.alu.alc.internal.ShipType
import org.alu.alc.internal.skill.Skill

interface Equippable {
    val name: String
    val bonuses: BonusAttributes
    val skill: Skill
}

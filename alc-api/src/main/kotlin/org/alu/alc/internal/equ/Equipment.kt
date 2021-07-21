package org.alu.alc.internal.equ

import org.alu.alc.internal.Faction
import org.alu.alc.internal.skill.Skill

data class Equipment(
    override val name: String,
    override val bonuses: BonusAttributes = BonusAttributes(),
    override val skill: Skill,
    override val faction: Faction
) : Equippable
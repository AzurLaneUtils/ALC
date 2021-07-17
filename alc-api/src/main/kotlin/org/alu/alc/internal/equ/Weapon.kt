package org.alu.alc.internal.equ

import org.alu.alc.internal.skill.Skill

sealed class Weapon : Equippable {
    /** 武器的炮弹列表 */
    abstract val ammunitionList: ArrayList<Ammunition>
    // todo
}

data class Gun(
    override val name: String,
    override val bonuses: BonusAttributes = BonusAttributes(),
    override val skill: Skill,
    override val ammunitionList: ArrayList<Ammunition>
) : Weapon()

data class Aircraft(
    override val name: String,
    override val bonuses: BonusAttributes = BonusAttributes(),
    override val skill: Skill,
    override val ammunitionList: ArrayList<Ammunition>
) : Weapon()
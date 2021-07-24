/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.equ

import org.alu.alc.internal.Faction
import org.alu.alc.internal.skill.Skill

data class Equipment(
    override val name: String,
    override val bonuses: BonusAttributes = BonusAttributes(),
    override val skill: Skill,
    override val faction: Faction
) : Equippable
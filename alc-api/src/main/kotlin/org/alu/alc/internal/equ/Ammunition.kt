/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.equ

import org.alu.alc.internal.AmmuType
import org.alu.alc.internal.annotations.ALUnit

@ALUnit
sealed class Ammunition(
    var damage: Int,
    var hits: Int,
    var toLight: Double,
    var toMedium: Double,
    var toHeavy: Double,
    var type: AmmuType
)

class AACannon(
    damage: Int
) : Ammunition(damage, 1, 0.0, 0.0, 0.0, AmmuType.AA)

/** 表示**主炮**的弹药 */
class Cannon(
    damage: Int,
    hits: Int,
    toLight: Double,
    toMedium: Double,
    toHeavy: Double,
    /** 炮弹的飞行速度 */
    var speed: Int,
    /** 炮弹的伤害范围， */
    var dmgRange: Int,
    /** 表示炮弹的散步 */
    var spread: Int,
    type: AmmuType
) : Ammunition(damage, hits, toLight, toMedium, toHeavy, type)
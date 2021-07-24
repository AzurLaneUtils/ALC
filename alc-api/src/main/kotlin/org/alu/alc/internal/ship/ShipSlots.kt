/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.ship

import org.alu.alc.internal.ShipType
import org.alu.alc.internal.ShipType.*
import org.alu.alc.internal.annotations.ALUnit

@ALUnit
data class ShipSlots(
    private var _1: SlotTrait,
    private var _2: SlotTrait,
    private var _3: SlotTrait,
    private var _4: SlotTrait,
    private var _5: SlotTrait
) {
    constructor(other: ShipSlots): this(
        other._1,
        other._2,
        other._3,
        other._4,
        other._5
    )

    companion object {
        fun makeSlotsByShipType(type: ShipType): ShipSlots {
            return when (type) {
                DD, CL, CA, CB, CLT, CAT, BB, BC, BM, BBV, CV, CVL, SS, AS ->
                    ShipSlots(
                        WeaponSlot(),
                        WeaponSlot(),
                        WeaponSlot(),
                        EquipmentSlot(),
                        EquipmentSlot()
                    )
                AR -> ShipSlots(
                    EquipmentSlot(),
                    WeaponSlot(),
                    WeaponSlot(),
                    EquipmentSlot(),
                    EquipmentSlot()
                )
                AP -> ShipSlots(
                    WeaponSlot(),
                    WeaponSlot(),
                    EquipmentSlot(),
                    EquipmentSlot(),
                    EquipmentSlot()
                )
            }
        }
    }

    operator fun get(index: Int): SlotTrait =
        when (index) {
            0 -> _1
            1 -> _2
            2 -> _3
            3 -> _4
            4 -> _5
            else -> throw ArrayIndexOutOfBoundsException("index $index is out of the slot's max value: 5(index 4)")
        }
}

package org.alu.alc

import org.alu.alc.internal.Equipment
import org.alu.alc.internal.units.AttributesSet

// todo: impl
class EquipableFactory {
    private val equipableToAll = arrayOf(
        Type.ShipType.DD,
        Type.ShipType.CL,
        Type.ShipType.CLT,
        Type.ShipType.CA,
        Type.ShipType.CAT,
        Type.ShipType.CB,
        Type.ShipType.BB,
        Type.ShipType.BC,
        Type.ShipType.BBV,
        Type.ShipType.BM,
        Type.ShipType.CV,
        Type.ShipType.CVL,
        Type.ShipType.SS,
        Type.ShipType.AS,
        Type.ShipType.AP,
        Type.ShipType.AR
    )

    /**
     * 获取默认填充插槽的装备
     * */
    fun newFilledEquipment(): Equipment {
        return Equipment(
            "default",
            AttributesSet(),
            AzurLaneConstants.StrengtheningLevel.PLUS0,
            this.equipableToAll,
            AzurLaneConstants.EquipableRarities.UNEQUIPPED
        )
    }
}
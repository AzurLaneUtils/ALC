package org.alu.alc

import org.alu.alc.internal.Equipment
import org.alu.alc.internal.Weapon
import org.alu.alc.internal.units.Attributes

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
     * 获取默认填充插槽的武器
     * */
    fun newWeaponForFilling(): Weapon {
        return Weapon(
            "unequipped",
            Attributes(),
            AzurLaneConstants.StrengtheningLevel.PLUS0,
            AzurLaneConstants.EquipableRarities.UNEQUIPPED,
            this.equipableToAll,
            shells = arrayListOf(),
            -1.0,
            Double.MAX_VALUE,
            -1
        )
    }

    /**
     * 获取默认填充插槽的装备
     * */
    fun newEquipmentForFilling(): Equipment {
        return Equipment(
            "unequipped",
            Attributes(),
            AzurLaneConstants.StrengtheningLevel.PLUS0,
            AzurLaneConstants.EquipableRarities.UNEQUIPPED,
            this.equipableToAll
        )
    }
}
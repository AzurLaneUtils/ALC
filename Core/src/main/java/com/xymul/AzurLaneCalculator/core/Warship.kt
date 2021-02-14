package com.xymul.AzurLaneCalculator.core

import com.xymul.AzurLaneCalculator.core.helper.EquipmentSLots
import com.xymul.AzurLaneCalculator.core.helper.WeaponSlots

/**
 * 该接口代表一个舰船实体
 *
 * **NOTE**: 初始化任何属性时，必须是考虑**突破、改造、好感度加成**后的属性、即**游戏内面板属性**
 */
interface Warship {
    /** 舰船的武器插槽 */
    val weaponSlots: WeaponSlots
    /** 舰船的设备插槽 */
    val equipmentSLots: EquipmentSLots

    /** 舰船的名称 */
    var name: String
    /** 舰船的等级 */
    var level: Int

    /** 舰船的血量 */
    var health: Int
    /** 舰船的装甲类型 */
    var armorType: Type.ArmorType
    /** 舰船的装填属性 */
    var reload: Int
    /** 舰船的幸运属性 */
    var lucky: Int
    /** 舰船的炮击属性 */
    var firepower: Int
    /** 舰船的雷击属性 */
    var torpedo: Int
    /** 舰船的机动属性 */
    var evasion: Int
    /** 舰船的速度属性 */
    var speed: Int
    /** 舰船的防空属性 */
    var antiAircraft: Int
    /** 舰船的航空属性 */
    var aviation: Int
    /** 舰船的油耗 **/
    var cost: Int
    /** 舰船的命中属性 */
    var accuracy: Int
    /** 舰船的反潜属性 */
    var antiSubmarine: Int

    /** 舰船的类型 */
    val shipType: Type.ShipType

    /** 舰船是否拥有主炮 */
    var hasMainGun: Boolean
    /** 舰船是否拥有鱼雷 */
    var hasTorpedo: Boolean
    /** 舰船是否拥有副炮 */
    var hasSecondaryGun: Boolean
    /** 舰船是否拥有防空炮 */
    var hasAntiAircraftGun: Boolean

    /** 好感度 */
    var affection: Affection

    /** 代表一个船的好感度 */
    enum class Affection {
        OATH,
        LOVE,
        CRUSH,
        FRIENDLY,
        STRANGER,
        DISAPPOINTED
    }

    companion object {

        /**
         * 创建一个武器插槽的实例
         */
        fun createWeaponSlots(
            weaponSlot1: Weapon,
            slot1Efficiency: Double,
            slot1Max: Int,
            weaponSlot2: Weapon,
            slot2Efficiency: Double,
            slot2Max: Int,
            weaponSlot3: Weapon,
            slot3Efficiency: Double,
            slot3Max: Int
        ): WeaponSlots = WeaponSlots(
            weaponSlot1, slot1Efficiency, slot1Max,
            weaponSlot2, slot2Efficiency, slot2Max,
            weaponSlot3, slot2Efficiency, slot3Max,
        )
    }
}
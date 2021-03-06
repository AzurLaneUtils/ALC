package org.alu.AzurLaneCalculator.core

import org.alu.AzurLaneCalculator.core.helper.EquipmentSlots
import org.alu.AzurLaneCalculator.core.helper.WarshipWeapons

/**
 * 该接口代表一个舰船实体
 *
 * **NOTE**: 初始化任何属性时，必须是考虑**突破、改造、好感度加成**后的属性、即**游戏内面板属性**
 */
interface Warship {
    /** 舰船的武器插槽 */
    val weaponSlots: WarshipWeapons

    /** 舰船的设备插槽 */
    val equipmentSlots: EquipmentSlots

    /** 舰船的名称 */
    val name: String

    /** 舰船的等级 */
    val level: Int

    /** 舰船的血量 */
    val health: Int

    /** 舰船的装甲类型 */
    val armorType: Type.ArmorType

    /** 舰船的装填属性 */
    val reload: Int

    /** 舰船的幸运属性 */
    val lucky: Int

    /** 舰船的炮击属性 */
    val firepower: Int

    /** 舰船的雷击属性 */
    val torpedo: Int

    /** 舰船的机动属性 */
    val evasion: Int

    /** 舰船的速度属性 */
    val speed: Int

    /** 舰船的防空属性 */
    val antiAircraft: Int

    /** 舰船的航空属性 */
    val aviation: Int

    /** 舰船的油耗 **/
    val cost: Int

    /** 舰船的命中属性 */
    val accuracy: Int

    /** 舰船的反潜属性 */
    val antiSubmarine: Int

    /** 舰船的类型 */
    val shipType: Type.ShipType

    /** 舰船是否拥有主炮 */
    val hasMainGun: Boolean

    /** 舰船是否拥有鱼雷 */
    val hasTorpedo: Boolean

    /** 舰船是否拥有副炮 */
    val hasSecondaryGun: Boolean

    /** 舰船是否拥有防空炮 */
    val hasAntiAircraftGun: Boolean

    /** 好感度 */
    val affection: Affection

    /** 获取本舰船的防空减免值 */
    fun aircraftDamageReduction(): Double = (this.antiAircraft / (this.antiAircraft + 150.0))

    /** 代表一个船的好感度 */
    enum class Affection {
        /** 誓约200(200) */
        OATH200,
        /** 誓约(100-199.9) */
        OATH,
        /** 爱(100) */
        LOVE,
        /** 喜欢(80-99.9) */
        CRUSH,
        /** 友好(60-79.9) */
        FRIENDLY,
        /** 陌生(50-59.9) */
        STRANGER,
        /** 失望(0-49.9) */
        DISAPPOINTED
    }
}
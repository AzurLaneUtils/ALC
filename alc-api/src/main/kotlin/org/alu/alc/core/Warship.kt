package org.alu.alc.core

import org.alu.alc.core.AzurLaneConstants.Companion.DEFAULT_NUMBER
import org.alu.alc.core.Type.BonusType.*
import org.alu.alc.core.helper.AttributesSet
import org.alu.alc.core.helper.EquipmentSlots
import org.alu.alc.core.helper.WarshipWeapons
import org.alu.alc.core.helper.WeaponSlot
import org.alu.alc.core.Type.ShipType.*
import org.alu.alc.core.warships.*
import kotlin.random.Random

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

    /** 舰船的各项属性 */
    val attributes: AttributesSet

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

    /** 舰船的技能列表 */
    val skills: Array<Skill>

    /** 舰船的阵营 */
    val faction: Type.Faction

    /** 在其余属性相同时，表示舰船不同于其他舰船的标志 */
    var flag: Long

    // todo: 加上武器加成后的属性
    fun getTrulyAttr(btype: Type.BonusType): Int {
        return when (btype) {
            FIREPOWER -> attributes.firepower
            TORPEDO -> attributes.torpedo
            ANTI_AIRCRAFT -> attributes.antiAircraft
            HEALTH -> attributes.health
            RELOAD -> attributes.reload
            LUCKY -> attributes.lucky
            AVIATION -> attributes.aviation
            ACCURACY -> attributes.accuracy
            SPEED -> attributes.speed
            EVASION -> attributes.evasion
            ANTI_SUBMARINE -> attributes.antiSubmarine
            DAMAGE -> throw Exception("This kind of Type shouldn't appear here")
        }
    }

    companion object {
        fun makeDifference(ws: Warship): Warship {
            val updateTime: Warship.() -> Warship = { ->
                this.flag = System.nanoTime() //+ Random(32).nextLong() xor System.nanoTime()
                this
            }
            return when (ws.shipType) {
                DD -> updateTime((ws as Destroyer).copy())
                // v0.1.2021627 todo: 增加CLT和CAT的实现
                // 否则，会出现构造函数不统一的情况
                CL, CLT -> updateTime((ws as LightCruiser).copy())
                CA, CAT -> updateTime((ws as HeavyCruiser).copy())
                CB -> updateTime((ws as LargeCruiser).copy())
                CAV -> throw IllegalArgumentException("AzueLane have no class of CAV")
                BB -> updateTime((ws as BattleShip).copy())
                BC -> updateTime((ws as BattleCruiser).copy())
                BM -> updateTime((ws as BritishMonitor).copy())
                BBV -> updateTime((ws as AviationBattleship).copy())
                CV -> updateTime((ws as AircraftCarrier).copy())
                CVL -> updateTime((ws as LightAircraftCarrier).copy())
                AR -> updateTime((ws as RepairShip).copy())
                SS -> updateTime((ws as Submarine).copy())
            }
        }

        /**
         * 创建一个默认舰船
         *
         * 该舰船是[Fleet]的默认填充值，[Fleet]依靠此值判断舰队是否为空
         *
         * todo: 这里以后将采用序列化的方式，返回布里的数据
         * */
        fun makeDefaultWarship(): Warship {
            val ship = Destroyer(
                WarshipWeapons(
                    arrayOf(
                        WeaponSlot(
                            Weapon.makeDefaultWeapon(),
                            DEFAULT_NUMBER.toDouble(),
                            DEFAULT_NUMBER,
                            false
                        )
                    )
                ),
                EquipmentSlots(arrayOf()),
                "Buli",
                120,
                AttributesSet(
                    DEFAULT_NUMBER,
                    Type.ArmorType.LIGHT_ARMOR,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER,
                    DEFAULT_NUMBER
                ),
                Affection.OATH200,
                arrayOf(),
                Type.Faction.OTHERS
            )
            ship.flag = 1
            return ship
        }
    }

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
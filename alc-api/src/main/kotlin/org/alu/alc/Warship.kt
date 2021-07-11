package org.alu.alc

import org.alu.alc.Type.BonusType.*
import org.alu.alc.internal.units.Attributes
import org.alu.alc.internal.units.EquipmentSlots
import kotlin.math.floor

/**
 * 该类代表一个舰船实体
 *
 * **NOTE**: 初始化任何属性时，必须是考虑**突破、改造、好感度加成**后的属性、即**游戏内面板属性**
 */
data class Warship(
    /** 舰船的设备插槽 */
    val equipmentSlots: EquipmentSlots,

    /** 舰船的名称 */
    val name: String,

    /** 舰船的等级 */
    val level: Int,

    /** 舰船的各项属性 */
    val attributes: Attributes,

    /**
     * 舰船的装甲类型
     * */
    val armorType: Type.Armor,

    /** 舰船的类型 */
    val shipType: Type.ShipType,

    /** 舰船是否拥有主炮 */
    val hasMainGun: Boolean,

    /** 舰船是否拥有鱼雷 */
    val hasTorpedo: Boolean,

    /** 舰船是否拥有副炮 */
    val hasSecondaryGun: Boolean,

    /** 舰船是否拥有防空炮 */
    val hasAntiAircraftGun: Boolean,

    /** 好感度 */
    val affection: Affection,

    /** 舰船的技能列表 */
    val skills: ArrayList<Skill>,

    /** 舰船的阵营 */
    val faction: Type.Faction,

    /** 舰船的稀有度 */
    val rarity: Type.ShipRarity
) {
    /** 在其余属性相同时，表示舰船不同于其他舰船的标志 */
    var flag: Long = System.nanoTime()

    var reformColumn: Int = 0

    /** 获取一艘船的综合性能 */
    fun comprehensivePerformance(): Int {
        return floor((getTrulyAttr(HEALTH) * 0.2)).toInt() +
                getTrulyAttr(FIREPOWER) +
                getTrulyAttr(TORPEDO) +
                getTrulyAttr(AVIATION) +
                getTrulyAttr(ANTI_AIRCRAFT) +
                getTrulyAttr(RELOAD) +
                getTrulyAttr(ANTI_SUBMARINE) +
                getTrulyAttr(EVASION) * 2 +
                getTrulyAttr(ACCURACY) * 2 +
                equipmentSlots.totalCombatPower() +
                reformCp(reformColumn)
    }

    fun getTrulyAttr(btype: Type.BonusType): Int {
        return equipmentSlots.totalBonus(btype) + when (btype) {
            FIREPOWER -> attributes.firepower
            TORPEDO -> attributes.torpedo
            ANTI_AIRCRAFT -> attributes.antiAircraft
            HEALTH -> attributes.health
            RELOAD -> attributes.reload
            LUCK -> attributes.luck
            AVIATION -> attributes.aviation
            ACCURACY -> attributes.accuracy
            SPEED -> attributes.speed
            EVASION -> attributes.evasion
            ANTI_SUBMARINE -> attributes.antiSubmarine
            else -> throw Exception("This kind of Type shouldn't appear here")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Warship

        if (equipmentSlots != other.equipmentSlots) return false
        if (name != other.name) return false
        if (level != other.level) return false
        if (attributes != other.attributes) return false
        if (affection != other.affection) return false
        if (!skills.equals(other)) return false
        if (faction != other.faction) return false
        if (shipType != other.shipType) return false
        if (hasMainGun != other.hasMainGun) return false
        if (hasTorpedo != other.hasTorpedo) return false
        if (hasSecondaryGun != other.hasSecondaryGun) return false
        if (hasAntiAircraftGun != other.hasAntiAircraftGun) return false
        if (flag != other.flag) return false
        if (rarity != other.rarity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = equipmentSlots.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + level
        result = 31 * result + attributes.hashCode()
        result = 31 * result + affection.hashCode()
        result = 31 * result + skills.hashCode()
        result = 31 * result + faction.hashCode()
        result = 31 * result + shipType.hashCode()
        result = 31 * result + hasMainGun.hashCode()
        result = 31 * result + hasTorpedo.hashCode()
        result = 31 * result + hasSecondaryGun.hashCode()
        result = 31 * result + hasAntiAircraftGun.hashCode()
        result = 31 * result + flag.hashCode()
        result = 31 * result + rarity.hashCode()
        return result
    }

    private fun reformCp(reformColumn: Int): Int {
        var i = 1
        var cp = 0
        while (i <= reformColumn) {
            cp += 5 + i * 5
            ++i
        }
        return cp
    }

    companion object {
        fun makeDifference(ws: Warship): Warship {
            val updateTime: Warship.() -> Warship = { ->
                this.flag = System.nanoTime() //+ Random(32).nextLong() xor System.nanoTime()
                this
            }
            return updateTime(ws.copy())
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
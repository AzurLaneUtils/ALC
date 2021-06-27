package org.alu.alc.core.helper

import org.alu.alc.core.Type

data class AttributesSet(
    /** 舰船的血量或装备加成的血量 */
    val health: Int,

    /**
     * 舰船的装甲类型或装备改变的装甲类型
     *
     * 如果装备不改变装甲类型，则此值应和舰船装甲类型相同
     * */
    val armorType: Type.ArmorType,

    /** 舰船的装填属性或装备加成的装填 */
    val reload: Int,

    /** 舰船的幸运属性或装备加成的幸运 */
    val lucky: Int,

    /** 舰船的炮击属性或装备加成的炮击 */
    val firepower: Int,

    /** 舰船的雷击属性或装备加成的雷击 */
    val torpedo: Int,

    /** 舰船的机动属性或装备加成的机动 */
    val evasion: Int,

    /** 舰船的速度属性或装备加成的速度 */
    val speed: Int,

    /** 舰船的防空属性或装备加成的防空 */
    val antiAircraft: Int,

    /** 舰船的航空属性或装备加成的航空 */
    val aviation: Int,

    /** 舰船的油耗 */
    val cost: Int,

    /** 舰船的命中属性或装备加成的命中 */
    val accuracy: Int,

    /** 舰船的反潜属性或装备加成的反潜 */
    val antiSubmarine: Int
) {
}
package org.alu.alc.internal.ship

import org.alu.alc.internal.ArmorType
import org.alu.alc.internal.annotations.ALUnit

@ALUnit
data class ShipAttributes(
    /** 舰船的血量或装备加成的血量 */
    var health: Int = 0,

    /** 舰船的装甲类型 */
    var armor: ArmorType = ArmorType.LIGHT,

    /** 舰船的装填属性 */
    var reload: Int = 0,

    /** 舰船的炮击属性 */
    var firepower: Int = 0,

    /** 舰船的雷击属性 */
    var torpedo: Int = 0,

    /** 舰船的机动属性 */
    var evasion: Int = 0,

    /** 舰船的防空属性 */
    var antiAircraft: Int = 0,

    /** 舰船的航空属性 */
    var aviation: Int = 0,

    /** 舰船的油耗 */
    var cost: Int = 0,

    /** 舰船的反潜属性*/
    var antiSubmarine: Int = 0,

    /** 舰船的速度属性 */
    var speed: Int = 0,

    /** 舰船的幸运属性 */
    var luck: Int = 0,

    /** 舰船的命中属性 */
    var accuracy: Int = 0
) {
    constructor(other: ShipAttributes) : this(
        other.health,
        other.armor,
        other.reload,
        other.firepower,
        other.torpedo,
        other.evasion,
        other.antiAircraft,
        other.aviation,
        other.cost,
        other.antiSubmarine,
        other.speed,
        other.luck,
        other.accuracy
    )
}

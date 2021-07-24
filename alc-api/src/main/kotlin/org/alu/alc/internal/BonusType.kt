package org.alu.alc.internal

enum class BonusType {
    FIREPOWER,
    TORPEDO,
    ANTI_AIRCRAFT,
    HEALTH,
    RELOAD,
    LUCK,
    AVIATION,
    ACCURACY,
    SPEED,
    EVASION,
    ANTI_SUBMARINE,

    /**
     * 伤害加成类型，无论是对方的易伤(+)/伤害减免(-)还是己方的增伤(+)都用此枚举表示
     * */
    DAMAGE,

    /**
     * 伤害减免类型，无论是对方的减伤(+)还是己方的伤害减免(+)/易伤(-)都用此枚举表示
     * */
    DAMAGE_REDUCTION
}
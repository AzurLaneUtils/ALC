package com.xymul.AzurLaneCalculator.core

/**
 * 该接口是[com.xymul.AzurLaneCalculator.core.Type]下所有内部类的父接口，用于表示各种类型
 * */
interface Type {
    /**
     * 表示装甲类型
     * */
    enum class ArmorType : Type {
        LIGHT_ARMOR,
        MEDIUM_ARMOR,
        HEAVY_ARMOR
    }

    /**
     * 表示**主炮炮弹**类型
     * */
    enum class ShellType : Type {
        HE, AP, SAP, COMMON
    }

    /**
     * 表示防空炮类型
     * */
    enum class AntiAircraftType : Type {
        COMMON
    }

    /**
     * 表示**舰载鱼雷**类型
     * */
    enum class TorpedoType : Type {
        COMMON_TORPEDO, MAGNETIC_TORPEDO
    }

    /**
     * 表示航弹类型
     * */
    enum class AerialBombType : Type {
        TORPEDO, LB100, LB500, LB1000, LB1600, LB2000
    }

    /**
     * 表示舰船类型
     * */
    enum class ShipType: Type {
        DD, CL, CA, CB, CLT, CAV, BB, BC, BM, BBV, CV, CVL, AR, SS
    }

    /**
     * 表示属性值的加成类型
     * */
    enum class BonusType : Type {
        FIREPOWER, TORPEDO, ANTI_AIRCRAFT, HEALTH, RELOAD, LUCKY, AVIATION,
        ACCURACY, SPEED, EVASION, ANTI_SUBMARINE
    }
}

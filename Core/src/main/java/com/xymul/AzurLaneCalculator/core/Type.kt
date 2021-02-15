package com.xymul.AzurLaneCalculator.core

/**
 * 该接口是[com.xymul.AzurLaneCalculator.core.Type]下所有内部类的父接口，用于表示各种类型
 * */
interface Type {
    /**
     * 表示装甲类型
     * */
    enum class ArmorType : Type {
        /**
         * 表示舰船装甲属于轻甲
         * */
        LIGHT_ARMOR,

        /**
         * 表示舰船装甲属于中甲
         * */
        MEDIUM_ARMOR,

        /**
         * 表示舰船装甲属于重甲
         */
        HEAVY_ARMOR
    }

    /**
     * 表示**主炮炮弹**类型
     * */
    enum class ShellType : Type {
        /** 表示该炮弹属于高爆弹 */
        HE,
        /** 表示该炮弹属于穿甲弹 */
        AP,
        /** 表示该炮弹属于半穿甲弹 */
        SAP,
        /** 表示该炮弹属于通常弹 */
        COMMON
    }

    /**
     * 表示防空炮类型，该枚举只是为了方便对[com.xymul.AzurLaneCalculator.core.weapons.AntiAircraftGun]
     * 做出特化所提供的
     * */
    enum class AntiAircraftType : Type {
        COMMON
    }

    /**
     * 表示**舰载鱼雷**类型
     * */
    enum class TorpedoType : Type {
        /** 表示该鱼雷属于普通鱼雷 */
        COMMON_TORPEDO,
        /** 表示该鱼雷属于磁性鱼雷 */
        MAGNETIC_TORPEDO
    }

    /**
     * 表示航弹类型
     * */
    enum class AerialBombType : Type {
        /** 表示该航弹属于航空鱼雷 */
        TORPEDO,
        /** 表示100磅航弹 */
        LB100,
        /** 表示500磅航弹 */
        LB500,
        /** 表示1000磅航弹 */
        LB1000,
        /** 表示1600磅航弹 */
        LB1600,
        /** 表示2000磅航弹 */
        LB2000
    }

    /**
     * 表示舰船类型
     * */
    enum class ShipType: Type {
        DD, CL, CA, CB, CLT, CAT, CAV, BB, BC, BM, BBV, CV, CVL, AR, SS
    }

    /**
     * 表示装备和武器的适用性
     * */
    enum class Applicability : Type {
        DD, CL, CA, CB, CLT, CAT, CAV, BB, BC, BM, BBV, CV, CVL, AR, SS, ALL
    }

    /**
     * 表示属性值的加成类型
     * */
    enum class BonusType : Type {
        FIREPOWER, TORPEDO, ANTI_AIRCRAFT, HEALTH, RELOAD, LUCKY, AVIATION,
        ACCURACY, SPEED, EVASION, ANTI_SUBMARINE
    }
}

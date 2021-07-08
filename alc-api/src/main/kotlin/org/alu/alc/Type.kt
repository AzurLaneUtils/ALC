package org.alu.alc

interface Type {
    /**
     * 表示装甲类型
     * */
    enum class Armor : Type {
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
     * 表示**武器弹药**类型
     * */
    enum class Ammunition : Type {
        /** 表示该弹药属于高爆弹 */
        HE,

        /** 表示该弹药属于穿甲弹 */
        AP,

        /** 表示该弹药属于半穿甲弹 */
        SAP,

        /** 表示该弹药属于通常弹 */
        COMMON,

        /** 表示该弹药属于防空炮弹药 */
        ANTI_AIRCRAFT,

        /** 表示该弹药属于普通鱼雷 */
        C_TORPEDO,

        /** 表示该弹药属于磁性鱼雷 */
        M_TORPEDO,

        /** 表示该航弹属于航空鱼雷 */
        AVIATION_TORPEDO,

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
    enum class ShipType : Type {
        /** DD: 即驱逐舰 */
        DD,

        /** CL: 即轻巡洋舰，**这里特指有副炮的轻巡洋舰** */
        CL,

        /** CA: 即重巡洋舰，**这里特指有副炮的重巡洋舰** */
        CA,

        /** CB: 即大巡/超巡 */
        CB,

        /** CLT: 即雷击巡洋舰，**这里特指带有鱼雷的轻巡洋舰** */
        CLT,

        /** CAT: **这里特指带有鱼雷的重巡洋舰** */
        CAT,

//        /** CAV: 航空巡洋舰 */
//        CAV,

        /** BB: 战列舰 */
        BB,

        /** BC: 战列巡洋舰 */
        BC,

        /** BM: 重炮 */
        BM,

        /** BBV: 航空战列舰 */
        BBV,

        /** CV: 正规航空母舰 */
        CV,

        /** CVL: 轻型航空母舰 */
        CVL,

        /** AR: 维修舰 */
        AR,

        /** SS: 潜艇 */
        SS,

        /** AS: 潜母 */
        AS,

        /** AP: 补给舰 */
        AP
    }

    enum class Faction : Type {
        /** 白鹰 */
        EAGLE_UNION,
        /** 皇家 */
        ROYAL_NAVY,
        /** 铁血 */
        IRON_BLOOD,
        /** 重樱 */
        SAKURA_EMPIRE,
        /** 自由鸢尾 */
        IRIS_LIBRE,
        /** 维希教廷 */
        VICHYA_DOMINION,
        /** 撒丁帝国 */
        SARDEGNA_EMPIRE,
        /** 北方联合 */
        NORTHERN_PARLIAMENT,
        /** META */
        META,
        /** 布里 */
        OTHERS,
    }

    /**
     * 表示**对己方**属性值/最终伤害的加成类型
     * */
    enum class BonusType: Type {
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

    /**
     * 表示一艘舰船的稀有度
     * */
    enum class ShipRarity {
        N,
        R,
        SR,
        SSR,
        UR
    }

}


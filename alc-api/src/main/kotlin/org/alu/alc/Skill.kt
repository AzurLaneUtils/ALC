package org.alu.alc

import org.alu.alc.internal.units.AffectObject

import org.alu.alc.internal.units.Effect

/**
 * 表示一个舰船/装备的技能
 * */
class Skill(
    /** 技能的描述 */
    val desc: String,

    /**
     * 该参数格式为:Effect(加成类型，加成值)
     * */
    val effect: Effect,

    /** 技能的强化等级 */
    val level: Int,

    /** 技能是否被启用，如果是常驻buff，该值必须保持true */
    var isEnable: Boolean,

    /**
     * 属性加成的优先级，当两个属性加成优先级不同时，两者为乘算
     *
     * **REQUIREMENTS**
     * - 在初始化该属性时，该列表中的元素必须非负，否则行为未定义。
     *   可能导致的问题: 原本两个不同优先级的技能处理后优先级相同
     * - 在同一个技能中，一个不同的属性对应一个优先级
     * 如"炮击和雷击加成12%"，应被描述为(假设这个两个加成优先级相同): <br/>
     * `org.alu.alc.Skill("", Effects((FIREPOWER, 0.12), (TORPEDO, 0.12)), 10, true, (1, 1), AffectObject(...), ...)`
     * */
    val priorities: MutableList<Int>,

    /**
     * 表示这个技能适用于哪些舰船
     * */
    val affectTargets: AffectObject,

    /** 技能的CD */
    val cd: Double
) {
    init {
        // 将负数化正
        for ((flag, e) in priorities.withIndex()) {
            if (e < 0) {
                priorities[flag] = -e
            }
        }
    }
}
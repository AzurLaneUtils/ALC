package org.alu.alc.core

import org.alu.alc.core.units.AffectObject
import org.alu.alc.core.units.InitException

class Skill(
    private val desc: String,
    /**
     * 该参数格式为:(arrayOf(<加成类型, 加成乘数>))
     *
     * 举个例子，比如说海妈的技能"雷达扫描"，其对应技能实体构造传参应该如下:
     * ```kotlin
     * val skill = Skill("...", arrayOf(Pair(Type.BonusType.DEBUFF_TO_ENEMY, 0.4))
     * ```
     * */
    val effects: Array<Pair<ArrayList<Type.BonusType>, Double>>,
    /** 技能的强化等级 */
    val level: Int,
    /** 技能是否被启用，如果是常驻buff，该值必须保持true */
    var isEnable: Boolean,
    /**
     * 属性加成的优先级，当两个属性加成优先级不同时，两者为乘算
     *
     * 在一个舰队中，它的最小值必须为0且连续
     *
     * **REQUIREMENTS**：
     * - 如果一个舰队中，没有一个优先级为1的技能，则技能优先级全部-1处理直到有1出现
     * */
    val priorities: IntArray,
    /**
     * 表示这个技能适用于哪些舰船
     *
     * 对于Pair.second的值，分为一下几种:
     * - (f, t): 表示作用对象是除自已以外的符合Pair.first的舰船
     * - (t, f): 表示作用对象是自己
     * - (f, f): 表示buff不作用于任何对象，如果这样，请将[Skill.isEnable]改为false，否则抛出异常
     * [InitException]
     * - (t, t): 表示作用对象是自己和所用符合Pair.first的舰船
     * */
    val affectTargets: AffectObject
) {
    init {
        if (!affectTargets.toOthers && !affectTargets.toSelf) {
            throw InitException("""
                affectTargets.second.first == affectTargets.second.second == false.
                It's not allowed.
            """)
        }
    }
}
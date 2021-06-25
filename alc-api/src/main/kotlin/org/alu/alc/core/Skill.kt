package org.alu.alc.core

class Skill(
    private val desc: String,
    /**
     * 该参数格式为:(arrayOf(<加成类型, 加成乘数>))
     *
     * 举个例子，比如说海妈的技能"雷达扫描"，其对应技能实体构造传参应该如下:
     * ```kotlin
     * val skill = Skill("...", arrayOf(Pair(Type.BonusType.DAMAGE, 0.4))
     * ```
     * 注:海妈的雷达扫描属于debuff，属于单独乘算项，需要区别技能的优先级
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
     * **REQUIREMENTS**
     * - 在初始化该属性时，IntArray中的元素必须不能为负，否则行为未定义。
     *   可能导致的问题: 原本两个不同优先级的技能处理后优先级相同
     * - 如果一个舰队中，没有一个优先级为1的技能，则技能优先级全部-1处理直到有1出现
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
        var hasZero = false
        for ((flag, e) in priorities.withIndex()) {
            if (e == 0 && !hasZero) {
                hasZero = true
            }
            if (e < 0) {
                priorities[flag] = -e
            }
        }
        // 将最小值置零
        if (!hasZero) {
            while (true) {
                priorities.forEach {
                    it.minus(1)
                }
                for (e in priorities) {
                    if (e == 0) {
                        break
                    }
                }
            }
        }
    }
}
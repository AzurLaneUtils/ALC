package org.alu.alc.core
// todo: MapError
class Skill(
    private val desc: String,
    /**
     * 该参数格式为:<加成类型, 加成乘数>
     *
     * 举个例子，比如说海妈的技能"雷达扫描"，其对应技能实体构造传参应该如下:
     * ```kotlin
     * val skill = Skill("...", HashMap(Type.BonusType.DEBUFF_TO_ENEMY, 0.4))
     * ```
     * */
    val effects: Array<Pair<Type.BonusType, Double>>,
    val level: Int,
    var isEnable: Boolean,
    /**
     * 属性加成的优先级，当两个属性加成优先级不同时，两者为乘算
     *
     * 在一个舰队中，它的其中一个值必须为0且连续
     * */
    val priorities: IntArray,
    val affectTarget: Type.AffectTargetType
) {

}
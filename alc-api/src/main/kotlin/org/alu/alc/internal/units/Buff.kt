package org.alu.alc.internal.units

/**
 * 表示一个buff
 * */
data class Buff(
    /** buff的作用值 */
    val effects: ArrayList<Double>,
    /** buff的优先级 */
    val priorities: ArrayList<Int>
)

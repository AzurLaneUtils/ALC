package org.alu.alc.core.helper

data class Buff(
    /** buff的作用值 */
    val effects: ArrayList<Double>,
    /** buff的优先级 */
    val priorities: ArrayList<Int>
)

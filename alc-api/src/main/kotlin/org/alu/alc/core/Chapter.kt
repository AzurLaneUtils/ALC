package org.alu.alc.core

/**
 * 该类代表一个**主线**或**大型作战**的关卡
 *
 * todo: impl this
 * */
interface Chapter {
    /**
     * 获取第[fpos]个舰队
     * */
    fun fleetOf(fpos: Int): Fleet
}
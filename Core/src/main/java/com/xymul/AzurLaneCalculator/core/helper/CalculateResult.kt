package com.xymul.AzurLaneCalculator.core.helper

import java.io.Serializable

/**
 * 运算结果类，一切涉及碧蓝航线中数值的计算都会以此类为返回类型
 * */
data class CalculateResult(
    /** 计算的结果，计算失败，则此值应 <= 0 */
    val value: Double,
    /** 计算是否成功的标志 */
    val success: Boolean,
    /** 如果计算失败，则失败处发生的异常 */
    val error: Throwable?
): Serializable {

}

package org.alu.AzurLaneCalculator.core.helper

class NumberException(
    massage: String = "",
    cause: Throwable? = null
) : Exception(massage, cause)
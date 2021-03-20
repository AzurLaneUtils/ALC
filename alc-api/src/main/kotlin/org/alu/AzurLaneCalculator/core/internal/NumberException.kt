package org.alu.AzurLaneCalculator.core.internal

class NumberException(
    massage: String = "",
    cause: Throwable? = null
) : Exception(massage, cause)
package com.xymul.AzurLaneCalculator.core.helper

class NumberException(
    massage: String = "",
    cause: Throwable? = null
) : Exception(massage, cause)
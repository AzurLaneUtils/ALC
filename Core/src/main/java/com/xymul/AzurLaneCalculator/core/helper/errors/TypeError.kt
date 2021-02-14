package com.xymul.AzurLaneCalculator.core.helper.errors

class TypeError(
    msg: String = "",
    cause: Throwable? = null
) : Exception(msg, cause)
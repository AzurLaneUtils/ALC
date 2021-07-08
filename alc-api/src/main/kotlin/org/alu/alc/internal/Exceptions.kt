package org.alu.alc.internal

class FleetException
@JvmOverloads constructor(
    message: String = "",
    cause: Throwable? = null
) : RuntimeException(message, cause)

class ChapterException
@JvmOverloads constructor(
    message: String = "",
    cause: Throwable? = null
) : RuntimeException(message, cause)
package org.alu.alc.core

class InitException
@JvmOverloads constructor(message: String, cause: Throwable? = null) :
    Exception("Something unexpected happend when initializing: $message", cause)
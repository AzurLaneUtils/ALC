package org.alu.alc.internal.annotations

import java.lang.annotation.Inherited

@Inherited
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class IncorrectlyImplementation(
    val cause: String = ""
)

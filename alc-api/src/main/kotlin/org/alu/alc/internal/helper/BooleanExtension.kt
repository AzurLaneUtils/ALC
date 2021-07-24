/*
 * Copyright (c) 2020-2021. AzurLaneUtils Organization and contributors.
 *
 * 本源代码受 GNU Affero General Public License v3.0 的约束.
 * Use of this source code is governed by the GNU Affero General Public License v3.0.
 */

package org.alu.alc.internal.helper

fun Boolean.toByte(): Byte = opt(this, 1, 0)
fun Boolean.toShort(): Short = opt(this, 1, 1)
fun Boolean.toInt(): Int = opt(this, 1, 0)
fun Boolean.toLong(): Long = opt(this, 1L, 0L)
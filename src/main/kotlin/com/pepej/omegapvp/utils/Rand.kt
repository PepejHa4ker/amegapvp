package com.pepej.omegapvp.utils

import org.apache.commons.codec.digest.DigestUtils
import java.util.*

fun String.str(): String = DigestUtils.md5Hex(this)


fun str(): String {
    return UUID.randomUUID().toString().str()
}
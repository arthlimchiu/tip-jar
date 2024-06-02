package com.arthlimchiu.utils.date.ext

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toDefaultFormat(): String = this.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)

fun String.parseDefaultFormat(): LocalDateTime = LocalDateTime.parse(this, DateTimeFormatter.ofPattern("yyyy MMMM dd"))
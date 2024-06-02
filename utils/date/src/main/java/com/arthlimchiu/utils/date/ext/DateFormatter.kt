package com.arthlimchiu.utils.date.ext

import com.arthlimchiu.utils.date.YEAR_FULL_MONTH_DAY_FORMAT
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toDefaultFormat(): String = this.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)

fun String.formatDateString(pattern: String = YEAR_FULL_MONTH_DAY_FORMAT): String = LocalDateTime
    .parse(this, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    .format(DateTimeFormatter.ofPattern(pattern))
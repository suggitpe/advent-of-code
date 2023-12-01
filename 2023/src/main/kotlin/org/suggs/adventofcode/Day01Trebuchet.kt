package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day01Trebuchet {

    private val TRIM_DIGIT_REGEX = "[^\\d.]".toRegex()
    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateTotalCalibrationValuesFrom(dirtyCalibrationData: List<String>) =
        dirtyCalibrationData.map { it.replace(TRIM_DIGIT_REGEX, "") }.map { "${it.first()}${it.last()}" }.sumOf { it.toInt() }

}
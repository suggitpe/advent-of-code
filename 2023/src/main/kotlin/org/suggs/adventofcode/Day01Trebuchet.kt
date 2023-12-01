package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day01Trebuchet {

    private val TRIM_DIGIT_REGEX = "[^\\d.]".toRegex()
    private val NUMBER_MAP = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9"
    )
    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateTotalCalibrationValuesFromDigitsIn(dirtyCalibrationData: List<String>) =
        dirtyCalibrationData
            .map { it.replace(TRIM_DIGIT_REGEX, "") }
            .map { "${it.first()}${it.last()}" }
            .sumOf { it.toInt() }

    fun calculateTotalCalibrationValuesFromDigitsAndStringsIn(dirtyCalibrationData: List<String>): Int {
        return 1
    }

}
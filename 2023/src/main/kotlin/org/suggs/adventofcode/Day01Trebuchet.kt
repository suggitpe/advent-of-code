package org.suggs.adventofcode

object Day01Trebuchet {

    private val TRIM_DIGIT_REGEX = "[^\\d.]".toRegex()
    private const val NUM_REGEX = "one|two|three|four|five|six|seven|eight|nine"
    private val FIND_FWD = ("[1-9]|$NUM_REGEX").toRegex()
    private val FIND_BKWD = ("[1-9]|${NUM_REGEX.reversed()}").toRegex()

    fun calculateTotalCalibrationValuesFromDigitsIn(dirtyCalibrationData: List<String>) =
        dirtyCalibrationData.map { it.replace(TRIM_DIGIT_REGEX, "") }.map { "${it.first()}${it.last()}" }.sumOf { it.toInt() }

    fun calculateTotalCalibrationValuesFromDigitsAndStringsIn(dirtyCalibrationData: List<String>) =
        dirtyCalibrationData.map { getFirstDigit(it) + getLastDigit(it) }.sumOf { it.toInt() }

    private fun getFirstDigit(s: String) = convertTextToDigit(FIND_FWD.findAll(s).first().value)
    private fun getLastDigit(s: String) = convertTextToDigit(FIND_BKWD.findAll(s.reversed()).first().value.reversed())

    private fun convertTextToDigit(number: String): String {
        return when (number) {
            "one" -> "1"
            "two" -> "2"
            "three" -> "3"
            "four" -> "4"
            "five" -> "5"
            "six" -> "6"
            "seven" -> "7"
            "eight" -> "8"
            "nine" -> "9"
            else -> number
        }
    }

}
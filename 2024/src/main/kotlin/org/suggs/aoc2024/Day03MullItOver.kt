package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day03MullItOver {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val functionRegex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
    private val enabledOnlyRegex = "mul\\(\\d{1,3},\\d{1,3}\\)|don't\\(\\)|do\\(\\)".toRegex()

    fun filterOutAndAddMultiplicationCallsFrom(data: String) =
        functionRegex.findAll(data).map { it.value }.toList().sumOf { extractMultipliedValueFrom(it) }

    private fun extractMultipliedValueFrom(sumString: String) =
        sumString.drop(4).dropLast(1).split(",").map { it.toInt() }.let { it[0] * it[1] }

    fun filterOutAndMultiplyEnabledCallsFrom(data: String) =
        addUpAllEnabled(enabledOnlyRegex.findAll(data).map { it.value }.toList(), true, 0)

    private fun addUpAllEnabled(instruction: List<String>, enabled: Boolean, accu: Int): Int {
        return when {
            instruction.isEmpty() -> accu
            instruction.first().startsWith("don't") -> addUpAllEnabled(instruction.drop(1), false, accu)
            instruction.first().startsWith("do(") -> addUpAllEnabled(instruction.drop(1), true, accu)
            instruction.first().startsWith("mul") -> {
                if (enabled)
                    addUpAllEnabled( instruction.drop(1), enabled, accu + extractMultipliedValueFrom(instruction.first()))
                else
                    addUpAllEnabled(instruction.drop(1), enabled, accu)
            }

            else -> throw IllegalStateException()
        }

    }


}
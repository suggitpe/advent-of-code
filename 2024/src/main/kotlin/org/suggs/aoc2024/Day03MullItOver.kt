package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day03MullItOver {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val functionRegex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()

    fun filterOutAndAddMultiplicationCallsFrom(data: String) =
        functionRegex.findAll(data).map { it.value }.toList().sumOf { extractMultipliedValueFrom(it) }

    private fun extractMultipliedValueFrom(sumString: String) =
        sumString.drop(4).dropLast(1).split(",").map { it.toInt() }.let { it[0] * it[1] }

}
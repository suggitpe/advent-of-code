package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day10CathodeRayTube {

    fun countSignalStrengthFrom(smallData: List<String>) =
        smallData.flatMap { calculateValueOfCycle(it) }
            .runningFold(1) { acc, it -> acc + it }
            .filterIndexed { idx, _ -> idx % 40 == 19 }
            .mapIndexed { idx, it -> it * (((idx + 1) * 40) - 20) }
            .sum()

    private fun calculateValueOfCycle(cycle: String) =
        when (cycle.substringBefore(" ")) {
            "noop" -> listOf(0)
            "addx" -> listOf(0, cycle.substringAfter(" ").toInt())
            else -> throw IllegalStateException()
        }

    fun drawCathodeRayImage(smallData: List<String>): String {
        return smallData.flatMap { calculateValueOfCycle(it) }
            .runningFold(1) { acc, it -> acc + it }.dropLast(1)
            .mapIndexed { position, registerValue -> screenValueFor(registerValue, position) }
            .chunked(40).joinToString("\n") { it.joinToString("") }
    }

    private fun screenValueFor(registerValue: Int, position: Int) =
        if ((position % 40) in (registerValue - 1..registerValue + 1)) '#' else '.'

}
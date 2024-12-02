package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day02RedNosedReports {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countNumberOfSafeReportsFrom(data: List<String>) =
        data.count { isSafe(it.split(" ").map { it.toInt() }.zipWithNext().map { it.first - it.second }) }

    private fun isSafe(lineDeltas: List<Int>) = allInRange(lineDeltas) && sameDirection(lineDeltas)

    private fun allInRange(lineDeltas: List<Int>) = lineDeltas.all { abs(it) in 1..3 }

    private fun sameDirection(lineDeltas: List<Int>) = lineDeltas.all { it > 0 } || lineDeltas.all { it < 0 }

}

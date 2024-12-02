package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day02RedNosedReports {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countNumberOfSafeReportsFrom(data: List<String>): Int {
        log.debug("Checking $data")
        return data.count { isSafe(it.split(" ").map { it.toInt() }.zipWithNext()) }
    }

    private fun isSafe(line: List<Pair<Int, Int>>): Boolean {
        return allUp(line) || allDown(line)
    }

    private fun allUp(line: List<Pair<Int, Int>>): Boolean {
        if (line.isEmpty()) return true
        if ((line.first().first > line.first().second) || !diffOK(line.first())) return false
        return allUp(line.drop(1))
    }

    private fun allDown(line: List<Pair<Int, Int>>): Boolean {
        if (line.isEmpty()) return true
        if ((line.first().first < line.first().second) || !diffOK(line.first())) return false
        return allDown(line.drop(1))
    }

    private fun diffOK(pair: Pair<Int, Int>): Boolean =
        abs(pair.first - pair.second) in 1..3

}

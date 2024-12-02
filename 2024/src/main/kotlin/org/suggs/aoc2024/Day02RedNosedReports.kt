package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day02RedNosedReports {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countNumberOfSafeReportsFrom(data: List<String>) =
        data.count { isSafeLine(it.split(" ").map { it.toInt() }) }

    private fun isSafeLine(line: List<Int>) = isSafeDeltas(line.zipWithNext().map { it.second - it.first })
    private fun isSafeDeltas(lineDeltas: List<Int>) = allInRange(lineDeltas) && allSameDirection(lineDeltas)
    private fun allInRange(lineDeltas: List<Int>) = lineDeltas.all { abs(it) in 1..3 }
    private fun allSameDirection(lineDeltas: List<Int>) = lineDeltas.all { it > 0 } || lineDeltas.all { it < 0 }

    fun countNumberOfDampenedSafeReportsFrom(data: List<String>): Int =
        data.count { isDampenedSafeLine(it.split(" ").map { it.toInt() }) }

    private fun isDampenedSafeLine(line: List<Int>): Boolean {
        return if(isSafeLine(line)) true
        else findSubLisThatIsSafe(line)
    }

    private fun findSubLisThatIsSafe(line: List<Int>): Boolean {
        for(i in line.indices) {
            val mutated = line.toMutableList()
            mutated.removeAt(i)
            if(isSafeLine(mutated)) return true
        }
        return false
    }


}

package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.StringGrid

object Day06TrashCompactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun addVerticalMathsProblemsFrom(gridOfCalculations: StringGrid): Long =
        gridOfCalculations.columns().sumOf { calculateColumnData(it) }

    private fun calculateColumnData(columnData: List<String>): Long {
        return when (columnData.last()){
            "+" -> columnData.dropLast(1).sumOf { it.toLong() }
            "*" -> columnData.dropLast(1).map{it.toLong()}.reduce{acc, elem -> acc * elem}
            else -> throw IllegalArgumentException("Unknown column data")
        }
    }


}
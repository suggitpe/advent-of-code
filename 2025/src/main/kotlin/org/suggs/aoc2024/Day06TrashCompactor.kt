package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.StringGrid

object Day06TrashCompactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun addVerticalMathsProblemsFrom(gridOfCalculations: StringGrid): Long =
        gridOfCalculations.columns().reversed().sumOf { calculateColumnData(it) }

    private fun calculateColumnData(columnData: List<String>): Long =
        calculateValuesFrom(columnData.dropLast(1).map { it.toLong() }, columnData.last().toCharArray().first())

    fun addVerticalMathsProblemsWithCephalopodLogicFrom(gridOfCalculations: Grid): Long =
        buildCalculationBlocksFrom(gridOfCalculations.columns()).reversed().sumOf { calculateBlockValueOf(it) }

    private fun calculateBlockValueOf(calcBlock: List<CharArray>): Long =
        calculateValuesFrom(
            calcBlock.map { String(it.dropLast(1).toCharArray()).trim().toLong() },
            calcBlock.first().last()
        )

    private fun calculateValuesFrom(longs: List<Long>, function: Char): Long =
        when (function) {
            '+' -> longs.sum()
            '*' -> longs.reduce { acc, elem -> acc * elem }
            else -> throw IllegalArgumentException("Unknown column data")
        }

    private fun buildCalculationBlocksFrom(columns: List<CharArray>): List<List<CharArray>> {
        return columns.fold(mutableListOf(mutableListOf<CharArray>())) { acc, item ->
            if (item.all { it == ' ' }) {
                if (acc.last().isNotEmpty()) {
                    acc.add(mutableListOf())
                }
            } else {
                acc.last().add(item)
            }
            acc
        }
    }
}
package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09SmokeBasin {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRiskLevelsInMatrixFrom(dataSet: Array<Array<Int>>): Int {
        fun isValidReference(x: Int, y: Int) = x >= 0 && x < dataSet.first().size && y >= 0 && y < dataSet.size

        fun checkLowest(x: Int, y: Int, digit: Int) = when {
            !isValidReference(x, y) -> true
            dataSet[y][x] > digit -> true
            else -> false
        }

        fun isDigitLowest(digit: Int, x: Int, y: Int): Boolean =
            checkLowest(x - 1, y, digit) && checkLowest(x, y - 1, digit) && checkLowest(x + 1, y, digit) && checkLowest(x, y + 1, digit)

//        print(dataSet)
        val totalCountOfRiskLevels = mutableListOf<Int>()
        dataSet.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, digit ->
                if (isDigitLowest(digit, x, y)) {
                    totalCountOfRiskLevels.add(digit + 1)
                }
            }
        }
        return totalCountOfRiskLevels.sum()
    }

    private fun print(dataSet: Array<Array<Int>>) {
        dataSet.map { it -> log.debug("${it.map { it }}") }
    }
}
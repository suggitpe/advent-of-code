package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09SmokeBasin {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRiskLevelsInMatrixFrom(dataSet: Array<Array<Int>>): Int {

        fun valueAt(coordinate: Pair<Int, Int>) = dataSet[coordinate.second][coordinate.first]

        fun isValidReference(coordinate: Pair<Int, Int>) =
            coordinate.first >= 0
                    && coordinate.first < dataSet.first().size
                    && coordinate.second >= 0
                    && coordinate.second < dataSet.size

        fun checkLowest(coordinate: Pair<Int, Int>, digit: Int) = when {
            !isValidReference(coordinate) -> true
            valueAt(coordinate) > digit -> true
            else -> false
        }

        fun isDigitLowest(coordinate: Pair<Int, Int>, digit: Int): Boolean =
            checkLowest(Pair(coordinate.first - 1, coordinate.second), digit)
                    && checkLowest(Pair(coordinate.first, coordinate.second - 1), digit)
                    && checkLowest(Pair(coordinate.first + 1, coordinate.second), digit)
                    && checkLowest(Pair(coordinate.first, coordinate.second + 1), digit)

        val totalCountOfRiskLevels = mutableListOf<Int>()
        dataSet.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, digit ->
                if (isDigitLowest(Pair(x, y), digit)) {
                    totalCountOfRiskLevels.add(digit + 1)
                }
            }
        }
        return totalCountOfRiskLevels.sum()
    }

}
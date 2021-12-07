package org.suggs.adventofcode

import kotlin.math.abs

object Day07TreacheryOfWhales {

    fun convergeToCommonNumberWithLeastCostUsingSimpleCosting(dataSet: List<Int>): Int =
        (minFrom(dataSet)..maxFrom(dataSet)).toList().minOf { dataSet.sumOf { crabPlacement -> abs(it - crabPlacement) } }

    fun convergeToCommonNumberWithLeastCostUsingAdditiveCosting(dataSet: List<Int>) =
        (minFrom(dataSet)..maxFrom(dataSet)).toList().minOf { dataSet.sumOf { crabPlacement -> calculateTriangularCostOf(abs(it - crabPlacement)) } }

    private fun calculateTriangularCostOf(n: Int) = n * (n + 1) / 2

    private fun minFrom(ints: List<Int>) = ints.minOrNull()!!
    private fun maxFrom(ints: List<Int>) = ints.maxOrNull()!!

}
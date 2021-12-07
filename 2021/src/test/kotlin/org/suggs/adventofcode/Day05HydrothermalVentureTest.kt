package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05HydrothermalVenture.countNumberOfPointsThatIntersectMoreThanOnce
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.adventofcode.domain.VentLine
import org.suggs.adventofcode.domain.VentLine.Companion.aVentLineFrom

@DisplayName("Hydrothermal Venture should ... ")
class Day05HydrothermalVentureTest {

    @Test
    fun `calculate the number of positions where more than two straight lines intersect using small data set`() =
        countNumberOfPointsThatIntersectMoreThanOnce(verySmallDataSet.filter { !it.isDiagonal() }) shouldBe 5

    @Test
    fun `calculate the number of positions where more than two lines intersect using small data set`() =
        countNumberOfPointsThatIntersectMoreThanOnce(verySmallDataSet) shouldBe 12

    @Test
    fun `calculate the number of positions where more than two straight lines intersect using large data set`() =
        countNumberOfPointsThatIntersectMoreThanOnce(readDataSet.filter { !it.isDiagonal() }) shouldBeInRange 8100..8200

    @Test
    fun `calculate the number of positions where more than two  lines intersect using large data set`() =
        countNumberOfPointsThatIntersectMoreThanOnce(readDataSet) shouldBeInRange 22000..24000

    private val readDataSet: List<VentLine> = getFileLinesFrom("day05-input.txt").map { aVentLineFrom(it.substringBefore(" -> "), it.substringAfter(" -> ")) }

    private val verySmallDataSet: List<VentLine> = """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2""".split("\n").map { aVentLineFrom(it.substringBefore(" -> "), it.substringAfter(" -> ")) }
}
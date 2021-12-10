package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day09SmokeBasin.countRiskLevelsInMatrixFrom
import java.lang.Character.getNumericValue

class Day09SmokeBasinTest {

    @Test
    fun `counts the number of risk levels in a small series of data`() {
        countRiskLevelsInMatrixFrom(verySmallDataSet) shouldBe 15
    }

    @Test
    fun `counts the numbers of risk levels in a large series of data`() {
        countRiskLevelsInMatrixFrom(readDataSet) shouldBeInRange 550..600
    }

    private val readDataSet: Array<Array<Int>> = Util.getFileLinesFrom("day09-input.txt").map { it.toCharArray().map { inner -> getNumericValue(inner) }.toTypedArray() }.toTypedArray()
    private val verySmallDataSet: Array<Array<Int>> = """2199943210
3987894921
9856789892
8767896789
9899965678""".split("\n").map { it.toCharArray().map { inner -> getNumericValue(inner) }.toTypedArray() }.toTypedArray()
}
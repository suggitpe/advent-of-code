package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day02Dive.calculateAimedPositionFrom
import org.suggs.adventofcode.Day02Dive.calculatePositionFrom
import org.suggs.adventofcode.Util.createStringIntMapFrom

@DisplayName("Dive should ...")
class Day02DiveTest {

    @Test
    fun `calculate position from small data set`() =
        calculatePositionFrom(verySmallDataSet) shouldBe 150

    @Test
    fun `calculate position from large data set`() =
        calculatePositionFrom(readDataSet) shouldBe 1654760

    @Test
    fun `calculate aimed position from small data set`() =
        calculateAimedPositionFrom(verySmallDataSet) shouldBe 900

    @Test
    fun `calculate aimed position from large data set`() =
        calculateAimedPositionFrom(readDataSet) shouldBe 1956047400


    private val readDataSet = createStringIntMapFrom("day02-input.txt")

    private val verySmallDataSet: List<Pair<String, Int>> = """forward 5
down 5
forward 8
up 3
down 8
forward 2""".split("\n").map {
        val (left, right) = it.split(" ")
        left to right.toInt()
    }
}
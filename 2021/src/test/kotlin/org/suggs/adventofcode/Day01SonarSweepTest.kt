package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day01SonarSweep.countNumberOfIncrementsFrom
import org.suggs.adventofcode.Day01SonarSweep.countNumberOfThreeNumberIncrementsFrom
import org.suggs.adventofcode.Util.createIntListFrom

internal class Day01SonarSweepTest {

    @Test
    fun `counts the number of increasing numbers in a small list`() {
        countNumberOfIncrementsFrom(verySmallArray) shouldBe 7
    }

    @Test
    fun `counts the number of increasing numbers in a very bog list`() {
        countNumberOfIncrementsFrom(readArray) shouldBe 1791
    }

    @Test
    fun `counts the number of increasing numbers from a three count increments in a small list`() {
        countNumberOfThreeNumberIncrementsFrom(verySmallArray) shouldBe 5
    }

    @Test
    fun `counts the number of increasing numbers from a three count increments in a very big list`() {
        countNumberOfThreeNumberIncrementsFrom(readArray) shouldBe 1822
    }

    private val readArray = createIntListFrom("day01-input.txt")

    private val verySmallArray = """199
200
208
210
200
207
240
269
260
263""".split("\n").map { it.toInt() }

}
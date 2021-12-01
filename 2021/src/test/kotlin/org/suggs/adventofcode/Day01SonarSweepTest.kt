package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day01SonarSweep.countNumberOfIncrementsFrom
import org.suggs.adventofcode.Util.createIntListFrom

internal class Day01SonarSweepTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun `counts the number of increasing numbers in a small list`() {
        countNumberOfIncrementsFrom(verySmallArray) shouldBe 7
    }

    @Test
    fun `counts the number of increasing numbers in a very bog list`() {
        countNumberOfIncrementsFrom(readArray) shouldBe 1791
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
package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07.execute
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day07Test {

    @Test
    fun `sss from small data set`() {
        execute(smallData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day07-input.txt")

    private val smallData = """Time:      7  15   30
Distance:  9  40  200""".split("\n")
}
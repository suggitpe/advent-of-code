package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("hhhh")
class Day10Test {

    @Test
    fun `part 1 - `() {
        Day10.execute() shouldBe 1
    }

    private val largeData = Util.getFileLinesFrom("day10-input.txt")
    private val smallData = """0 3 6 9 12 15
1 3 6 10 15 21
10 13 16 21 30 45""".split("\n")
}
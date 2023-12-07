package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("hhh")
class Day08Test {

    @Test
    fun `part 1 - `() {
        Day08.execute(smallData) shouldBe 1
    }

    private val largeData = getFileLinesFrom("day08-input.txt")

    private val smallData = """""".split("\n")
}
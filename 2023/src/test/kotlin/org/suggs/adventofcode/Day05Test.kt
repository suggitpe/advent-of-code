package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("gggg")
class Day05Test {

    @Test
    fun `calculates with small`() {
        Day05.calculate(smallData) shouldBe 1
    }

    @Test
    @Disabled
    fun `calculates with large data`() {
        Day05.calculate(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day05-input.txt")
    private val smallData = """""".split("\n")
}
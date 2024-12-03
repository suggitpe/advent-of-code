package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.readFileAsString
import org.suggs.aoc2024.Day03MullItOver.filterOutAndAddMultiplicationCallsFrom
import org.suggs.aoc2024.Day03MullItOver.filterOutAndMultiplyEnabledCallsFrom

@DisplayName("Mull it Over")
class Day03MullItOverTest {

    @Test
    fun `filters out noise to find multiply instructions from small data`() {
        filterOutAndAddMultiplicationCallsFrom(smallData) shouldBe 161
    }

    @Test
    @Disabled
    fun `filters out noise to find multiply instructions from larger data`() {
        filterOutAndAddMultiplicationCallsFrom(largeData) shouldBe 123
    }

    @Test
    fun `find multiply instructions from enabled small data`(){
        filterOutAndMultiplyEnabledCallsFrom(smallDataWithEnabledText) shouldBe 48
    }

    @Test
    @Disabled
    fun `find multiply instructions from enabled larger data`(){
        filterOutAndMultiplyEnabledCallsFrom(largeData) shouldBe 123
    }

    private val largeData = readFileAsString("day03-input.txt").split("\n").joinToString()
    private val smallData = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    private val smallDataWithEnabledText = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
}
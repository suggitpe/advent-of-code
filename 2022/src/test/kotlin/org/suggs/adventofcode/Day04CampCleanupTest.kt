package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day04CampCleanup.testForFullRangeOverlap
import org.suggs.adventofcode.Day04CampCleanup.testForPartialRangeOverlap
import org.suggs.adventofcode.Util.applyToEachLineForTotal

@DisplayName("Searching for overlaps in ranges")
class Day04CampCleanupTest {

    @Test
    fun `Count fully overlapping ranges from small data set`() =
        unitData.sumOf { testForFullRangeOverlap(it).compareTo(false) } shouldBe 2

    @Test
    @Disabled
    fun `Count fully overlapping ranges from large data set`() =
        applyToEachLineForTotal("day04-input.txt") { testForFullRangeOverlap(it).compareTo(false) } shouldBe 2

    @Test
    fun `Count partial overlapping ranges from small data set`() =
        unitData.sumOf { testForPartialRangeOverlap(it).compareTo(false) } shouldBe 4

    @Test
    @Disabled
    fun `Count partial overlapping ranges from large data set`() =
        applyToEachLineForTotal("day04-input.txt") { testForPartialRangeOverlap(it).compareTo(false) } shouldBe 4

    private val unitData = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8""".split("\n")
}
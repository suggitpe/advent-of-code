package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day04CampCleanup.testForFullRangeOverlap
import org.suggs.adventofcode.Day04CampCleanup.testForPartialRangeOverlap
import org.suggs.adventofcode.Util.applyToEachLineForTotal

@DisplayName("Searching for overlaps in ranges")
class Day04CampCleanupTest {

    @Test
    fun `Count fully overlapping ranges from small data set`() =
        applyToEachLineForTotal("day04-unit.txt") { testForFullRangeOverlap(it).compareTo(false) } shouldBe 2

    @Test
    fun `Count fully overlapping ranges from large data set`() =
        applyToEachLineForTotal("day04-input.txt") { testForFullRangeOverlap(it).compareTo(false) } shouldBe 582

    @Test
    fun `Count partial overlapping ranges from small data set`() =
        applyToEachLineForTotal("day04-unit.txt") { testForPartialRangeOverlap(it).compareTo(false) } shouldBe 4

    @Test
    fun `Count partial overlapping ranges from large data set`() =
        applyToEachLineForTotal("day04-input.txt") { testForPartialRangeOverlap(it).compareTo(false) } shouldBe 893
}
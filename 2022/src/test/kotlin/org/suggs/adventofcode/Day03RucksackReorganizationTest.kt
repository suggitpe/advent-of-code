package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day03RucksackReorganization.findIntersectingCharacterValueFrom
import org.suggs.adventofcode.Day03RucksackReorganization.findIntersectingCharacterValueFromString
import org.suggs.adventofcode.Util.applyToEachLineForTotal
import org.suggs.adventofcode.Util.chunkFileIntoLinesOfThree

@DisplayName("Rucksack reorganisation antics")
class Day03RucksackReorganizationTest {

    @Test
    fun `Add all intersect char values from small data`() =
        applyToEachLineForTotal("day03-unit.txt") { findIntersectingCharacterValueFromString(it) } shouldBe 157

    @Test
    fun `Add all the intersect char values from large data`() =
        applyToEachLineForTotal("day03-input.txt") { findIntersectingCharacterValueFromString(it) } shouldBe 7746

    @Test
    fun `Add all intersect char values from three line chunks from small data`() =
        chunkFileIntoLinesOfThree("day03-unit.txt").sumOf { findIntersectingCharacterValueFrom(it) } shouldBe 70

    @Test
    fun `Add all intersect char values from three line chunks from large data`() =
        chunkFileIntoLinesOfThree("day03-input.txt").sumOf { findIntersectingCharacterValueFrom(it) } shouldBe 2604


}
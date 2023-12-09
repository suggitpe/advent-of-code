package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day09MirageMadness.sumIncrementsFrom
import org.suggs.adventofcode.Day09MirageMadness.sumPriorSequenceFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Mirage Madness")
class Day09MirageMadnessTest {

    @Test
    fun `part 1 - sum the next sequence number from small data`() {
        sumIncrementsFrom(smallData) shouldBe 114
    }

    @Test
    @Disabled
    fun `part 1 - sum the next sequence number from large data`() {
        sumIncrementsFrom(largeData) shouldBe 123
    }

    @Test
    fun `part 2 - sum the previous sequence number from small data `(){
        sumPriorSequenceFrom(smallData) shouldBe 2
    }

    @Test
    @Disabled
    fun `part 2 - sum the previous sequence number from large data `(){
        sumPriorSequenceFrom(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day09-input.txt")

    private val smallData = """0 3 6 9 12 15
1 3 6 10 15 21
10 13 16 21 30 45""".split("\n")
}
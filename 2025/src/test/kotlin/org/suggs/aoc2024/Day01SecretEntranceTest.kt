package org.suggs.aoc2024

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day01SecretEntrance.countOfSecretEntranceZerosFrom
import org.suggs.aoc2024.Day01SecretEntrance.countOfSpindleZeroPassesFrom
import org.suggs.aoc2024.Day01SecretEntrance.countPassesOrLandsOfZeroFrom

@DisplayName("Day 01 ")
class Day01SecretEntranceTest {

    @Test
    fun `count secret entrance zeros from small data`() {
        countOfSecretEntranceZerosFrom(smallData) shouldBe 3
    }

    @Test
    @Disabled
    fun `count secret entrance zeros from large data`() {
        countOfSecretEntranceZerosFrom(largeData) shouldBe 1234
    }

    @Test
    fun `count times spindle passes zero from small data`() {
        countOfSpindleZeroPassesFrom(smallData) shouldBe 6
    }

    @Test
    @Disabled
    fun `count times spindle passes zero from large data`() {
        countOfSpindleZeroPassesFrom(largeData) shouldBe 1234
    }

    @Test
    fun `counts passes of zero from commands`() {
        assertSoftly {
            countPassesOrLandsOfZeroFrom(50, "L68", 82) shouldBe 1
            countPassesOrLandsOfZeroFrom(82, "L30", 52) shouldBe 0
            countPassesOrLandsOfZeroFrom(52, "R48", 0) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "L5", 95) shouldBe 0
            countPassesOrLandsOfZeroFrom(95, "R60", 55) shouldBe 1
            countPassesOrLandsOfZeroFrom(55, "L55", 0) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "L1", 99) shouldBe 0
            countPassesOrLandsOfZeroFrom(99, "L99", 0) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "R14", 14) shouldBe 0
            countPassesOrLandsOfZeroFrom(14, "L82", 32) shouldBe 1
        }
    }

    @Test
    fun `more scenarios over 100`(){
        assertSoftly{
            countPassesOrLandsOfZeroFrom(50, "L168", 82) shouldBe 2
            countPassesOrLandsOfZeroFrom(1, "L102", 99) shouldBe 2
            countPassesOrLandsOfZeroFrom(1, "L100", 1) shouldBe 1
            countPassesOrLandsOfZeroFrom(99, "L100", 99) shouldBe 1
            countPassesOrLandsOfZeroFrom(50, "L168", 82) shouldBe 2
        }
    }

    @Test
    fun `scenarios starting from zero`(){
        assertSoftly{
            countPassesOrLandsOfZeroFrom(0, "L100", 0) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "L200", 0) shouldBe 2
            countPassesOrLandsOfZeroFrom(0, "L300", 0) shouldBe 3
            countPassesOrLandsOfZeroFrom(0, "R100", 0) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "R200", 0) shouldBe 2
            countPassesOrLandsOfZeroFrom(0, "R300", 0) shouldBe 3
            countPassesOrLandsOfZeroFrom(0, "R200", 0) shouldBe 2
            countPassesOrLandsOfZeroFrom(0, "R220", 20) shouldBe 2
            countPassesOrLandsOfZeroFrom(0, "L220", 80) shouldBe 2
            countPassesOrLandsOfZeroFrom(0, "L199", 1) shouldBe 1
            countPassesOrLandsOfZeroFrom(0, "R199", 99) shouldBe 1
        }
    }

    @Test
    fun `found errors in logic`(){
        assertSoftly {
            countPassesOrLandsOfZeroFrom(39, "L930", 9) shouldBe 9
        }
    }

    private val largeData = getFileLinesFrom("day01-input.txt")
    private val smallData = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82""".split("\n")
}
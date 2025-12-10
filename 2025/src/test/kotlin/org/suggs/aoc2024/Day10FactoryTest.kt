package org.suggs.aoc2024

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.suggs.adventofcode.Util
import org.suggs.aoc2024.Day10Factory.countMinimumButtonPressesFrom
import org.suggs.aoc2024.Day10Factory.createButtonPressesFrom
import org.suggs.aoc2024.Day10Factory.createIndicatorLightsFrom
import org.suggs.aoc2024.Day10Factory.matchXor
import kotlin.test.Test

class Day10FactoryTest {

    @Test
    fun `counts minimum button presses - small`() {
        countMinimumButtonPressesFrom(smallData) shouldBe 7
    }

    @Test
    @Disabled
    fun `counts minimum button presses - large`() {
        countMinimumButtonPressesFrom(largeData) shouldBe 1234
    }

    @Test
    fun `creates ints from button press codes`() {
        assertSoftly {
            createButtonPressesFrom("(0)") shouldBe 1
            createButtonPressesFrom("(1)") shouldBe 2
            createButtonPressesFrom("(2)") shouldBe 4
            createButtonPressesFrom("(3)") shouldBe 8
            createButtonPressesFrom("(4)") shouldBe 16
            createButtonPressesFrom("(0,1)") shouldBe 3
            createButtonPressesFrom("(0,1,2)") shouldBe 7
            createButtonPressesFrom("(0,2)") shouldBe 5
            createButtonPressesFrom("(0,1)") shouldBe 3

            createButtonPressesFrom("(0,4)") shouldBe 17
            createButtonPressesFrom("(0,1,2)") shouldBe 7
            createButtonPressesFrom("(1,2,3,4)") shouldBe 30
        }
    }

    @Test
    fun `creates ints from light switch text`() {
        assertSoftly {
            createIndicatorLightsFrom("[#.....]") shouldBe 1
            createIndicatorLightsFrom("[.#....]") shouldBe 2
            createIndicatorLightsFrom("[..#...]") shouldBe 4
            createIndicatorLightsFrom("[...#..]") shouldBe 8
            createIndicatorLightsFrom("[....#.]") shouldBe 16
            createIndicatorLightsFrom("[...#..]") shouldBe 8
            createIndicatorLightsFrom("[.###.#]") shouldBe 46
            createIndicatorLightsFrom("[.##.]") shouldBe 6
            createIndicatorLightsFrom("[...#.]") shouldBe 8


        }
    }

    @Test
    fun `matches xor numbers to a target`(){
        assertSoftly {
            matchXor(2, listOf(2)) shouldBe true
            matchXor(0, listOf(2, 2)) shouldBe true
            matchXor(6, listOf(5, 3)) shouldBe true
            matchXor(6, listOf(5, 3)) shouldBe true

            matchXor(8, listOf(7, 17, 30)) shouldBe true
        }
    }


    val largeData = Util.getFileLinesFrom("day10-input.txt")
    val smallData = """[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}""".split("\n")

}

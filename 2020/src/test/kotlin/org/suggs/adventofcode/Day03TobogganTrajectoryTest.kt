package org.suggs.adventofcode

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day03TobogganTrajectory.Companion.buildHillFrom
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/3
 */
class Day03TobogganTrajectoryTest {

    @Test
    fun `can identify coordinates of a tree`() {
        assertSoftly {
            simpleHill.isATree(Pair(0, 0)).shouldBeFalse()
            simpleHill.isATree(Pair(2, 0)).shouldBeTrue()
        }
    }

    @Test
    fun `can identify the coordionates of a tree hen arborial genetics has caused the hill to widen`() {
        // these all are the same underpinning coordinate
        assertSoftly {
            simpleHill.isATree(Pair(11, 0)).shouldBeFalse()
            simpleHill.isATree(Pair(13, 0)).shouldBeTrue()
        }
    }

    @Test
    fun `throws out of bounds exception when we go further than the bottom of the hill`() {
        shouldThrow<IndexOutOfBoundsException> {
            simpleHill.isATree(Pair(1, 11))
        }
    }

    @Test
    fun `counts the trees as it goes down the hill`() {
        val countOfTrees = simpleHill.countTheTreesAsYouTobogganOnPathOf(Pair(3, 1))
        countOfTrees shouldBe 7
    }

    @Test
    fun `counts the trees as it goes down the big hill`() {
        val countOfTrees = hillFromInputFile.countTheTreesAsYouTobogganOnPathOf(Pair(3, 1))
        countOfTrees shouldBe 187
    }

    @Test
    fun `counts the multiplication of all tree bumps from five runs`() {
        val cumulative = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
            .map { hillFromInputFile.countTheTreesAsYouTobogganOnPathOf(it) }
            .foldRight(1, { total: Long, item: Long -> total * item })
        cumulative shouldBe 4723283400
    }

    private val hillFromInputFile = buildHillFrom(File(ClassLoader.getSystemResource("day03-input.txt").file).readLines())

    private val simpleHill = buildHillFrom(
        """..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#""".lines()
    )

}
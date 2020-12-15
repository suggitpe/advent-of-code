package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day03TobogganTrajectory.Companion.buildHillFrom
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/3
 */
class Day03TobogganTrajectoryTest {

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

    private val hillFromInputFile = buildHillFrom(readRowsFromFile("day03-input.txt"))

    @Test
    fun `can identify coordinates of a tree`() {
        assertThat(simpleHill.isATree(Pair(0, 0))).isFalse
        assertThat(simpleHill.isATree(Pair(2, 0))).isTrue
    }

    @Test
    fun `can identify the coordionates of a tree hen arborial genetics has caused the hill to widen`() {
        // these all are the same underpinning coordinate
        assertThat(simpleHill.isATree(Pair(11, 0))).isFalse
        assertThat(simpleHill.isATree(Pair(13, 0))).isTrue
    }

    @Test
    fun `throws out of bounds exception when we go further than the bottom of the hill`() {
        assertThatExceptionOfType(IndexOutOfBoundsException::class.java).isThrownBy {
            assertThat(simpleHill.isATree(Pair(1, 11))).isFalse
        }
    }

    @Test
    fun `counts the trees as it goes down the hill`() {
        assertThat(simpleHill.countTheTreesAsYouTobogganOnPathOf(Pair(3, 1))).isEqualTo(7)
    }

    @Test
    fun `counts the trees as it goes down the big hill`() {
        assertThat(hillFromInputFile.countTheTreesAsYouTobogganOnPathOf(Pair(3, 1))).isEqualTo(187)
    }

    @Test
    fun `counts the multiplication of all tree bumps from five runs`() {
        val cumulative = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
            .map { hillFromInputFile.countTheTreesAsYouTobogganOnPathOf(it) }
            .foldRight(1, { total: Long, item: Long -> total * item })
        assertThat(cumulative).isEqualTo(4723283400)
    }

    private fun readRowsFromFile(nameOfFile: String): List<String> {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readLines()
    }

}
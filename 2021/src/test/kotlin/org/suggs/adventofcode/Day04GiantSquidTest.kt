package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day04GiantSquid.simulateWhoWinsFirst
import org.suggs.adventofcode.Day04GiantSquid.simulateWhoWinsLast
import org.suggs.adventofcode.Util.getTextBlocksFrom
import org.suggs.adventofcode.domain.BingoBoard

@DisplayName("Giant Squid should ... ")
class Day04GiantSquidTest {

    @Test
    fun `creates board from string`() =
        BingoBoard(singleBoard).addUpRemainingNumbersLess(emptyList()) shouldBe 300

    @Test
    fun `adds up the winning board from a small set of data`() {
        val balls = verySmallDataSet.first().split(",").map { it.toInt() }
        val boards = verySmallDataSet.drop(1).map { BingoBoard(it) }
        simulateWhoWinsFirst(balls, boards) shouldBe 4512
    }

    @Test
    fun `adds up the winning board from read data set`() {
        val balls = readDataSet.first().split(",").map { it.toInt() }
        val boards = readDataSet.drop(1).map { BingoBoard(it) }
        simulateWhoWinsFirst(balls, boards) shouldBe 2496
    }

    @Test
    fun `adds up the last winning board from a small set of data`() {
        val balls = verySmallDataSet.first().split(",").map { it.toInt() }
        val boards = verySmallDataSet.drop(1).map { BingoBoard(it) }
        simulateWhoWinsLast(balls, boards) shouldBe 1924
    }

    @Test
    fun `adds up the last winning board from read data`() {
        val balls = readDataSet.first().split(",").map { it.toInt() }
        val boards = readDataSet.drop(1).map { BingoBoard(it) }
        simulateWhoWinsLast(balls, boards) shouldBe 25925
    }

    private val readDataSet: List<String> = getTextBlocksFrom("day04-input.txt")

    private val verySmallDataSet: List<String> = """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7""".split("\n\n")

    private val singleBoard = """22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19"""
}
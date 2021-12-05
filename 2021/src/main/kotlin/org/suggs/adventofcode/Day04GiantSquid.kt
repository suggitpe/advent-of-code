package org.suggs.adventofcode

import org.suggs.adventofcode.domain.BingoBoard

object Day04GiantSquid {

    fun simulateWhoWinsFirst(numbers: List<Int>, boards: List<BingoBoard>): Int {
        var playedNumbers = listOf<Int>()
        numbers.forEach { number ->
            playedNumbers = playedNumbers + number
            boards.forEach { board ->
                if (board.isCompletedWith(playedNumbers)) return board.addUpRemainingNumbersLess(playedNumbers) * number
            }
        }
        throw IllegalStateException("None of the boards completed")
    }

    fun simulateWhoWinsLast(numbers: List<Int>, boards: List<BingoBoard>): Int {
        var playedNumbers = listOf<Int>()
        var lastWinValue = 0
        numbers.forEach { number ->
            playedNumbers = playedNumbers + number
            boards.filter { !it.completed }.forEach { board ->
                if (board.isCompletedWith(playedNumbers)) {
                    board.completed = true
                    lastWinValue = board.addUpRemainingNumbersLess(playedNumbers) * number
                }
            }
        }
        return lastWinValue
    }
}
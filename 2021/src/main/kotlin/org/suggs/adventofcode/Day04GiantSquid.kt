package org.suggs.adventofcode

object Day04GiantSquid {

    fun simulateWhoWinsFirst(numbers: List<Int>, boards: List<Board>): Int {
        var playedNumbers = listOf<Int>()
        numbers.forEach { number ->
            playedNumbers = playedNumbers + number
            boards.forEach { board ->
                if (board.isCompletedWith(playedNumbers)) return board.addUpRemainingNumbersLess(playedNumbers) * number
            }
        }
        throw IllegalStateException("None of the boards completed")
    }

    fun simulateWhoWinsLast(numbers: List<Int>, boards: List<Board>): Int {
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

class Board(private val boardData: String) {
    private val rows = createRowsFromBoardData()
    private val columns = createColumnsFromBoardData()
    var completed = false

    fun isCompletedWith(playedNumbers: List<Int>): Boolean {
        return rows.any { playedNumbers.containsAll(it) } || columns.any { playedNumbers.containsAll(it) }
    }

    fun addUpRemainingNumbersLess(playedNumbers: List<Int>): Int {
        return rows.sumOf { it.filter { !playedNumbers.contains(it) }.sum() }
    }

    private fun createRowsFromBoardData() =
        boardData.split("\n").map {
            it.split("\\s+".toRegex())
                .filter { character -> character.isNotEmpty() }
                .map { number -> number.toInt() }
        }

    private fun createColumnsFromBoardData(): List<List<Int>> {
        fun createColumnsFromBoardData(columnIndex: Int, columns: List<List<Int>>): List<List<Int>> {
            return if (rows.first().size > columnIndex) {
                createColumnsFromBoardData(columnIndex + 1, columns + listOf(rows.map { it[columnIndex] }))
            } else
                columns
        }
        return createColumnsFromBoardData(0, emptyList())
    }
}
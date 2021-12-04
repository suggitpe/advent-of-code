package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class Day04GiantSquid(private val numbers: List<Int>, private val boards: List<Board>) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun simulate(): Int {
        log.info("We have ${numbers.size} numbers to check across ${boards.size} boards")
        numbers.forEach { number ->
            boards.forEach { board ->
                if (board.isCompletedWith(number)) return board.addUpRemainingNumbers() * number
            }
        }
        throw IllegalStateException("None of the boards completed")
    }
}

class Board(private val boardData: String) {
    private val log = LoggerFactory.getLogger(this::class.java)
    private var playedNumbers: List<Int> = listOf()
    private val rows: List<List<Int>> = createRowsFromBoardData()
    private val columns: List<List<Int>> = createColumnsFromBoardData()

    fun isCompletedWith(number: Int): Boolean {
        playedNumbers = playedNumbers + number
        return rows.any { playedNumbers.containsAll(it) } || columns.any { playedNumbers.containsAll(it) }
    }

    fun addUpRemainingNumbers(): Int {
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


    override fun toString(): String {
        return "Board(boardData='$boardData', log=$log, relevantNumbers=$playedNumbers, rows=$rows, columns=$columns)"
    }


}
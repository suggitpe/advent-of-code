package org.suggs.adventofcode.domain

class BingoBoard(private val boardData: String) {
    private val rows = createRowsFromBoardData()
    private val columns = createColumnsFromBoardData()
    var completed = false

    fun isCompletedWith(playedNumbers: List<Int>) =
        rows.any { playedNumbers.containsAll(it) } || columns.any { playedNumbers.containsAll(it) }

    fun addUpRemainingNumbersLess(playedNumbers: List<Int>) =
        rows.sumOf { it.filter { !playedNumbers.contains(it) }.sum() }


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
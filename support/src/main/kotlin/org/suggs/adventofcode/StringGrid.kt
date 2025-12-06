package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class StringGrid(val grid: List<List<String>>) {

    private val log = LoggerFactory.getLogger(this::class.java)

    companion object {
        operator fun invoke(gridData: String): StringGrid {
            return StringGrid(gridData.split("\n").map { it.trim().split("\\s+".toRegex()) })
        }
    }

    fun visualise() = grid.mapIndexed { idx, it -> log.debug("$idx: {}", it.joinToString("")) }

    fun getColumnAt(colNum: Int): List<String> = grid.fold(listOf<String>()) { acc, next -> acc + next[colNum] }

    fun columns(): List<List<String>> {
        val list = mutableListOf<List<String>>()
        grid[0].forEachIndexed { idx, _ ->
            list.add(getColumnAt(idx))
        }
        return list
    }
}
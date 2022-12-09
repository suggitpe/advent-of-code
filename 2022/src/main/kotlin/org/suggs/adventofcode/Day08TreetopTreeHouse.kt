package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day08TreetopTreeHouse {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countAllVisibleTreesFrom(listOfRows: List<List<Int>>): Int {
//        val listOfColumns: List<List<Int>> = buildListOfColumnsFrom(listOfRows)
        listOfRows.forEachIndexed { index, ints ->
//            ints.forEachIndexed { innerIndex, innerInts -> add }")} }
            log.debug("$listOfRows")
        }
        return 0
    }

    private fun isCoOrdinateVisible(x: Int, y: Int): Boolean {
        return false
    }

    private fun buildListOfColumnslistOfRowsFrom(listOfRows: List<List<Int>>): List<List<Int>> {
        return listOf()
    }
}

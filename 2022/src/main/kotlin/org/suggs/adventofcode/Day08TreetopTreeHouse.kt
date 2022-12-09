package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day08TreetopTreeHouse {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countAllVisibleTreesFrom(listOfRows: List<List<Int>>): Int {
        val listOfColumns = createListOfColumnsFrom(listOfRows)
        var count = 0
        listOfRows.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, data ->
                count += isCoOrdinateVisible(x, y, data, listOfRows, listOfColumns)
//                sanityCheck(x, y, data, listOfRows, listOfColumns)
            }
        }
        return count
    }

    private fun sanityCheck(x: Int, y: Int, data: Int, listOfRows: List<List<Int>>, listOfColumns: List<List<Int>>) {
        log.debug("====")
        log.debug("x=$x y=$y $data = ${listOfRows[y][x]} ${listOfColumns[x][y]}")
        log.debug("${listOfRows[y]} and ${listOfColumns[x]}")
        log.debug("${listOfRows[y].subList(0, x).filter { it >= data }} ${listOfRows[y].subList(x + 1, listOfRows[y].size).filter { it >= data }}")
        log.debug("${listOfColumns[x].subList(0, y)} ${listOfColumns[x].subList(y + 1, listOfRows[x].size)}")
    }

    private fun isCoOrdinateVisible(x: Int, y: Int, data: Int, listOfRows: List<List<Int>>, listOfColumns: List<List<Int>>) =
        when {
            listOfRows[y].subList(0, x).filter { it >= data }.isEmpty() -> 1
            listOfRows[y].subList(x + 1, listOfRows[y].size).filter { it >= data }.isEmpty() -> 1
            listOfColumns[x].subList(0, y).filter { it >= data }.isEmpty() -> 1
            listOfColumns[x].subList(y + 1, listOfRows[x].size).filter { it >= data }.isEmpty() -> 1
            else -> 0
        }


    private fun createListOfColumnsFrom(listOfRows: List<List<Int>>): List<List<Int>> {
        val listOfColumns: MutableList<MutableList<Int>> = mutableListOf()
        fun addPointToColumnList(y: Int, data: Int) {
            if (listOfColumns.size <= y)
                listOfColumns.add(mutableListOf())
            listOfColumns[y].add(data)
        }
        listOfRows.forEach { ints ->
            ints.forEachIndexed { innerIndex, innerInt -> addPointToColumnList(innerIndex, innerInt) }
        }
        return listOfColumns
    }
}

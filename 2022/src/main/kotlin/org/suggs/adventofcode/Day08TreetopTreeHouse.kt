package org.suggs.adventofcode

object Day08TreetopTreeHouse {

    fun countAllVisibleTreesFrom(listOfRows: List<List<Int>>): Int {
        val listOfColumns = createListOfColumnsFrom(listOfRows)
        var count = 0
        listOfRows.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, data ->
                count += isCoOrdinateVisible(x, y, data, listOfRows, listOfColumns)
            }
        }
        return count
    }

    fun isCoOrdinateVisible(x: Int, y: Int, data: Int, listOfRows: List<List<Int>>, listOfColumns: List<List<Int>>) =
        // checks that when row/column is split that no items are larger than the data value
        when {
            listOfRows[y].subList(0, x).none { it >= data } -> 1
            listOfRows[y].subList(x + 1, listOfRows[y].size).none { it >= data } -> 1
            listOfColumns[x].subList(0, y).none { it >= data } -> 1
            listOfColumns[x].subList(y + 1, listOfRows[x].size).none { it >= data } -> 1
            else -> 0
        }

    fun findHighestScenicScoreFrom(listOfRows: List<List<Int>>): Int {
        val listOfColumns = createListOfColumnsFrom(listOfRows)
        var max = 0
        listOfRows.forEachIndexed { y, ints ->
            ints.forEachIndexed { x, data ->
                max = maxOf(max, calculateScenicScore(x, y, data, listOfRows, listOfColumns))
            }
        }
        return max
    }

    private fun calculateScenicScore(x: Int, y: Int, data: Int, listOfRows: List<List<Int>>, listOfColumns: List<List<Int>>): Int {
        return listOfRows[y].subList(0, x).reversed().countWhileGreaterThan(data) *
                listOfRows[y].subList(x + 1, listOfRows[y].size).countWhileGreaterThan(data) *
                listOfColumns[x].subList(0, y).reversed().countWhileGreaterThan(data) *
                listOfColumns[x].subList(y + 1, listOfRows[x].size).countWhileGreaterThan(data)
    }

    private fun List<Int>.countWhileGreaterThan(data: Int): Int {
        val list = ArrayList<Int>()
        for (item in this) {
            if ((item >= data))
                return list.count() + 1
            list.add(item)
        }
        return list.count()
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



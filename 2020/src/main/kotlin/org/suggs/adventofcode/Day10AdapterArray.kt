package org.suggs.adventofcode

class Day10AdapterArray {

    companion object {
        fun getMapOfJoltDifferences(listOfInts: List<Int>): Map<Int, Int> {
            val listsPlusBaseAndTop = listOfInts
                .plus(listOfInts.minOrNull()!!.minus(1))
                .plus(listOfInts.maxOrNull()!!.plus(3))
            return listsPlusBaseAndTop
                .sorted()
                .zipWithNext()
                .map { it.second - it.first }
                .groupingBy { it }
                .eachCount()
        }

        fun countNumberOfValidCombinationsOfJoltAdaptersIn(listOfAdapters: List<Int>): Int {
            return listOfAdapters.size
        }
    }
}
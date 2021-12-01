package org.suggs.adventofcode

object Day01SonarSweep {

    fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>): Int {
        return countNumberOfIncrementsFrom(listOfNumbers, 0)
    }

    private fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>, counter: Int): Int {
        return if (listOfNumbers.size < 2) counter
        else countNumberOfIncrementsFrom(listOfNumbers.drop(1), counter + checkHeadIsIncrement(listOfNumbers.take(2)))
    }

    private fun checkHeadIsIncrement(head: List<Int>): Int {
        return if (head[0] < head[1]) return 1
        else 0
    }

}

package org.suggs.adventofcode

object Day01SonarSweep {

    fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>): Int {
        return countNumberOfIncrementsFrom(listOfNumbers, 0)
    }

    private fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>, counter: Int): Int {
        return if (listOfNumbers.size < 2) counter
        else countNumberOfIncrementsFrom(listOfNumbers.drop(1), counter + compareHeadForIncrement(listOfNumbers.take(2)))
    }

    private fun compareHeadForIncrement(head: List<Int>): Int {
        return if (head[0] < head[1]) return 1
        else 0
    }

    fun countNumberOfThreeNumberIncrementsFrom(listOfNumbers: List<Int>): Int {
        return countNumberOfThreeNumberIncrementsFrom(listOfNumbers, 0)
    }

    fun countNumberOfThreeNumberIncrementsFrom(listOfNumbers: List<Int>, counter: Int): Int {
        return if (listOfNumbers.size < 4) counter
        else countNumberOfThreeNumberIncrementsFrom(listOfNumbers.drop(1), counter + compareHeadThreeForIncrement(listOfNumbers.take(4)))
    }

    private fun compareHeadThreeForIncrement(head: List<Int>): Int {
        return if (head.take(3).sumOf { it } < head.drop(1).sumOf { it }) 1
        else 0
    }

}

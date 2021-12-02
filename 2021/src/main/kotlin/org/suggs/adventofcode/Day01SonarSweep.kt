package org.suggs.adventofcode

object Day01SonarSweep {

    fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>): Int {

        fun compareHeadForIncrement(head: List<Int>): Int {
            return (head[0] < head[1]).compareTo(false)
        }

        fun countNumberOfIncrementsFrom(listOfNumbers: List<Int>, counter: Int): Int {
            return if (listOfNumbers.size < 2) counter
            else countNumberOfIncrementsFrom(listOfNumbers.drop(1), counter + compareHeadForIncrement(listOfNumbers.take(2)))
        }

        return countNumberOfIncrementsFrom(listOfNumbers, 0)
    }

    fun countNumberOfThreeNumberIncrementsFrom(listOfNumbers: List<Int>): Int {

        fun compareHeadThreeForIncrement(head: List<Int>): Int {
            return (head.take(3).sumOf { it } < head.drop(1).sumOf { it }).compareTo(false)
        }

        fun countNumberOfThreeNumberIncrementsFrom(listOfNumbers: List<Int>, counter: Int): Int {
            return if (listOfNumbers.size < 4) counter
            else countNumberOfThreeNumberIncrementsFrom(listOfNumbers.drop(1), counter + compareHeadThreeForIncrement(listOfNumbers.take(4)))
        }

        return countNumberOfThreeNumberIncrementsFrom(listOfNumbers, 0)
    }
}

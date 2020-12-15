package org.suggs.adventofcode

/**
 * @see https://adventofcode.com/2020/day/1
 */
class Day01ReportRepair {

    fun findTwoNumbersAndTimesThemFrom(listOfInts: List<Int>): Int {
        return findAndMultiplyTwoFrom(listOfInts[0], listOfInts.drop(1))
    }

    private fun findAndMultiplyTwoFrom(head: Int, tail: List<Int>): Int {
        if (tail.isEmpty()) return 0

        val found = tail.find { it + head == 2020 }
        return if (found != null) {
            found * head
        } else
            findAndMultiplyTwoFrom(tail[0], tail.drop(1))
    }

    fun findThreeNumbersAndTimesThemFrom(listOfInts: List<Int>): Int {
        return findThreeNumbersAndTimesThemFrom(listOfInts[0], listOfInts[1], listOfInts.drop(2))
    }

    private fun findThreeNumbersAndTimesThemFrom(head: Int, headToo: Int, tail: List<Int>): Int {
        val combo = findAndMultiplyThreeFrom(head, headToo, tail)
        return if (combo != 0)
            combo
        else
            findThreeNumbersAndTimesThemFrom(headToo, tail[0], tail.drop(1))
    }

    private fun findAndMultiplyThreeFrom(head: Int, headToo: Int, tail: List<Int>): Int {
        if (tail.isEmpty()) return 0

        val found = tail.find { head + headToo + it == 2020 }
        return if (found != null) {
            head * headToo * found
        } else
            findAndMultiplyThreeFrom(head, tail[0], tail.drop(1))
    }


}
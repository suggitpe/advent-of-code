package org.suggs.adventofcode

/**
 * @see https://adventofcode.com/2020/day/5
 */
class Day05BinaryBoarding {

    companion object {
        private val charToBinaryLookup = mapOf('F' to '0', 'B' to '1', 'L' to 0, 'R' to '1')

        fun convertBoardingPassToDecimalSeat(boardingPass: String): Int {
            // convert to a binary string then convert to int
            return boardingPass.toCharArray().map { charToBinaryLookup[it] }.joinToString("").toInt(2)
        }
    }
}
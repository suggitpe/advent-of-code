package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class Day05BinaryBoarding {

    private val log = LoggerFactory.getLogger(this::class.java)

    companion object{

        private val charToBinaryLookup = mapOf('F' to '0', 'B' to '1', 'L' to 0, 'R' to '1')

        fun convertBoardingPassToDecimalSeat(boardingPass: String): Int {
            // convert to a binary string then convert to int
            return boardingPass.toCharArray().map { charToBinaryLookup[it] }.joinToString("").toInt(2)
        }
    }
}
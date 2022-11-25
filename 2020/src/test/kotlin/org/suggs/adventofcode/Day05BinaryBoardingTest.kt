package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05BinaryBoarding.Companion.convertBoardingPassToDecimalSeat
import org.suggs.adventofcode.Util.getFileLinesFrom
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/5
 */
class Day05BinaryBoardingTest {

    companion object {
        private val validBoardingPassSeatAllocations = mapOf("FBFBBFFRLR" to 357, "BFFFBBFRRR" to 567, "FFFBBBFRRR" to 119, "BBFFBBFRLL" to 820)
    }

    @Test
    fun `convert a boarding pass into a binary string then convert to decimal`() {
        validBoardingPassSeatAllocations.keys.map {
            convertBoardingPassToDecimalSeat(it) shouldBe validBoardingPassSeatAllocations[it]
        }
    }

    @Test
    fun `find boarding pass with the maximum seat number`() {
        readPasses.map { convertBoardingPassToDecimalSeat(it) }.maxOrNull() shouldBe 919
    }

    @Test
    fun `find missing seat in the set of boarding passes`() {
        val allBoardingPasses = readPasses.map { convertBoardingPassToDecimalSeat(it) }.sorted()
        allBoardingPasses[0].rangeTo(allBoardingPasses.last()).sum() - allBoardingPasses.sum() shouldBe 642
    }

    private val readPasses = getFileLinesFrom("day05-input.txt")

}
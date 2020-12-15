package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05BinaryBoarding.Companion.convertBoardingPassToDecimalSeat
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/5
 */
class Day05BinaryBoardingTest {

    private val validBoardingPassSeatAllocations = mapOf("FBFBBFFRLR" to 357, "BFFFBBFRRR" to 567, "FFFBBBFRRR" to 119, "BBFFBBFRLL" to 820)

    @Test
    fun `convert a boarding pass into a binary string then convert to decimal`() {
        validBoardingPassSeatAllocations.keys.map {
            assertThat(convertBoardingPassToDecimalSeat(it)).isEqualTo(validBoardingPassSeatAllocations[it])
        }
    }

    @Test
    fun `find boarding pass with the maximum seat number`() {
        assertThat(readPasses.map { convertBoardingPassToDecimalSeat(it) }.maxOrNull()).isEqualTo(919)
    }

    @Test
    fun `find missing seat in the set of boarding passes`() {
        val allBoardingPasses = readPasses.map { convertBoardingPassToDecimalSeat(it) }.sorted()
        assertThat(allBoardingPasses[0].rangeTo(allBoardingPasses.last()).sum() - allBoardingPasses.sum()).isEqualTo(642)
    }

    private val readPasses = File(ClassLoader.getSystemResource("day05-input.txt").file).readLines()

}
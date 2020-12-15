package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day05BinaryBoarding.Companion.convertBoardingPassToDecimalSeat
import java.io.File

class Day05BinaryBoardingTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    val validBoardingPassSeatAllocations = mapOf<String, Int>("FBFBBFFRLR" to 357, "BFFFBBFRRR" to 567, "FFFBBBFRRR" to 119, "BBFFBBFRLL" to 820)

    @Test
    fun `convert a boarding pass into a binary string then convert to decimal`() {
        validBoardingPassSeatAllocations.keys.map {
            assertThat(convertBoardingPassToDecimalSeat(it)).isEqualTo(validBoardingPassSeatAllocations[it])
        }
    }

    @Test
    fun `find boarding pass with the maximum seat number`(){
        assertThat(readRowsFromFile("day05-input.txt").map { convertBoardingPassToDecimalSeat(it) }.maxOrNull()).isEqualTo(919)
    }

    @Test
    fun `find missing seat in the set of boarding passes`(){
        val allBoardingPasses = readRowsFromFile("day05-input.txt").map { convertBoardingPassToDecimalSeat(it) }.sorted()
        assertThat(allBoardingPasses[0].rangeTo(allBoardingPasses.last()).sum() - allBoardingPasses.sum()).isEqualTo(642)
    }

    private fun readRowsFromFile(nameOfFile: String): List<String> {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readLines()
    }

}
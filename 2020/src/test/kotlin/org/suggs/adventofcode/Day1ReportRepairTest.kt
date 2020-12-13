package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/1
 */
class Day1ReportRepairTest {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val reportRepair = Day1ReportRepair()

    @Test
    fun `find two numbers in a list that add to 2020 from known list and multiply them`() {
        val bigNumber = reportRepair.findTwoNumbersAndTimesThemFrom(createKnownSetOfNumbers())
        log.info("Big number for two numbers from known list is $bigNumber")
        assertThat(bigNumber).isEqualTo(514579)
    }

    @Test
    fun `find two numbers in a list that add to 2020 from file and multiply them`() {
        val bigNumber = reportRepair.findTwoNumbersAndTimesThemFrom(readNumbersFromFile("day1-input.txt"))
        log.info("Big number for two numbers from file list is $bigNumber")
        assertThat(bigNumber).isGreaterThan(1)
    }

    @Test
    fun `find three numbers in a list that add to 2020 from known list and multiply them`() {
        val bigNumber = reportRepair.findThreeNumbersAndTimesThemFrom(createKnownSetOfNumbers())
        log.info("Big number for three numbers from known list is $bigNumber")
        assertThat(bigNumber).isEqualTo(241861950)
    }

    @Test
    fun `find three numbers in a list that add to 2020 from file and multiply them`() {
        val bigNumber = reportRepair.findThreeNumbersAndTimesThemFrom(readNumbersFromFile("day1-input.txt"))
        log.info("Big number for three numbers from file list is $bigNumber")
        assertThat(bigNumber).isGreaterThan(1)
    }


    private fun readNumbersFromFile(nameOfFile: String): List<Int> {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readLines().map { it.toInt() }
    }

    private fun createKnownSetOfNumbers(): List<Int> {
        return listOf(2004, 23, 123, 1721, 979, 366, 299, 675, 1456)
    }
}
package org.suggs.adventofcode

import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Util.createIntListFrom

/**
 * @see https://adventofcode.com/2020/day/1
 */
class Day01ReportRepairTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
        private val reportRepair = Day01ReportRepair()
    }

    @Test
    fun `find two numbers in a list that add to 2020 from known list and multiply them`() {
        val bigNumber = reportRepair.findTwoNumbersAndTimesThemFrom(setNumbers)
        log.info("Big number for two numbers from known list is $bigNumber")
        bigNumber shouldBe 514579
    }

    @Test
    fun `find two numbers in a list that add to 2020 from file and multiply them`() {
        val bigNumber = reportRepair.findTwoNumbersAndTimesThemFrom(readNumbers)
        log.info("Big number for two numbers from file list is $bigNumber")
        bigNumber shouldBeGreaterThan 1
    }

    @Test
    fun `find three numbers in a list that add to 2020 from known list and multiply them`() {
        val bigNumber = reportRepair.findThreeNumbersAndTimesThemFrom(setNumbers)
        log.info("Big number for three numbers from known list is $bigNumber")
        bigNumber shouldBe 241861950
    }

    @Test
    fun `find three numbers in a list that add to 2020 from file and multiply them`() {
        val bigNumber = reportRepair.findThreeNumbersAndTimesThemFrom(readNumbers)
        log.info("Big number for three numbers from file list is $bigNumber")
        bigNumber shouldBeGreaterThan 1
    }

    private val readNumbers = createIntListFrom("day01-input.txt")

    private val setNumbers = listOf(2004, 23, 123, 1721, 979, 366, 299, 675, 1456)

}
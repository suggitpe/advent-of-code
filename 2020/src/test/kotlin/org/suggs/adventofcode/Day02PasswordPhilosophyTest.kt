package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day02PasswordPhilosophy.Companion.createPhilosophyFrom
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/2
 */
class Day02PasswordPhilosophyTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun `count the number of valid passwords by range in a list`() {
        val numberOfValidPasswords = countNumberOfValidPasswordsByRangeIn(createKnownSetOfNumbers())
        log.info("Number of valid passwords by range in the known list is $numberOfValidPasswords")
        numberOfValidPasswords shouldBe 2
    }

    @Test
    fun `count the number of valid passwords by range in a file`() {
        val numberOfValidPasswords = countNumberOfValidPasswordsByRangeIn(readPasswords.map { createPhilosophyFrom(it) })
        log.info("Number of valid passwords by range in the file is $numberOfValidPasswords")
        numberOfValidPasswords shouldBe 643
    }

    @Test
    fun `count the number of valid passwords by placement in a list`() {
        val numberOfValidPasswords = countNumberOfValidPasswordsByPositionIn(createKnownSetOfNumbers())
        log.info("Number of valid passwords by position in the known list is $numberOfValidPasswords")
        numberOfValidPasswords shouldBe 1
    }

    @Test
    fun `count the number of valid passwords by placement in a file`() {
        val numberOfValidPasswords = countNumberOfValidPasswordsByPositionIn(readPasswords.map { createPhilosophyFrom(it) })
        log.info("Number of valid passwords by position in the file is $numberOfValidPasswords")
        numberOfValidPasswords shouldBe 388
    }

    private fun countNumberOfValidPasswordsByRangeIn(listOfPasswords: List<Day02PasswordPhilosophy>): Int {
        return listOfPasswords.filter { it.isValidByRange() }.size
    }

    private fun countNumberOfValidPasswordsByPositionIn(listOfPasswords: List<Day02PasswordPhilosophy>): Int {
        return listOfPasswords.filter { it.isValidByPosition() }.size
    }

    private val readPasswords = File(ClassLoader.getSystemResource("day02-input.txt").file).readLines()

    private fun createKnownSetOfNumbers(): List<Day02PasswordPhilosophy> {
        return listOf(
            createPhilosophyFrom("1-3 a: abcde"),
            createPhilosophyFrom("1-3 b: cdefg"),
            createPhilosophyFrom("2-9 c: ccccccccc")
        )
    }
}
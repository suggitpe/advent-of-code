package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day02PasswordPhilosophy.Companion.createPhilosophyFrom
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/2
 */
class Day02PasswordPhilosophyTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `count the number of valid passwords by range in a list`() {
        val numberOfValidPasswords = countNumberOfValidPasswordsByRangeIn(createKnownSetOfNumbers())
        log.info("Number of valid passwords by range in the known list is $numberOfValidPasswords")
        assertThat(numberOfValidPasswords).isEqualTo(2)
    }

    @Test
    fun `count the number of valid passwords by range in a file`(){
        val numberOfValidPasswords = countNumberOfValidPasswordsByRangeIn(readPasswordsFromFile("day02-input.txt"))
        log.info("Number of valid passwords by range in the file is $numberOfValidPasswords")
        assertThat(numberOfValidPasswords).isEqualTo(643)
    }

    @Test
    fun `count the number of valid passwords by placement in a list`(){
        val numberOfValidPasswords = countNumberOfValidPasswordsByPositionIn(createKnownSetOfNumbers())
        log.info("Number of valid passwords by position in the known list is $numberOfValidPasswords")
        assertThat(numberOfValidPasswords).isEqualTo(1)
    }

    @Test
    fun `count the number of valid passwords by placement in a file`(){
        val numberOfValidPasswords = countNumberOfValidPasswordsByPositionIn(readPasswordsFromFile("day02-input.txt"))
        log.info("Number of valid passwords by position in the file is $numberOfValidPasswords")
        assertThat(numberOfValidPasswords).isEqualTo(388)
    }

    private fun countNumberOfValidPasswordsByRangeIn(listOfPasswords: List<Day02PasswordPhilosophy>): Int {
        return listOfPasswords.filter { it.isValidByRange() }.size
    }

    private fun countNumberOfValidPasswordsByPositionIn(listOfPasswords: List<Day02PasswordPhilosophy>): Int {
        return listOfPasswords.filter { it.isValidByPosition() }.size
    }

    private fun readPasswordsFromFile(nameOfFile: String): List<Day02PasswordPhilosophy> {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readLines().map { createPhilosophyFrom(it) }
    }

    private fun createKnownSetOfNumbers(): List<Day02PasswordPhilosophy> {
        return listOf(
            createPhilosophyFrom("1-3 a: abcde"),
            createPhilosophyFrom("1-3 b: cdefg"),
            createPhilosophyFrom("2-9 c: ccccccccc")
        )
    }
}
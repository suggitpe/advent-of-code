package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllCommonlyAnsweredQuestionsByGroup
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllDiscreteQuestionsByGroup
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/6
 */
class Day06CustomCustomsTest() {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `read simple list and count all questions answered in th groups`() {
        assertThat(countAllDiscreteQuestionsByGroup(simpleInput)).isEqualTo(11)
    }

    @Test
    fun `read long file list and count all questions answered in teh groups`() {
        assertThat(countAllDiscreteQuestionsByGroup(readRowsFromFile("day06-input.txt"))).isEqualTo(6530)
    }

    @Test
    fun `read simple list and count all the commonly answered questions`() {
        assertThat(countAllCommonlyAnsweredQuestionsByGroup(simpleInput)).isEqualTo(6)
    }

    @Test
    fun `read log file list and count all teh commonly answered questions`() {
        assertThat(countAllCommonlyAnsweredQuestionsByGroup(readRowsFromFile("day06-input.txt"))).isEqualTo(3323)
    }

    private fun readRowsFromFile(nameOfFile: String): String {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readText()
    }

    private val simpleInput = """abc

a
b
c

ab
ac

a
a
a
a

b"""
}
package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllCommonlyAnsweredQuestionsByGroup
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllDiscreteQuestionsByGroup
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/6
 */
class Day06CustomCustomsTest() {

    @Test
    fun `read simple list and count all questions answered in th groups`() {
        val discreteQuestions = countAllDiscreteQuestionsByGroup(testAnswers)
        assertThat(discreteQuestions).isEqualTo(11)
    }

    @Test
    fun `read long file list and count all questions answered in teh groups`() {
        val discreteQuestions = countAllDiscreteQuestionsByGroup(readAnswers)
        assertThat(discreteQuestions).isEqualTo(6530)
    }

    @Test
    fun `read simple list and count all the commonly answered questions`() {
        val commonlyAnsweredQuestions = countAllCommonlyAnsweredQuestionsByGroup(testAnswers)
        assertThat(commonlyAnsweredQuestions).isEqualTo(6)
    }

    @Test
    fun `read log file list and count all teh commonly answered questions`() {
        val commonlyAnsweredQuestions = countAllCommonlyAnsweredQuestionsByGroup(readAnswers)
        assertThat(commonlyAnsweredQuestions).isEqualTo(3323)
    }

    private val readAnswers = File(ClassLoader.getSystemResource("day06-input.txt").file).readText()

    private val testAnswers = """abc

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
package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllCommonlyAnsweredQuestionsByGroup
import org.suggs.adventofcode.Day06CustomCustoms.Companion.countAllDiscreteQuestionsByGroup
import org.suggs.adventofcode.Util.readFile
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/6
 */
class Day06CustomCustomsTest() {

    @Test
    fun `read simple list and count all questions answered in th groups`() {
        val discreteQuestions = countAllDiscreteQuestionsByGroup(testAnswers)
        discreteQuestions shouldBe 11
    }

    @Test
    fun `read long file list and count all questions answered in teh groups`() {
        val discreteQuestions = countAllDiscreteQuestionsByGroup(readAnswers)
        discreteQuestions shouldBe 6530
    }

    @Test
    fun `read simple list and count all the commonly answered questions`() {
        val commonlyAnsweredQuestions = countAllCommonlyAnsweredQuestionsByGroup(testAnswers)
        commonlyAnsweredQuestions shouldBe 6
    }

    @Test
    fun `read log file list and count all teh commonly answered questions`() {
        val commonlyAnsweredQuestions = countAllCommonlyAnsweredQuestionsByGroup(readAnswers)
        commonlyAnsweredQuestions shouldBe 3323
    }

    private val readAnswers = readFile("day06-input.txt").readText()

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
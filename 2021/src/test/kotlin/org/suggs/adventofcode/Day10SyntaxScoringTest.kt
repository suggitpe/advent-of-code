package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day10SyntaxScoring.calculateSyntaxScoreFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day10SyntaxScoringTest {

    @Test
    fun `calculates syntax score for a single line`() = calculateSyntaxScoreFrom(listOf("(((({<>}<{<{<>}{[]{[]{}")) shouldBe 0

    @Disabled
    @Test
    fun `calculates syntax score from small data set`() = calculateSyntaxScoreFrom(sampleDataSet) shouldBe 26397

    @Disabled
    @Test
    fun `calculates syntax score from large data set`() = calculateSyntaxScoreFrom(readDataSet) shouldBeInRange 26397..31111

    private val readDataSet: List<String> = getFileLinesFrom("day09-input.txt")
    private val sampleDataSet: List<String> = """[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]""".split("\n")
}
package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.longs.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day10SyntaxScoring.calculateScoreOfRemainder
import org.suggs.adventofcode.Day10SyntaxScoring.calculateSyntaxScoreFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day10SyntaxScoringTest {

    @Test
    fun `calculates syntax score for a single line`() = calculateSyntaxScoreFrom(listOf("(((({<>}<{<{<>}{[]{[]{}", "{([(<{}[<>[]}>{[]{[(<()>")) shouldBe 1197

    @Test
    fun `calculates syntax score from small data set`() = calculateSyntaxScoreFrom(sampleDataSet) shouldBe 26397

    @Test
    fun `calculates syntax score from large data set`() = calculateSyntaxScoreFrom(readDataSet) shouldBeInRange 343000..344000

    @Test
    fun `calculates the core of the remainder of unfinished sequence for a single line`() =
        calculateScoreOfRemainder(listOf("(((({<>}<{<{<>}{[]{[]{}")) shouldBe 1480781

    @Test
    fun `calculates the core of the remainder of unfinished sequence for a sample data set`() =
        calculateScoreOfRemainder(sampleDataSet) shouldBe 288957

    @Test
    fun `calculates the core of the remainder of unfinished sequence for a large data set`() =
        calculateScoreOfRemainder(readDataSet) shouldBeInRange 2924730000..2924740000


    private val readDataSet: List<String> = getFileLinesFrom("day10-input.txt")
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
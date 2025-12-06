package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.StringGrid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.adventofcode.Util.createStringGridFromFileContent
import org.suggs.aoc2024.Day06TrashCompactor.addVerticalMathsProblemsFrom

class Day06TrashCompactorTest {

    @Test
    fun `adds vertical maths problems together - small`(){
        addVerticalMathsProblemsFrom(smallData) shouldBe 4277556L
    }

    @Test
    @Disabled
    fun `adds vertical maths problems together - large`(){
        addVerticalMathsProblemsFrom(largeData) shouldBe 1234L
    }

    private val smallData = StringGrid(
        """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  """
    )
    private val largeData = createStringGridFromFileContent("day06-input.txt")

}
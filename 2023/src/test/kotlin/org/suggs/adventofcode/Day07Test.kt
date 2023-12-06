package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07.execute
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("ggg")
class Day07Test {

    @Test
    fun `sss from small data set`() {
        execute(smallData) shouldBe 1
    }

    private val largeData = getFileLinesFrom("day07-input.txt")

    private val smallData = """""".split("\n")

}
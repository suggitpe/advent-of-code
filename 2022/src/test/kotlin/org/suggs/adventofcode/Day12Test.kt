package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day12.foo

@DisplayName("")
class Day12Test {

    @Test
    fun `jj`() =
        foo(smallData) shouldBe 1234

    private val largeData = Util.getFileLinesFrom("day12-input.txt")
    private val smallData = """""".split("\n")
}
package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.createIntListFrom
import org.suggs.adventofcode.Util.createStringIntMapFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Util should ... ")
class UtilTest {

    @Test
    fun `create list of ints from a file content`() {
        createIntListFrom("day01-input.txt").size shouldBe 2000
    }

    @Test
    fun `create a list of string - int from file content`() {
        createStringIntMapFrom("day02-input.txt").size shouldBe 1000
    }

    @Test
    fun `creates text blocks from a file content`() {
        getTextBlocksFrom("day04-input.txt").size shouldBe 101
    }

}
package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.createIntListFrom
import org.suggs.adventofcode.Util.createStringIntMapFrom

class UtilTest {

    @Test
    fun `creates list of ints from a file content`() {
        createIntListFrom("day01-input.txt").size shouldBe 2000
    }

    @Test
    fun `creates a list of string - int from file content`() {
        createStringIntMapFrom("day02-input.txt").size shouldBe 1000
    }

}
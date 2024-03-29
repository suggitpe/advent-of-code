package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Util.applyToEachLineForTotal
import org.suggs.adventofcode.Util.chunkFileIntoLinesOfThree
import org.suggs.adventofcode.Util.createIntListFrom
import org.suggs.adventofcode.Util.createStringIntMapFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom
import org.suggs.adventofcode.Util.readFileAsString

@DisplayName("Util should ... ")
class UtilTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `create list of ints from a file content`() {
        createIntListFrom("listOfInts.txt").size shouldBe 20
    }

    @Test
    fun `create a list of string - int from file content`() {
        createStringIntMapFrom("listIfMaps.txt").size shouldBe 25
    }

    @Test
    fun `creates text blocks from a file content`() {
        getTextBlocksFrom("listOfTextBlocks.txt").size shouldBe 10
    }

    @Test
    fun `applies function to file lines and returns an Int`() {
        applyToEachLineForTotal("listOfInts.txt") { it.toInt() } shouldBe 4628
    }

    @Test
    fun `chunks string list into chunks`() {
        chunkFileIntoLinesOfThree("listOfStringsForChunking.txt").size shouldBe 5
    }

    @Test
    fun `reads a file as a string`() {
        readFileAsString("listOfStringsForChunking.txt").split("\n").size shouldBe 15
    }

}
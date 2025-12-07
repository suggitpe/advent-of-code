package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

@DisplayName("Grid can")
class GridTest {


    private val log = LoggerFactory.getLogger(this::class.java)

    private val testGrid = Util.createGridFromFileContent("gridForTesting.txt")

    @Test
    fun `be visualised`(){
        testGrid.visualise()
    }

    @Test
    fun `get rows by row number`(){
        testGrid.getRowAt(1) shouldBe ".......#..".toCharArray()
    }

    @Test
    fun `get column by column number`(){
        testGrid.getColumnAt(1) shouldBe ".....#....".toCharArray()
    }

    @Test
    fun `can drop the last row in the grid`(){
        testGrid.rows().count() shouldBe 10
        testGrid.dropLastRow().rows().count() shouldBe 9
    }
}
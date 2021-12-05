package org.suggs.adventofcode.domain

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class VentLineTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    private val verticalVentLine = VentLine(Pair(0, 0), Pair(0, 3))
    private val reverseVerticalLine = VentLine(Pair(9, 9), Pair(9, 6))
    private val horizontalVentLine = VentLine(Pair(0, 0), Pair(3, 0))
    private val reverseHorizontalLine = VentLine(Pair(9, 9), Pair(6, 9))
    private val diagonalVentLine = VentLine(Pair(0, 0), Pair(3, 3))
    private val reverseDiagonalLine = VentLine(Pair(9, 9), Pair(6, 6))
    private val reverseInverseDiagonalLine = VentLine(Pair(9, 6), Pair(6, 9))

    @Test
    fun `know when its diagonal`() {
        assertSoftly {
            verticalVentLine.isDiagonal() shouldBe false
            horizontalVentLine.isDiagonal() shouldBe false
            diagonalVentLine.isDiagonal() shouldBe true
        }
    }

    @Test
    fun `know when its horizontal`() {
        assertSoftly {
            verticalVentLine.isHorizontal() shouldBe false
            horizontalVentLine.isHorizontal() shouldBe true
            diagonalVentLine.isHorizontal() shouldBe false
        }
    }

    @Test
    fun `know when its vertical`() {
        assertSoftly {
            verticalVentLine.isVertical() shouldBe true
            horizontalVentLine.isVertical() shouldBe false
            diagonalVentLine.isVertical() shouldBe false
        }
    }

    @Test
    fun `calculates range of coordinates on a horizontal line`() {
        horizontalVentLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0))
    }

    @Test
    fun `calculates range of coordinates on a vertical line`() {
        verticalVentLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3))
    }

    @Test
    fun `calculates range of coordinates on a diagonal line`() {
        diagonalVentLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2), Pair(3, 3))
    }

    @Test
    fun `calculates range of coordinates on a reverse horizontal line`() {
        log.info("horizontal vent line $horizontalVentLine contains ${horizontalVentLine.getAllCoordinatesInLine()}")
        reverseHorizontalLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(9, 9), Pair(8, 9), Pair(7, 9), Pair(6, 9))
    }

    @Test
    fun `calculates range of coordinates on a reverse vertical line`() {
        log.info("vertical vent line $horizontalVentLine contains ${horizontalVentLine.getAllCoordinatesInLine()}")
        reverseVerticalLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(9, 9), Pair(9, 8), Pair(9, 7), Pair(9, 6))
    }

    @Test
    fun `calculates range of coordinates on a reverse diagonal line`() {
        reverseDiagonalLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(9, 9), Pair(8, 8), Pair(7, 7), Pair(6, 6))
    }

    @Test
    fun `calculates range of coordinates on reverse diagonal unversed line`() {
        reverseInverseDiagonalLine.getAllCoordinatesInLine() shouldContainExactly
                listOf(Pair(9, 6), Pair(8, 7), Pair(7, 8), Pair(6, 9))
    }
}
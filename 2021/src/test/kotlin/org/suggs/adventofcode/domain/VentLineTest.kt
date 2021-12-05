package org.suggs.adventofcode.domain

import io.kotest.assertions.assertSoftly
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

    @Test
    fun `know when its diagonal`() {
        assertSoftly {
            verticalVentLine.isDiagonal() shouldBe false
            horizontalVentLine.isDiagonal() shouldBe false
            diagonalVentLine.isDiagonal() shouldBe true
        }
    }

    @Test
    fun `know when its horizonal`() {
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
        horizontalVentLine.getAllCoordinatesInLine().size shouldBe 4
    }

    @Test
    fun `calculates range of coordinates on a vertical line`() {
        verticalVentLine.getAllCoordinatesInLine().size shouldBe 4
    }

    @Test
    fun `calculates range of coordinates on a reverse horizontal line`() {
        log.info("horizontal vent line $horizontalVentLine contains ${horizontalVentLine.getAllCoordinatesInLine()}")
        reverseHorizontalLine.getAllCoordinatesInLine().size shouldBe 4
    }

    @Test
    fun `calculates range of coordinates on a reverse vertical line`() {
        log.info("vertical vent line $horizontalVentLine contains ${horizontalVentLine.getAllCoordinatesInLine()}")
        reverseVerticalLine.getAllCoordinatesInLine().size shouldBe 4
    }
}
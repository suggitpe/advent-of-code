package org.suggs.adventofcode

import org.junit.jupiter.api.DisplayName
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Tracks location of rop tail over map")
class Day09RopeBridgeTest {

    private val largeData = getFileLinesFrom("day09-input.txt")
    private val smallData = """R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2""".split(System.lineSeparator())
}
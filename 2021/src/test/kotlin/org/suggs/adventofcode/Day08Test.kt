package org.suggs.adventofcode

class Day08Test {

    private val readDataSet: List<Int> = Util.getFileLinesFrom("day08-input.txt").first().split(",").map { it.toInt() }
    private val verySmallDataSet: List<Int> = """16,1,2,0,4,2,7,1,2,14""".split(",").map { it.toInt() }
}
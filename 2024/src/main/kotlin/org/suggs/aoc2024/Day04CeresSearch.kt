package org.suggs.aoc2024

import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid

object Day04CeresSearch {

    fun countXmasWordsInGrid(grid: Grid) = grid.findAll('X').sumOf { grid.countXmasWords(it) }

    private fun Grid.countXmasWords(coord: Coordinate) = getAllWordsFrom(coord).count { it == "XMAS" }

    fun findCrossingMasInGrid(grid: Grid): Int {
        return grid.findAll('A').count { grid.partOfCrossingMas(it) }
    }

    private fun Grid.partOfCrossingMas(coord: Coordinate): Boolean {
        return ((valueOf(coord.upleft()) == 'S' && valueOf(coord.downright()) == 'M') || (valueOf(coord.upleft()) == 'M' && valueOf(coord.downright()) == 'S')) &&
                ((valueOf(coord.upright()) == 'S' && valueOf(coord.downleft()) == 'M') || (valueOf(coord.upright()) == 'M' && valueOf(coord.downleft()) == 'S'))
    }

    private fun Grid.getAllWordsFrom(coord: Coordinate) =
        listOf(wordUp(coord), wordDown(coord), wordLeft(coord), wordRight(coord), wordUpLeft(coord), wordUpRight(coord), wordDownLeft(coord), wordDownRight(coord))

    private fun Grid.wordUp(from: Coordinate) = listOf(valueOf(from), valueOf(from.up(1)), valueOf(from.up(2)), valueOf(from.up(3))).joinToString("")
    private fun Grid.wordDown(from: Coordinate) = listOf(valueOf(from), valueOf(from.down(1)), valueOf(from.down(2)), valueOf(from.down(3))).joinToString("")
    private fun Grid.wordLeft(from: Coordinate) = listOf(valueOf(from), valueOf(from.left(1)), valueOf(from.left(2)), valueOf(from.left(3))).joinToString("")
    private fun Grid.wordRight(from: Coordinate) = listOf(valueOf(from), valueOf(from.right(1)), valueOf(from.right(2)), valueOf(from.right(3))).joinToString("")
    private fun Grid.wordUpLeft(from: Coordinate) = listOf(valueOf(from), valueOf(from.upleft(1)), valueOf(from.upleft(2)), valueOf(from.upleft(3))).joinToString("")
    private fun Grid.wordUpRight(from: Coordinate) = listOf(valueOf(from), valueOf(from.upright(1)), valueOf(from.upright(2)), valueOf(from.upright(3))).joinToString("")
    private fun Grid.wordDownLeft(from: Coordinate) = listOf(valueOf(from), valueOf(from.downleft(1)), valueOf(from.downleft(2)), valueOf(from.downleft(3))).joinToString("")
    private fun Grid.wordDownRight(from: Coordinate) = listOf(valueOf(from), valueOf(from.downright(1)), valueOf(from.downright(2)), valueOf(from.downright(3))).joinToString("")


}
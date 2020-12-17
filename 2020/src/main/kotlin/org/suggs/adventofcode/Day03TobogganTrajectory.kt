package org.suggs.adventofcode

import org.slf4j.LoggerFactory

/**
 * @see https://adventofcode.com/2020/day/3
 */
class Day03TobogganTrajectory(hillMap: List<String>) {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val widthOfHillMap: Int = hillMap[0].length
    private val sizeOfHill: Int = hillMap.size
    private val treeCoordinates: List<List<Int>> =
        hillMap.map { Regex("#").findAll(it).map { it.range.first }.toList() }

    companion object {
        fun buildHillFrom(hill: List<String>): Day03TobogganTrajectory {
            return Day03TobogganTrajectory(hill)
        }
    }

    fun isATree(coordinates: Pair<Int, Int>): Boolean {
        return treeCoordinates[coordinates.second].contains(coordinates.first % widthOfHillMap)
    }

    fun countTheTreesAsYouTobogganOnPathOf(direction: Pair<Int, Int>): Long {

        fun countTheTreesAsYouTobogganOnPathOf(currentLocation: Pair<Int, Int>, direction: Pair<Int, Int>, treeCount: Long): Long {
            return if (currentLocation.second + direction.second > sizeOfHill) {
                log.info("For the direction $direction we bumped into $treeCount trees")
                treeCount
            } else {
                countTheTreesAsYouTobogganOnPathOf(Pair(currentLocation.first + direction.first, currentLocation.second + direction.second), direction, treeCount + isATree(currentLocation).compareTo(false))
            }
        }

        return countTheTreesAsYouTobogganOnPathOf(Pair(0, 0), direction, 0)
    }

}
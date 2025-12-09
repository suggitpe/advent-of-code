package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import kotlin.math.sqrt

data class Point3D(val x: Double, val y: Double, val z: Double) {
    companion object {
        operator fun invoke(positionData: String): Point3D {
            val points = positionData.split(",")
            return Point3D(points[0].toDouble(), points[1].toDouble(), points[2].toDouble())
        }
    }
}

object Day08Playground {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateCircuitsFrom(positions: List<String>): Int =
        calculateCircuits(positions.map { Point3D(it) })

    private fun calculateCircuits(positions: List<Point3D>): Int =
        calculateCircuitsWith(buildDistancesFrom(positions))

    private fun calculateCircuitsWith(distances: Map<Pair<Point3D, Point3D>, Double>): Int {
        return 0
    }

    private fun buildDistancesFrom(positions: List<Point3D>): Map<Pair<Point3D, Point3D>, Double> =
        positions.pairs().associateWith { calculateDistanceBetween(it) }

    private fun calculateDistanceBetween(positions: Pair<Point3D, Point3D>): Double {
        val dx = positions.second.x - positions.first.x
        val dy = positions.second.y - positions.first.y
        val dz = positions.second.z - positions.first.z

        return sqrt(dx * dx + dy * dy + dz * dz)
    }

    fun <T> List<T>.pairs(): List<Pair<T, T>> {
        if (size < 2) return emptyList()
        val tail = drop(1)
        val headPairs = tail.map { first() to it }
        return headPairs + tail.pairs()
    }


}
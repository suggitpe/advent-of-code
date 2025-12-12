package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day12ChristmasTreeFarm {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRegionsThatFitPresentsFrom(data: List<String>): Int =
        countRegionsThatFitPresentsFrom(
            createPresentsFrom(data.dropLast(1)),
            createRegionsFrom(data.takeLast(1).first())
        )

    fun countRegionsThatFitPresentsFrom(presents: Map<Int, Present>, regions: List<Region>): Int {
        return 0
    }

    private fun createPresentsFrom(presentData: List<String>): Map<Int, Present> {
        return presentData.associate {
            it.split("\n").first().split(":").first().toInt() to
                    Present(it.lines().drop(1).joinToString("\n"))
        }
    }

    private fun createRegionsFrom(regionData: String): List<Region> {
        return regionData.split("\n").map { Region(it) }
    }
}

data class Region(val regionSize: Pair<Int, Int>, val presents: List<Int>) {
    companion object {
        operator fun invoke(regionData: String): Region {
            return regionData.split(":")
                .let {
                    Region(
                        it[0].trim().split("x").map { it.toInt() }.let { (x, y) -> x to y },
                        it[1].trim().split(" ").map { it.toInt() })
                }
        }
    }
}

data class Present(val present: String) {
    companion object {

    }
}

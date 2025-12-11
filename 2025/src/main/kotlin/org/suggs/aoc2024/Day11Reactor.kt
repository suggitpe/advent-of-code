package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day11Reactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRoutesFrom(startingPosition: String, endingPosition: String, via: List<String>, devices: List<String>): Int {
        val routes = buildRoutesFrom(devices)
        return if (via.isEmpty()) countRoutesFrom(startingPosition, endingPosition, routes)
        else {
            (countRoutesFrom(startingPosition, via[0], routes)
                    * countRoutesFrom(via[0], via[1], routes)
                    * countRoutesFrom(via[1], endingPosition, routes)) +
                    (countRoutesFrom(startingPosition, via[1], routes)
                            * countRoutesFrom(via[1], via[0], routes)
                            * countRoutesFrom(via[0], endingPosition, routes))
        }
    }

    private fun countRoutesFrom(position: String, end: String, devices: Map<String, List<String>>): Int =
        if (end != "out" && position == "out") 0
        else if (position == end) 1
        else devices[position]?.map { countRoutesFrom(it, end, devices) }!!.sum()

    private fun buildRoutesFrom(devices: List<String>): Map<String, List<String>> =
        devices
            .map { device -> device.split(':') }
            .associate { it[0].trim() to it[1].trim().split(" ") }
}
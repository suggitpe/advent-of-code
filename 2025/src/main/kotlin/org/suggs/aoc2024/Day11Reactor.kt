package org.suggs.aoc2024

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.slf4j.LoggerFactory

object Day11Reactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    suspend fun countRoutesFrom(startingPosition: String, endingPosition: String, via: List<String>, devices: List<String>): Long {
        val routes = buildRoutesFrom(devices)
        return if (via.isEmpty()) countRoutesFrom(startingPosition, endingPosition, routes)
        else {
            coroutineScope {
                val leg1 = async { countRoutesFrom(startingPosition, via[0], routes) }
                val leg2 = async { countRoutesFrom(via[0], via[1], routes) }
                val leg3 = async { countRoutesFrom(via[1], endingPosition, routes) }
                val leg4 = async { countRoutesFrom(startingPosition, via[1], routes) }
                val leg5 = async { countRoutesFrom(via[1], via[0], routes) }
                val leg6 = async { countRoutesFrom(via[0], endingPosition, routes) }

                log.debug("all coroutines running")

                (leg1.await() * leg2.await() * leg3.await()) +
                        (leg4.await() * leg5.await() * leg6.await())
            }
        }
    }

    private fun countRoutesFrom(position: String, end: String, devices: Map<String, List<String>>): Long =
        if (end != "out" && position == "out") 0
        else if (position == end) 1
        else devices[position]?.map { countRoutesFrom(it, end, devices) }!!.sum()

    private fun buildRoutesFrom(devices: List<String>): Map<String, List<String>> =
        devices
            .map { device -> device.split(':') }
            .associate { it[0].trim() to it[1].trim().split(" ") }
}
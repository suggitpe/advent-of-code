package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day06WaitForIt {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateMultipliedNumberOfWaysToWinRace(data: List<String>) =
        createBoatRacesFrom(data).map { it.racesBeyondDistance() }.reduce(Long::times)

    fun calculateWinningRacesFromJoinedUpTimeDistance(data: List<String>) =
        createSingleUberRaceFrom(data).racesBeyondDistance()

    private fun createBoatRacesFrom(data: List<String>): List<BoatRace> {
        fun zipListsFrom(map: List<List<Long>>) = map.first().zip(map.last())

        return zipListsFrom(data.map { it.split(":").last() }.map { it.trim() }.map {
            it.split("\\s+".toRegex()).map { foo -> foo.toLong() }
        }).map { BoatRace(it) }
    }

    private fun createSingleUberRaceFrom(data: List<String>) =
        BoatRace(
            data.asSequence()
                .map { it.split(":").last() }
                .map { it.trim() }
                .map { it.filterNot { foo -> foo.isWhitespace() }.toLong() }
                .zipWithNext().first()
        )

    data class BoatRace(val time: Long, val distance: Long) {
        companion object {
            operator fun invoke(boatData: Pair<Long, Long>): BoatRace {
                return BoatRace(boatData.first, boatData.second)
            }
        }

        fun racesBeyondDistance(): Long {
            log.debug("testing for $time, $distance")
            return (1L.rangeTo(time)).map { calculateDistance(it) }.count { it > distance }.toLong()
        }

        private fun calculateDistance(hold: Long) = (time - hold) * hold
    }

}
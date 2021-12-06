package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day06LanternFish {
    fun calculateNumberOfFishFrom(verySmallDataSet: List<Int>): FishCounter {
        return FishCounter(verySmallDataSet)
    }
}

class FishCounter(private val dataSet: List<Int>) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    fun after(days: Int): Int {
        return processDailyEvolution(dataSet, days)
    }

    private fun processDailyEvolution(dataSet: List<Int>, days: Int): Int {
        return when (days) {
            0 -> dataSet.size
            else -> processDailyEvolution(dataSet.map { evolveSingleFish(it) }.flatten(), days - 1)
        }
    }

    private fun evolveSingleFish(fish: Int): List<Int> {
        return if (fish > 0) {
            listOf(fish - 1)
        } else {
            listOf(6, 8)
        }
    }

}

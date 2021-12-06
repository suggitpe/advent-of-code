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

    fun after(days: Int): Long {
        return processFishEvolution(dataSet, days, 0L)
    }

    private tailrec fun processFishEvolution(dataSet: List<Int>, days: Int, aggregate: Long): Long {
        return if (dataSet.isEmpty())
            return aggregate
        else
            processFishEvolution(dataSet.drop(1), days, aggregate + processEvolutionOf(dataSet.first(), days))
    }

    private fun processEvolutionOf(fish: Int, days: Int): Long {
        return if (days - fish > 0)
            processEvolutionOf(6, days - fish - 1) + processEvolutionOf(8, days - fish - 1)
        else
            1
    }

}

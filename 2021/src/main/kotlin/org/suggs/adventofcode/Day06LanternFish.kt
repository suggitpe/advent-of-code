package org.suggs.adventofcode

object Day06LanternFish {
    fun calculateNumberOfFishFrom(verySmallDataSet: List<Int>): FishCounter {
        return FishCounter(verySmallDataSet)
    }
}

/**
 * Summary of the algo:
 * 1. Don't try and calculate each fish ... there are 9 variants so pre-calc them
 * 2. Optimise the calculation by using subtraction and count additions rather than actually creating the fish
 * 3.
 */
class FishCounter(private val dataSet: List<Int>) {

    companion object {
        private const val MAX_FISH = 8
    }

    fun after(days: Int) =
        processFishEvolution(dataSet, calculateVariantCountsIntoMap(days))

    private fun processFishEvolution(dataSet: List<Int>, variants: Map<Int, Long>) =
        dataSet.map { variants[it] }.sumOf { it!! }

    private fun calculateVariantCountsIntoMap(days: Int) =
        (0..MAX_FISH).associateWith { countFishProducedFrom(it, days) }

    private fun countFishProducedFrom(fish: Int, days: Int): Long {
        return when {
            (days - fish > 0) -> countFishProducedFrom(6, days - fish - 1) + countFishProducedFrom(8, days - fish - 1)
            else -> 1
        }
    }

}

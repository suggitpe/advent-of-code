package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03BinaryDiagnostic {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculatePowerConsumptionFrom(dataSet: List<String>) =
        calculateGammaFrom(dataSet) * calculateEpsilonFrom(dataSet)

    fun calculateGammaFrom(dataSet: List<String>) =
        extractColumnCountsFrom(dataSet).map { it.maxByOrNull { it.value }?.key }.joinToString("").toInt(2)

    fun calculateEpsilonFrom(dataSet: List<String>) =
        extractColumnCountsFrom(dataSet).map { it.minByOrNull { it.value }?.key }.joinToString("").toInt(2)

    private fun extractColumnCountsFrom(dataSet: List<String>): List<Map<Char, Int>> {
        val counts = mutableListOf<Map<Char, Int>>()
        for (index in 0 until dataSet.first().length) {
            counts.add(dataSet.map { it[index] }.groupingBy { it }.eachCount())
        }
        return counts
    }

    fun calculateLifeSupportRatingFrom(dataSet: List<String>) =
        calculateOxygenGeneratorRatingFrom(dataSet) * calculateCO2ScrubberRatingFrom(dataSet)

    fun calculateOxygenGeneratorRatingFrom(dataSet: List<String>) =
        calculateOxygenGeneratorRatingFrom(dataSet, 0, "").toInt(2)

    private fun calculateOxygenGeneratorRatingFrom(dataSet: List<String>, index: Int, filterCriteria: String): String {
        return if (dataSet.size < 2) {
            dataSet.first()
        } else {
            val filter = dataSet.map { it[index] }
                .groupingBy { it }.eachCount()
                .toSortedMap(compareByDescending { it })
                .maxByOrNull { it.value }?.key
            calculateOxygenGeneratorRatingFrom(dataSet.filter { it.startsWith(filterCriteria + filter) }, index + 1, (filterCriteria + filter).toString())
        }
    }

    fun calculateCO2ScrubberRatingFrom(dataSet: List<String>) =
        calculateCO2ScrubberRatingFrom(dataSet, 0, "").toInt(2)

    private fun calculateCO2ScrubberRatingFrom(dataSet: List<String>, index: Int, filterCriteria: String): String {
        return if (dataSet.size < 2) {
            dataSet.first()
        } else {
            val filter = dataSet.map { it[index] }
                .groupingBy { it }.eachCount()
                .toSortedMap(compareBy { it })
                .minByOrNull { it.value }?.key
            calculateCO2ScrubberRatingFrom(dataSet.filter { it.startsWith(filterCriteria + filter) }, index + 1, (filterCriteria + filter).toString())
        }
    }


}
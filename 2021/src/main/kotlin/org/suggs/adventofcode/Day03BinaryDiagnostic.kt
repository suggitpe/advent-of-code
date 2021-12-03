package org.suggs.adventofcode

object Day03BinaryDiagnostic {

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

}
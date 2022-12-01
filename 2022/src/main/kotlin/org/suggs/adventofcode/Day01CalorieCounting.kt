package org.suggs.adventofcode

object Day01CalorieCounting {

    fun findMaxCaloriesFrom(calorieList: List<String>) = countCaloriesFrom(calorieList).max()

    fun findCaloriesOfTopThreeFrom(calorieList: List<String>) = countCaloriesFrom(calorieList).sortedDescending().take(3).sum()

    private fun countCaloriesFrom(calorieList: List<String>) = calorieList.map { it.split("\n").sumOf { it -> it.toInt() } }
}

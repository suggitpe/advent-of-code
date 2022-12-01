package org.suggs.adventofcode

object Day01CalorieCounting {

    fun findMaxCaloriesFrom(calorieList: List<String>) =
        countCaloriesFrom(calorieList).first()

    fun findMaxCaloriesOfTopThreeFrom(calorieList: List<String>) =
        countCaloriesFrom(calorieList).take(3).sum()

    private fun countCaloriesFrom(calorieList: List<String>) =
        calorieList.map { it.split("\n").sumOf { txt -> txt.toInt() } }.sortedDescending()

}

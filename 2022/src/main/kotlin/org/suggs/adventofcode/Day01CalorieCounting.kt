package org.suggs.adventofcode

object Day01CalorieCounting {

    fun findMaxCaloriesFrom(calorieList: List<String>): Int =
        countCaloriesFrom(calorieList).first()

    fun findMaxCaloriesOfTopThreeFrom(calorieList: List<String>): Int =
        countCaloriesFrom(calorieList).take(3).sum()

    private fun countCaloriesFrom(calorieList: List<String>): List<Int> =
        calorieList.map { it.split("\n").sumOf { txt -> txt.toInt() } }.sortedDescending()

}

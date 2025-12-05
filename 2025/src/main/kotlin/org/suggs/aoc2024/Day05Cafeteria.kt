package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day05Cafeteria {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countValidIngredientsFrom(ingredients: List<String>): Int =
        countValidIngredientsFrom(ingredients.first().split("\n").map { createRangeFrom(it) }, ingredients.last().split("\n").map { it.toLong() })

    private fun countValidIngredientsFrom(validIngredients: List<LongRange>, ingredients: List<Long>): Int =
        ingredients.count { ingredient -> validIngredients.any { it.contains(ingredient) } }

    private fun createRangeFrom(ingredientRange: String): LongRange =
        ingredientRange.split("-").let { LongRange(it[0].toLong(), it[1].toLong()) }

}
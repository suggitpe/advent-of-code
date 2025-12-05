package org.suggs.aoc2024

object Day05Cafeteria {

    fun countValidIngredientsFrom(ingredients: List<String>): Int {
        fun countValidIngredientsFrom(validIngredients: List<LongRange>, ingredients: List<Long>): Int =
            ingredients.count { ingredient -> validIngredients.any { it.contains(ingredient) } }

        return countValidIngredientsFrom(ingredients.first().split("\n").map { createRangeFrom(it) }, ingredients.last().split("\n").map { it.toLong() })
    }

    fun countTotalFreshIngredientsFrom(validIngredients: String): Long =
        countUniqueIngredientsFrom(validIngredients.split("\n").map { createRangeFrom(it) })

    private fun countUniqueIngredientsFrom(ingredientRanges: List<LongRange>): Long =
        combineRanges(ingredientRanges.sortedBy { it.first }, mutableListOf())

    private tailrec fun combineRanges(originalRanges: List<LongRange>, combinedRanges: MutableList<LongRange>): Long =
        if (originalRanges.isEmpty())
            combinedRanges.sumOf { it.size() }
        else
            combineRanges(originalRanges.drop(1), addRangeToCombinedRanges(originalRanges.first(), combinedRanges))

    private fun addRangeToCombinedRanges(rangeToAdd: LongRange, combinedRanges: MutableList<LongRange>): MutableList<LongRange> {
        if (combinedRanges.isEmpty())
            combinedRanges.add(rangeToAdd)
        else if (rangeToAdd.first > combinedRanges.last().last)
            combinedRanges.add(rangeToAdd)
        else if (rangeToAdd.last > combinedRanges.last().last)
            combinedRanges[combinedRanges.size - 1] = LongRange(combinedRanges.last().first, rangeToAdd.last)
        // else skip as it's already part of the last range
        return combinedRanges
    }

    fun LongRange.size(): Long = (this.last - this.first) + 1

    private fun createRangeFrom(ingredientRange: String): LongRange =
        ingredientRange.split("-").let { LongRange(it[0].toLong(), it[1].toLong()) }

}
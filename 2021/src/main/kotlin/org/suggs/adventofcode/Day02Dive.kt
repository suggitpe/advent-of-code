package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day02Dive {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculatePositionFrom(dataSet: List<Pair<String, Int>>): Int {
        fun sumOf(direction: String, dataSet: List<Pair<String, Int>>) =
            dataSet.filter { it.first == direction }.sumOf { it.second }

        return (sumOf("down", dataSet) - sumOf("up", dataSet)) * sumOf("forward", dataSet)
    }

    fun calculateAimedPositionFrom(dataSet: List<Pair<String, Int>>): Int {
        fun calculateAimFrom(dataSet: List<Pair<String, Int>>, aim: Int, aggregate: Pair<Int, Int>): Int {

            return if (dataSet.isEmpty()) {
                aggregate.first * aggregate.second
            } else {
                when (dataSet.first().first) {
                    "up" -> calculateAimFrom(dataSet.drop(1), aim - dataSet.first().second, aggregate)
                    "down" -> calculateAimFrom(dataSet.drop(1), aim + dataSet.first().second, aggregate)
                    else -> calculateAimFrom(dataSet.drop(1), aim, Pair(aggregate.first + dataSet.first().second, aggregate.second + (aim * dataSet.first().second)))
                }
            }
        }
        return calculateAimFrom(dataSet, 0, Pair(0, 0))
    }
}
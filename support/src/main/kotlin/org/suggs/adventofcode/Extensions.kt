package org.suggs.adventofcode

object Extensions {

    fun <T> List<T>.combinationsOf(size: Int): List<List<T>> {
        return when {
            size == 0 -> emptyList()
            size > this.size -> emptyList()
            size == 1 -> this.map { listOf(it) }
            size > 1 -> this.flatMapIndexed { index, elem ->
                this.drop(index + 1).combinationsOf(size - 1).map { comb -> listOf(elem) + comb }
            }

            else -> throw IllegalStateException()
        }
    }
}
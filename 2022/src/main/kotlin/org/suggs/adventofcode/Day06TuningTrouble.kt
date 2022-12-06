package org.suggs.adventofcode

object Day06TuningTrouble {

    fun identifyMarkerLocationFrom(data: String, sizeOfMarker: Int): Int {
        return data.indexOf(findUniqueLetters(data, sizeOfMarker)) + sizeOfMarker
    }

    private fun findUniqueLetters(data: String, sizeOfMarker: Int): String {
        return if (areCharactersUniqueFrom(data.take(sizeOfMarker)))
            data.take(sizeOfMarker)
        else
            findUniqueLetters(data.drop(1), sizeOfMarker)
    }

    private fun areCharactersUniqueFrom(data: String): Boolean {
        return data.toSet().size == data.length
    }
}
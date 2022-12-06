package org.suggs.adventofcode

object Day06TuningTrouble {

    fun identifyMarkerLocationFrom(data: String, sizeOfMarker: Int) =
        data.length - countOfLettersAfterMarkerFrom(data, sizeOfMarker)

    // love a bit of recursion
    private fun countOfLettersAfterMarkerFrom(data: String, sizeOfMarker: Int): Int {
        return if (areCharactersUniqueFrom(data.take(sizeOfMarker)))
            return data.length - sizeOfMarker
        else
            countOfLettersAfterMarkerFrom(data.drop(1), sizeOfMarker)
    }

    private fun areCharactersUniqueFrom(data: String) =
        data.toSet().size == data.length

}
package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day02CubeConundrum {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumIdsOfValidGamesFrom(gamesData: List<String>) =
        gamesData.fold(listOf<Game>()) { listOfGames, gameString -> listOfGames + Game(gameString) }
            .filter { it.sets.none { set -> set.blue > 14 || set.red > 12 || set.green > 13 } }
            .sumOf { it.id }
            .also { log.debug("Part 1: $it") }


    fun addUpPowerOfAllGames(gamesData: List<String>) =
        gamesData.fold(listOf<Game>()) { listOfGames, gameString -> listOfGames + Game(gameString) }
            .sumOf { it.minCubeCount().powerRating() }
            .also { log.debug("Part 2: $it") }

}

data class Game(val id: Int, val sets: List<GameSet>) {

    companion object {
        operator fun invoke(gameData: String): Game {
            return Game(
                gameData.split(":").first().split(" ").last().toInt(),
                gameData.split(":").last().split(";").fold(listOf<GameSet>()) { listOfSets, setString -> listOfSets + GameSet(setString) }
            )
        }
    }

    fun minCubeCount() = GameSet(sets.maxOf { it.red }, sets.maxOf { it.blue }, sets.maxOf { it.green })
}

data class GameSet(val red: Int, val blue: Int, val green: Int) {

    companion object {
        operator fun invoke(setData: String) =
            GameSet(getColourCountFrom(setData, "red"), getColourCountFrom(setData, "blue"), getColourCountFrom(setData, "green"))

        private fun getColourCountFrom(setData: String, colour: String) =
            extractCountFrom(setData.split(", ").map { it.trim() }.filter { it.contains(colour) })

        private fun extractCountFrom(setColour: List<String>) =
            when (setColour.isNotEmpty()) {
                true -> setColour.first().split(" ").first().toInt()
                else -> 0
            }
    }

    fun powerRating() = red * green * blue
}
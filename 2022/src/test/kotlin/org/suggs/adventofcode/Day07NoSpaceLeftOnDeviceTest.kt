package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07NoSpaceLeftOnDevice.findDirectoryThatFreesUpSpaceForUpdateFrom
import org.suggs.adventofcode.Day07NoSpaceLeftOnDevice.sumDirectoriesOver100KFrom

class Day07NoSpaceLeftOnDeviceTest {

    @Test
    fun `sums directories over 100k in size from small data`() =
        sumDirectoriesOver100KFrom(smallData) shouldBe 95437L

    @Test
    @Disabled
    fun `sums directories over 100k in size from larger data`() =
        sumDirectoriesOver100KFrom(largeData) shouldBe 1084L

    @Test
    fun `find directory that frees up enough space for update from small data`() =
        findDirectoryThatFreesUpSpaceForUpdateFrom(smallData) shouldBe 24933642L

    @Test
    @Disabled
    fun `find directory that frees up enough space for update from larger data`() =
        findDirectoryThatFreesUpSpaceForUpdateFrom(largeData) shouldBe 249L

    private val largeData: List<String> = Util.readFile("day07-input.txt").readText().split("$ ").map { it.trim() }
    private val smallData: List<String> = """${'$'} cd /
${'$'} ls
dir a
14848514 b.txt
8504156 c.dat
dir d
${'$'} cd a
${'$'} ls
dir e
29116 f
2557 g
62596 h.lst
${'$'} cd e
${'$'} ls
584 i
${'$'} cd ..
${'$'} cd ..
${'$'} cd d
${'$'} ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k""".split("$ ").map { it.trim() }
}
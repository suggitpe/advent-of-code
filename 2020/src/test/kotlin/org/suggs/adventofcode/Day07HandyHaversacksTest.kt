package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.buildRulesFromRulesSet
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.calculateDiscreteParentBagsFrom
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.calculateTheTotalContainedBagsFrom
import java.io.File

class Day07HandyHaversacksTest {

    @Test
    fun `can parse a set list of bag descriptions into a collection of rules`() {
        val rulesList = buildRulesFromRulesSet(testBags)
        assertThat(rulesList.size).isEqualTo(13)
    }

    @Test
    fun `can parse a large number of bag descriptions into a large collection of rules`() {
        val rulesList = buildRulesFromRulesSet(readBags)
        assertThat(rulesList.size).isEqualTo(1457)
    }

    @Test
    fun `can calculate the number of possible outer bags that shiny gold could reside in from graph`() {
        val numberOfBags = calculateDiscreteParentBagsFrom(testBags, "shiny gold")
        assertThat(numberOfBags).isEqualTo(4)
    }

    @Test
    fun `can calculate the number of possible outer bags that shiny gold could reside in from huge graph`() {
        val numberOfBags = calculateDiscreteParentBagsFrom(readBags, "shiny gold")
        assertThat(numberOfBags).isEqualTo(332)
    }

    @Test
    fun `can calculate the number of contained bags from a bag in a small graph`() {
        val containedBags = calculateTheTotalContainedBagsFrom(testBags, "shiny gold")
        assertThat(containedBags).isEqualTo(32)
    }

    @Test
    fun `can calculate the number of contained bags from a bag in a small graph for dark olive`() {
        val containedBags = calculateTheTotalContainedBagsFrom(testBags, "dark olive")
        assertThat(containedBags).isEqualTo(7)
    }

    @Test
    fun `can calculate the number of contained bags from a bag in a small graph for vibrant plum`() {
        assertThat(calculateTheTotalContainedBagsFrom(testBags, "vibrant plum")).isEqualTo(11)
    }

    @Test
    fun `can calculate from another test set of bags`(){
        assertThat(calculateTheTotalContainedBagsFrom(otherTestBags, "shiny gold")).isEqualTo(126)
    }

    @Test
    fun `can calculate all the contained bags in the huge set of bags`(){
        assertThat(calculateTheTotalContainedBagsFrom(readBags, "shiny gold")).isEqualTo(10875)
    }

    private val readBags: List<String> = File(ClassLoader.getSystemResource("day07-input.txt").file).readLines()

    private val testBags: List<String> = """light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.""".split("\n")

    private val otherTestBags: List<String> = """shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.""".split("\n")

}
package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.buildMapOfRulesKeyedByChild
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.buildRulesFromRulesSet
import org.suggs.adventofcode.Day07HandyHaversacks.Companion.calculateDiscreteParentBagsFrom
import java.io.File

class Day07HandyHaversacksTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `can parse a set list of bag descriptions into a collection of rules`() {
        val rulesList = buildRulesFromRulesSet(testBags)
        assertThat(rulesList.size).isEqualTo(13)
    }

    @Test
    fun `can create a map of rules keyed from the child object`(){
        val rulesMap = buildMapOfRulesKeyedByChild(testBags)
        assertThat(rulesMap.values.size).isEqualTo(7)
        assertThat(rulesMap.values.flatten().size).isEqualTo(13)
    }

    @Test
    fun `can parse a large number of bag descriptions into a large collection of rules`(){
        val rulesList = buildRulesFromRulesSet(readBags)
        assertThat(rulesList.size).isEqualTo(1457)
    }

    @Test
    fun `can create a map of a large number of bag rules keyed from the child object`(){
        val rulesMap = buildMapOfRulesKeyedByChild(readBags)
        assertThat(rulesMap.values.size).isEqualTo(413)
        assertThat(rulesMap.values.flatten().size).isEqualTo(1457)
    }

    @Test
    fun `can calculate the number of possible outer bags that shiny gold could reside in from graph`(){
        val rulesMap = buildMapOfRulesKeyedByChild(testBags)
        assertThat(calculateDiscreteParentBagsFrom(rulesMap, "shiny gold")).isEqualTo(4)
    }

    @Test
    fun `can calculate the number of possible outer bags that shiny gold could reside in from huge graph`(){
        val rulesMap = buildMapOfRulesKeyedByChild(readBags)
        assertThat(calculateDiscreteParentBagsFrom(rulesMap, "shiny gold")).isEqualTo(332)
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

}
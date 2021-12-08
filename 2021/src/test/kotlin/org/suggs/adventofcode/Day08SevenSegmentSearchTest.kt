package org.suggs.adventofcode

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day08SevenSegmentSearch.decodeAll
import org.suggs.adventofcode.Day08SevenSegmentSearch.simpleDecodeAll
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day08SevenSegmentSearchTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun `counts all decoded digits equalling 1,4,7,8 in small data set`() =
        simpleDecodeAll(verySmallDataSet) shouldBe 26

    @Test
    fun `counts all decoded digits equalling 1,4,7,8 in large data set`() =
        simpleDecodeAll(readDataSet) shouldBeInRange 440..470

    @Test
    fun `decodes digits references using small data set`() =
        decodeAll(verySmallDataSet) shouldBe 61229

    @Test
    fun `decodes digits references using large data set`() =
        decodeAll(readDataSet) shouldBeInRange 1091000..1092000

    private val readDataSet: List<Pair<String, String>> = getFileLinesFrom("day08-input.txt").map { it.split(" | ").let { foo -> Pair(foo[0], foo[1]) } }
    private val verySmallDataSet: List<Pair<String, String>> = """be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce""".split("\n").map { it.split(" | ").let { foo -> Pair(foo[0], foo[1]) } }
}
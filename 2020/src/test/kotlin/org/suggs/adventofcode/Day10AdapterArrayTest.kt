package org.suggs.adventofcode

import java.io.File

internal class Day10AdapterArrayTest {


    private val readArray = File(ClassLoader.getSystemResource("day09-input.txt").file).readLines().map { it.toInt() }

    private val setArray = """28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3""".split("\n").map { it.toInt() }
}
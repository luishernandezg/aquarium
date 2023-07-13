package aquarium.decorations

import java.util.SimpleTimeZone

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1)
    val d2 = Decorations("slate")
    println(d2)
    val d3 = Decorations("slate")
    println(d3)

    println(d3 == d1)
    println(d3 == d2)


    val d4 = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("Crystal", "wood", "diver")
    println(d5)

    // decomposition
    val (rock: String, wood: String, diver: String) = d5

    println(rock)
    println(wood)
    println(diver)
    
}

data class Decorations(val rocks: String)
data class Decorations2(val rocks: String, val wood: String, val diver: String)
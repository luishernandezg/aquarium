package new_spice

import java.util.*

fun main(args: Array<String>) {
    println("Hello Spice")
    val curry = Curry()
    println("Curry{ color: ${curry.color}}")
}

/*
* Make a sealed class prevent the class can be extended out of the current module and package, and all the kinds of classes are
* inferred in compile time
*
* The benefits of this are that the statement when can to infrared all the possibilities, this allows to ignore the else statement
* at the end of the when
* */
sealed class Spice(var name: String, var spiciness: String = "mild", spiceColor: SpiceColor) :
    SpiceColor by spiceColor {

    var heat: Int
        get() = when (spiciness) {
            "fire" -> 4
            "hot" -> 3
            "medium" -> 2
            "mild" -> 1
            else -> 0
        }
        set(value) {
            spiciness = when (value) {
                4 -> "fire"
                3 -> "hot"
                2 -> "medium"
                1 -> "mild"
                else -> "none"
            }
        }

    init {
        println("Spice { name: $name, spice: $spiciness, heat: $heat }")
    }

    override fun toString(): String {
        return "Spice: { name: $name, spiciness: $spiciness, heat: $heat }"
    }

    abstract fun prepareSpice()
}

class Curry(name: String = "Curry", spiciness: String = "mild", color: SpiceColor = YellowSpiceColor) :
    Spice(name = name, spiciness = spiciness, spiceColor = color), Grinder {
    override fun prepareSpice() {
        println("Prepare the $name")
    }

    override fun grind() {
        println("Grind the $name")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    var color: Color
}

object YellowSpiceColor : SpiceColor {
    override var color = Color.YELLOW
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}



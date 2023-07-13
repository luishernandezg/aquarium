package spice

import new_spice.Curry

fun main(args: Array<String>) {
    val mySimpleSpice = SimpleSpice()
    println("Spice{ name: ${mySimpleSpice.name} heat: ${mySimpleSpice.heat} }")

    val spices = listOf(
        Spice(name = "curry", spiciness = "mild"),
        Spice(name = "pepper", spiciness = "medium"),
        Spice(name = "cayenne", spiciness = "medium"),
        Spice(name = "ginger", spiciness = "mild"),
        Spice(name = "red curry", spiciness = "hot"),
        Spice(name = "green curry", spiciness = "mild"),
        Spice(name = "red pepper", spiciness = "fire"),
    )

    val mediumAndBelowSpices = spices.filter { it.heat <= 2 }

    println("mediumAndBelowSpices $mediumAndBelowSpices")
    println("Salt: ${makeSalt()}")

    val curryContainer = SpiceContainer(Spice(name = "curry"))
    val curryContainer2 = SpiceContainer(Spice(name = "ginger"))
    val curryContainer3 = SpiceContainer(Spice(name = "salt"))
    println(curryContainer.lavel)
    println(curryContainer2.lavel)
    println(curryContainer3.lavel)
}
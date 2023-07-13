package spice

class Spice(var name: String, var spiciness: String = "mild") {

    var heat: Int
        get() = when (spiciness) {
            "fire" -> 4
            "hot"-> 3
            "medium" -> 2
            "mild" -> 1
            else -> 0
        }
        set(value) {
            spiciness = when (value){
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


}

fun makeSalt(): Spice{
    return Spice(name = "salt", spiciness = "none")
}
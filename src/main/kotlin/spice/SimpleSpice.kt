package spice

class SimpleSpice {
    var name: String = "curry"
    var spiciness = "mild"
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}
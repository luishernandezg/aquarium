package spice

data class SpiceContainer(var spice: Spice) {
    var lavel: String = "This is a container for: ${spice.name}"

}
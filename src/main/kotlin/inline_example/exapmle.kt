package inline_example

fun main(args: Array<String>) {
    fishExamples()
}

data class Fish(val name: String)

fun fishExamples() {

    val fish = Fish("splashy")
    // without inline an object is created every call to myWith
    myWith(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })
    // with inline no object is created, and lambda body is inlined here
    fish.name.capitalize()
}

inline fun myWith(name: String, block: String. () -> Unit) {
    name.block()
}
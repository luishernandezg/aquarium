package aquarium5

import java.util.*

data class Fish(var name: String)

fun main(args: Array<String>) {
//    fishExamples()
    practice2()
}

fun fishExamples() {
    val fish = Fish(name = "splashy")

    /*with(fish.name) {
        replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }*/
    myWith(fish.name) {
        println(replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
    }

    println(fish.run { name })
    println(fish.apply { })

    val fis2 = Fish(name = "splashy").apply { name = "shark" }
    println(fis2.name)

    println(fish.let { it.name.capitalize() }.let { it + "fish" }.let { it.length }.let { it + 31 }.let { it + 3 })

}

fun practice2() {
    println("Practice higher order functions")
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    println(numbers.getDivisibleNumberBy {
        it.rem(3)
    })
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun List<Int>.getDivisibleNumberBy(block: (Int) -> Int): List<Int> {
    val resultList = mutableListOf<Int>()
    val listWithOperation = this.map { block(it) }

    println(listWithOperation)

    for (y in listWithOperation.indices) {
        if (listWithOperation[y] == 0)
            resultList.add(this[y])
    }
    return resultList
}


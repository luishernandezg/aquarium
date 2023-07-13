package aquarium

import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    buildAquarium()
    makeFish()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} Height: " +
            "${myAquarium.height}")

    myAquarium.height = 80
    println("Height: ${myAquarium.height}")
    println("Volume: ${myAquarium.volume}")

    val smallAquarium = Aquarium(length = 20, width = 15, height = 30)

    println("Small Aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println("Small aquarium 2: ${myAquarium2.volume} liters with " +
            "length: ${myAquarium2.length} " +
            "width: ${myAquarium2.width} height: ${myAquarium2.height}")

    /*val fish = Fish()
    val defaultFish = Fish.makeDefaultFish()
    val exampleFish = Fish.fishExample()*/


}

fun feedFish(fish: FishAction){
    fish.eat()
}

fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color} \nPlecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}

package aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish(), FishAction {
    override val color: String = "grey"
    override fun eat() {
        println("Hunt and eat fish")
    }

}

class Plecostomus(fishColor: FishColor = GoldColor):
    AquariumFish(),
    FishAction by PrintingFishAction(food = "much on algae"),
    FishColor by fishColor

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

object GoldColor: FishColor {
    override val color: String = "Gold"
}

class PrintingFishAction (val food: String): FishAction {
    override fun eat () {
        println(food)
    }
}

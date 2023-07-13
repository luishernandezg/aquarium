package aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {

    val size: Int

    init {
        println("First init block")
    }

    constructor(): this(friendly = true, volumeNeeded = 9){
        println("Running secondary constructor")
    }

    init {
        if (friendly)
            size = volumeNeeded
        else
            size = volumeNeeded * 2
    }

    init {
        println("constructed fish of size: $volumeNeeded final size: $size")
    }
    init {
        println("Last init block")
    }

    companion object {
        fun makeDefaultFish() = Fish(friendly = true, volumeNeeded = 50)
        fun fishExample(){
            val fish = Fish(friendly = true, volumeNeeded = 20)
            println("Is the fish friendly ${fish.friendly}. It needs volume ${fish.size}")
        }
    }
}
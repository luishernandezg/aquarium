package aquarium.generics

open class WaterSupply(var needsProcessed: Boolean) {
    override fun toString(): String {
        return "WaterSupply{Type: ${this::class.simpleName}, needsProcessed: $needsProcessed},"
    }
}

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {

    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed)
            cleaner.clean(waterSupply)
        println("adding water from $waterSupply")
    }
}

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean : ${aquarium.waterSupply.needsProcessed}")
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Item added")

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

class LakeWaterCleaner : Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

class GenericWaterCleaner : Cleaner<WaterSupply> {
    override fun clean(waterSupply: WaterSupply) {
        waterSupply.needsProcessed = false
    }
}

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.addWater(LakeWaterCleaner())

    val aquarium5 = Aquarium(TapWater())
    aquarium5.addWater(TapWaterCleaner())

    val aquarium6 = Aquarium(WaterSupply(needsProcessed = true))
    aquarium6.addWater(GenericWaterCleaner())
    addItemTo(aquarium)

    isWaterClean(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>()

}

interface Source<out T> {
    fun nextT(): T
//    fun throwFire(i: T)
}

class SourceFire(private var value: Number) : Source<String> {
    override fun nextT(): String {
        println("nextT fire")
        return "fire"
    }

}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is OK, since T is an out-parameter
    objects.nextT()
    // ...
}

fun main(args: Array<String>) {
    demo(SourceFire(1))
    genericExample()
}
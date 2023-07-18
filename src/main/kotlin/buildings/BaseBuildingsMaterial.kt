package buildings

import aquarium.generics.Aquarium
import aquarium.generics.WaterSupply

open class BaseBuildingsMaterial(open val numberNeeded: Int = 1)

inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T : BaseBuildingsMaterial> isSmallBuilding(building: Building<T>) {
    if (building.baseMaterialsNeeded < 500)
        println("Small building")
    else
        println("Large building")

}

class Wood() : BaseBuildingsMaterial() {
    override val numberNeeded = 4
}

class Brick() : BaseBuildingsMaterial() {
    override val numberNeeded = 8
}

@Suppress("MemberVisibilityCanBePrivate")
class Building<out T : BaseBuildingsMaterial>(val buildMaterial: T) {
    val baseMaterialsNeeded: Int = 100

    val actualMaterialNeeded = baseMaterialsNeeded * buildMaterial.numberNeeded

    fun build() {
        println("Material Needed:${actualMaterialNeeded} \nMaterial type: ${buildMaterial::class.simpleName}")
    }
}

fun main(args: Array<String>) {
    val building = Building<Wood>(buildMaterial = Wood())
    building.build()
    isSmallBuilding(building)
}
package buildings

open class BaseBuildingsMaterial(open val numberNeeded: Int = 1)

class Wood() : BaseBuildingsMaterial() {
    override val numberNeeded = 4
}

class Brick() : BaseBuildingsMaterial() {
    override val numberNeeded = 8
}

@Suppress("MemberVisibilityCanBePrivate")
class Building<T : BaseBuildingsMaterial>(var buildMaterial: T) {
    val baseMaterialsNeeded: Int = 100

    val actualMaterialNeeded = baseMaterialsNeeded * buildMaterial.numberNeeded

    fun build() {
        println("Material Needed:${actualMaterialNeeded} \nMaterial type: ${buildMaterial::class.simpleName}")
    }
}

fun main(args: Array<String>) {
    val building = Building<Wood>(buildMaterial = Wood()).build()
}
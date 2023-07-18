import kotlin.reflect.full.findAnnotation

class IteropFish {
    companion object {
        @JvmStatic
        fun interop() {

        }
    }
}

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = true
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
    val classObj = Plant::class

    // print all annotation
    for (annotation: Annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    // find one annotation, or null
    val annotated: ImAPlant? = classObj.findAnnotation<ImAPlant>()

    annotated.apply {
        println("Found a plant annotation")
    }
}

fun main() {
    reflections()
}
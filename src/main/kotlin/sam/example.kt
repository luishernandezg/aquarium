package sam

fun main(args: Array<String>) {

}

// Single Abstract Method = SAM
interface Runnable {
    fun run()
}

interface Callable {
    fun call()
}

fun example() {
    val runnable = object : Runnable {
        override fun run() {
            println("I'm a runnable")
        }
    }
//    JavaRun.runNow(runnable)
}
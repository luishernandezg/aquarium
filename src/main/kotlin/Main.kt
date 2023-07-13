import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val rollDice = { numberOfSides: Int -> if(numberOfSides == 0) 0 else Random().nextInt(1,numberOfSides)}
}
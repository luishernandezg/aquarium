package higher_order_function_game

enum class Directions { NORTH, SOUTH, EAST, WEST, START, END }

class Location(private val width: Int, private val height: Int) {
    private val map = Array(width) { arrayOfNulls<String>(height) }
    private var currentPosition = Pair(0, 0)

    init {
        map[0][0] = "Moria, where the death is everywhere"
        map[0][1] = "Hobbit Town, a peaceful place, where hobbits live"
        map[1][0] = "Tom's Forest, the domain off the Ancient Tom Bombadil"
        map[1][1] = "Rivendel, Home of the Elron's Elvens"
    }

    fun printMap() {
        println("You are in ${map[currentPosition.first][currentPosition.second]}")
        println("--")
        printDot(Pair(0, 1))
        printDot(Pair(1, 1))
        print("\n")
        printDot(Pair(0, 0))
        printDot(Pair(1, 0))
        print("\n")
        println("--")
    }

    fun printDot(pair: Pair<Int, Int>) {
        if (pair == currentPosition)
            print("X")
        else
            print("O")
    }

//    for (j in 0 until height) {
//    for (i in (width - 1) downTo 0) {

    fun getNameLocation(): String? {
        return map[currentPosition.first][currentPosition.second]
    }

    private fun isOutOflLimit(coordinate: Int) = coordinate !in 0 until height

    private fun isValidCoordinate(coordinate: Pair<Int, Int>): Boolean {
        return !(isOutOflLimit(coordinate.first) || isOutOflLimit(coordinate.second))
    }

    fun isValidMove(direction: Directions): Boolean {
        val newPosition = when (direction) {
            Directions.NORTH -> Pair(currentPosition.first, currentPosition.second + 1)
            Directions.SOUTH -> Pair(currentPosition.first, currentPosition.second - 1)
            Directions.WEST -> Pair(currentPosition.first - 1, currentPosition.second)
            Directions.EAST -> Pair(currentPosition.first + 1, currentPosition.second)
            else -> currentPosition
        }
        return isValidCoordinate(newPosition)
    }

    fun updateCurrentLocation(direction: Directions) {
        val newPosition = when (direction) {
            Directions.NORTH -> Pair(currentPosition.first, currentPosition.second + 1)
            Directions.SOUTH -> Pair(currentPosition.first, currentPosition.second - 1)
            Directions.WEST -> Pair(currentPosition.first - 1, currentPosition.second)
            Directions.EAST -> Pair(currentPosition.first + 1, currentPosition.second)
            else -> currentPosition
        }
        currentPosition = newPosition
    }

    fun resetLocation() {
        currentPosition = Pair(0, 0)
    }
}

class Game {
    val path: MutableList<Directions> = mutableListOf(Directions.START)
    val location = Location(2, 2)


    private fun move(direction: Directions, where: (Game) -> Boolean) {

        if (direction == Directions.END) {
            where(this)
            return
        }

        if (location.isValidMove(direction)) {
            println("Walking to the ${direction.name}")
            location.updateCurrentLocation(direction)
            where(this)

        } else
            println("You can't go more to the ${direction.name}")
    }

    fun makeMove(move: String?) {
        when (move) {
            "n" -> move(Directions.NORTH, (north))
            "s" -> move(Directions.SOUTH, (south))
            "e" -> move(Directions.EAST, (east))
            "w" -> move(Directions.WEST, (west))
            else -> move(Directions.END, (end))
        }
    }
}

val north = { game: Game -> game.path.add(Directions.NORTH) }
val south = { game: Game -> game.path.add(Directions.SOUTH) }
val east = { game: Game -> game.path.add(Directions.EAST) }
val west = { game: Game -> game.path.add(Directions.WEST) }
val end = { game: Game ->
    game.path.add(Directions.END)
    println("Game Over, Your adventure end in ${game.location.getNameLocation()}")
    println("Path: ${game.path}")
    game.path.clear()
    game.location.resetLocation()
    false
}

fun main() {
    val game = Game()

    var turn = 1
    while (true) {
        println("Map:")
        game.location.printMap()
        print("Turn:${turn} Enter a direction: n/s/e/w:")
        game.makeMove(readlnOrNull())
        println("Current Path: ${game.path} ")
        turn++
    }
    /*north(game)
    south(game)
    east(game)
    west(game)
    end(game)*/
}

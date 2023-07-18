package higher_order_function_game

enum class Directions { NORTH, SOUTH, EAST, WEST, START, END }

class Game {
    val path: MutableList<Directions> = mutableListOf(Directions.START)
}

val north = { game: Game -> game.path.add(Directions.NORTH) }
val south = { game: Game -> game.path.add(Directions.SOUTH) }
val east = { game: Game -> game.path.add(Directions.EAST) }
val west = { game: Game -> game.path.add(Directions.WEST) }
val end = { game: Game ->
    game.path.add(Directions.END)
    println("Game Over")
    println("Path: ${game.path}")
    game.path.clear()
    println("Path: ${game.path}")
    false
}

fun main() {
    val game = Game()
    north(game)
    south(game)
    east(game)
    west(game)
    end(game)
}

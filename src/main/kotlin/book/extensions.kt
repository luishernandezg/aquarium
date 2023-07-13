package book

fun Book.getWeight(): Double = pages * 1.5

fun Book.tornPages(numberOfPages: Int = 1) {
    pages -= numberOfPages
}
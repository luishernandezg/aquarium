package book

import java.util.Random

class Puppy {
    fun playWithBooK(book: Book) {
        val numberOfPages = Random().nextInt(1, 14)
        book.tornPages(numberOfPages = numberOfPages)
        println("The puppy is playing with the book and $numberOfPages pages fly out, woof woof!")
        println("-- Book life: ${book.pages} pages--")
    }
}
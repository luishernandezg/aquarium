package book

import java.time.Year
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    val book = Book("The lord of the ring", author = "J.K Tolkien")
    book.readPage()
    book.readPage()
    println("Book: $book")

    val eBook = ElectronicBook(title = "Return to Devil land", author = "Blizzard")
    eBook.readPage()
    eBook.readPage()

    println("eBook: $eBook")

    val basicBook = BasicBook(title = "Game of thrones", author = "R.R Martin", year = 1990)

    val (title, author) = basicBook.getData()
    val (titleComplete, authorComplete, yearComplete) = basicBook.getDataComplete()

    println("Basic book: $title, $author")
    println("Basic book: $titleComplete, $authorComplete, $yearComplete ")

    // Collections

    val allBooks = setOf<String>("The book", "The wind", "The fire", "The earth", "The water", "Hamlet")

    val library = mapOf<String, Set<String>>("William Shakespeare" to allBooks)

    val containHamlet = library.any { it.value.contains("Hamlet") }
    println("Hamlet is in the library? $containHamlet")

    val moreBooks = mutableMapOf<String, Set<String>>("R.R martin" to setOf<String>("Game of thrones", "The knights"))

    moreBooks.getOrPut("J.K Rowling") { setOf("Harry Potter and the holy stone") }
    println("moreBooks: $moreBooks")

}
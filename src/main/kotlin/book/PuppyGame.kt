package book

fun main(args: Array<String>) {
    println("Hello World!")

    val book = Book("The lord of the ring", author = "J.R.R Tolkien")
    book.readPage()
    book.readPage()
    println("Book: $book")
    val puppy = Puppy()

    while (book.pages > 0) {
        puppy.playWithBooK(book)
    }
}
package book

// Constants
const val MAX_BORROW_BOOKS = 2

open class Book(var title: String, var author: String, var pages: Int = 100) {

    private var currentPage = 0

    open fun readPage() {
        currentPage += 1
    }

    fun canBorrow(userBorrowBooks: Int): Boolean {
        return userBorrowBooks < MAX_BORROW_BOOKS

    }

    fun printUrl() {
        println("$BASE_URL/$title/.html")
    }

    override fun toString(): String {
        return "Book {title: $title, author: $author, currentPage: $currentPage, pages: $pages}"
    }

    companion object {
        const val BASE_URL = "www.library.home.api"
    }

}

object Constants {
    const val EXAMPLE_CONST = 1
}

class ElectronicBook(title: String, author: String, format: String = "text") : Book(title, author) {

    private var wordCount = 0

    override fun readPage() {
        wordCount += 250
    }

    override fun toString(): String {
        return "eBook {title: $title, author: $author, currentPage: $wordCount}"
    }
}

class BasicBook(var title: String, var author: String, var year: Int) {

    fun getData(): Pair<String, String> {
        return (title to author)
    }

    fun getDataComplete(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}
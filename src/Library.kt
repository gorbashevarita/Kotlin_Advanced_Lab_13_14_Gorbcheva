class Library<T> {
    private val items: MutableList<T> = mutableListOf()
    fun addItem(item: T) {
        items.add(item)
    }
    fun getItems(): List<T> {
        return items
    }
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)


sealed class LibraryItem

data class BookItem(val book: Book) : LibraryItem()
data class MagazineItem(val magazine: Magazine) : LibraryItem()
data class DVDItem(val dvd: DVD) : LibraryItem()


fun filterByYear(library: Library<LibraryItem>, year: Int): List<Book> {
    return library.getItems()
        .filterIsInstance<BookItem>()
        .filter { it.book.year == year }
        .map { it.book }
}

fun sortByTitle(library: Library<LibraryItem>): List<LibraryItem> {
    return library.getItems().sortedBy { item ->
        when (item) {
            is BookItem -> item.book.title
            is MagazineItem -> item.magazine.title
            is DVDItem -> item.dvd.title
        }
    }
}

fun groupByAuthor(library: Library<LibraryItem>): Map<String, List<Book>> {
    return library.getItems()
        .filterIsInstance<BookItem>()
        .groupBy { it.book.author }
        .mapValues { it.value.map { bookItem -> bookItem.book } }
}

fun calculateTotalDuration(library: Library<LibraryItem>): Int {
    return library.getItems()
        .filterIsInstance<DVDItem>()
        .sumOf { it.dvd.duration }
}


fun main() {
    val library = Library<LibraryItem>()

    val book1 = Book("Война и мир", "Лев Толстой", 1869, "1234567890")
    val book2 = Book("Преступление и наказание", "Фёдор Достоевский", 1866, "0987654321")
    val book3 = Book("Анна Каренина", "Лев Толстой", 1877, "1122334455")

    val magazine1 = Magazine("Наука и жизнь", 5, "May")
    val magazine2 = Magazine("Вокруг света", 12, "December")

    val dvd1 = DVD("Интерстеллар", "Кристофер Нолан", 169)
    val dvd2 = DVD("Форрест Гамп", "Роберт Земекис", 135)

    library.addItem(BookItem(book1))
    library.addItem(BookItem(book2))
    library.addItem(BookItem(book3))
    library.addItem(MagazineItem(magazine1))
    library.addItem(MagazineItem(magazine2))
    library.addItem(DVDItem(dvd1))
    library.addItem(DVDItem(dvd2))

    println("=== Фильтрация книг по году (1869) ===")
    val booksFrom1869 = filterByYear(library, 1869)
    booksFrom1869.forEach { println("${it.title} by ${it.author}") }

    println("\n=== Сортировка всех элементов по названию ===")
    val sortedItems = sortByTitle(library)
    sortedItems.forEach { item ->
        when (item) {
            is BookItem -> println("Книга: ${item.book.title}")
            is MagazineItem -> println("Журнал: ${item.magazine.title} (#${item.magazine.issue})")
            is DVDItem -> println("DVD: ${item.dvd.title} (${item.dvd.duration} мин)")
        }
    }

    println("\n=== Группировка книг по авторам ===")
    val groupedByAuthor = groupByAuthor(library)
    groupedByAuthor.forEach { (author, books) ->
        println("$author:")
        books.forEach { println("  - ${it.title} ($it.year)") }
    }

    println("\n=== Общая продолжительность DVD ===")
    val totalDuration = calculateTotalDuration(library)
    println("Общая продолжительность всех DVD: $totalDuration минут")
}

import java.util.Arrays;
import java.util.Comparator;

public class BookManager {
    private Book[] books;

    public BookManager(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() { return books; }
    public void setBooks(Book[] books) { this.books = books; }

    // a) Список книг заданного автора
    public Book[] getBooksByAuthor(String author) {
        return Arrays.stream(books)
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toArray(Book[]::new);
    }

    // b) Список книг заданного издательства
    public Book[] getBooksByPublisher(String publisher) {
        return Arrays.stream(books)
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .toArray(Book[]::new);
    }

    // c) Список книг, выпущенных после заданного года
    public Book[] getBooksPublishedAfterYear(int year) {
        return Arrays.stream(books)
                .filter(book -> book.getPublicationYear() > year)
                .toArray(Book[]::new);
    }

    // Дополнительно: сортировка по году издания
    public Book[] getBooksSortedByYear() {
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparingInt(Book::getPublicationYear));
        return sortedBooks;
    }

    // Дополнительно: сортировка по цене
    public Book[] getBooksSortedByPrice() {
        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparingDouble(Book::getPrice));
        return sortedBooks;
    }

    // Метод для вывода книг
    public static void printBooks(Book[] books, String title) {
        System.out.println("\n" + title + ":");
        System.out.println("=".repeat(110));
        System.out.printf("%-3s %-25s %-20s %-15s %-6s %-5s %-10s %-10s%n",
            "ID", "Название", "Автор", "Издательство", "Год", "Стр.", "Цена", "Переплет");
        System.out.println("-".repeat(110));
        
        if (books.length == 0) {
            System.out.println("Нет книг, соответствующих критерию.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
        System.out.println("=".repeat(110));
        System.out.println("Найдено книг: " + books.length);
    }

    // Метод для вывода статистики
    public void printStatistics() {
        System.out.println("\nСТАТИСТИКА БИБЛИОТЕКИ:");
        System.out.println("=".repeat(50));
        System.out.println("Общее количество книг: " + books.length);
        
        if (books.length > 0) {
            double minPrice = Arrays.stream(books).mapToDouble(Book::getPrice).min().orElse(0);
            double maxPrice = Arrays.stream(books).mapToDouble(Book::getPrice).max().orElse(0);
            double avgPrice = Arrays.stream(books).mapToDouble(Book::getPrice).average().orElse(0);
            
            int minYear = Arrays.stream(books).mapToInt(Book::getPublicationYear).min().orElse(0);
            int maxYear = Arrays.stream(books).mapToInt(Book::getPublicationYear).max().orElse(0);
            
            System.out.printf("Цены: от %.2f ₽ до %.2f ₽ (средняя: %.2f ₽)%n", minPrice, maxPrice, avgPrice);
            System.out.println("Годы издания: от " + minYear + " до " + maxYear);
        }
    }
}

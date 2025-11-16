import java.util.*;

/**
 * Класс для управления книгами с расширенной функциональностью.
 * Рефакторинг: добавлены методы для работы с коллекциями, улучшена производительность
 */
public class BookManager {
    private Book[] books;

    public BookManager(Book[] books) {
        // Рефакторинг: создаем защитную копию массива
        this.books = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            this.books[i] = books[i];
        }
    }

    public Book[] getBooks() { 
        // Рефакторинг: возвращаем копию массива
        Book[] copy = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            copy[i] = books[i];
        }
        return copy;
    }
    
    public void setBooks(Book[] books) { 
        this.books = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            this.books[i] = books[i];
        }
    }

    // Рефакторинг: улучшенный поиск по автору
    public Book[] getBooksByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            return new Book[0];
        }
        
        List<Book> result = new ArrayList<>();
        String searchAuthor = author.toLowerCase().trim();
        
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(searchAuthor)) {
                result.add(book);
            }
        }
        
        return result.toArray(new Book[0]);
    }

    // Рефакторинг: улучшенный поиск по издательству
    public Book[] getBooksByPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            return new Book[0];
        }
        
        List<Book> result = new ArrayList<>();
        String searchPublisher = publisher.toLowerCase().trim();
        
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(searchPublisher)) {
                result.add(book);
            }
        }
        
        return result.toArray(new Book[0]);
    }

    // Рефакторинг: улучшенный поиск книг после заданного года
    public Book[] getBooksPublishedAfterYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isPublishedAfter(year)) {
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }

    // Рефакторинг: новые методы для расширенной функциональности
    public Book[] getBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isPriceInRange(minPrice, maxPrice)) {
                result.add(book);
            }
        }
        return result.toArray(new Book[0]);
    }
    
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    
    public boolean containsBookByAuthor(String author) {
        for (Book book : books) {
            if (book.isAuthor(author)) {
                return true;
            }
        }
        return false;
    }

    // Рефакторинг: улучшенная сортировка по году
    public Book[] getBooksSortedByYear() {
        Book[] sortedBooks = getBooks(); // Используем getBooks() который возвращает копию
        
        // Сортировка пузырьком (можно заменить на Arrays.sort если доступен)
        for (int i = 0; i < sortedBooks.length - 1; i++) {
            for (int j = 0; j < sortedBooks.length - i - 1; j++) {
                if (sortedBooks[j].getPublicationYear() > sortedBooks[j + 1].getPublicationYear()) {
                    // Меняем местами
                    Book temp = sortedBooks[j];
                    sortedBooks[j] = sortedBooks[j + 1];
                    sortedBooks[j + 1] = temp;
                }
            }
        }
        return sortedBooks;
    }

    // Рефакторинг: улучшенная сортировка по цене
    public Book[] getBooksSortedByPrice() {
        Book[] sortedBooks = getBooks();
        
        for (int i = 0; i < sortedBooks.length - 1; i++) {
            for (int j = 0; j < sortedBooks.length - i - 1; j++) {
                if (sortedBooks[j].getPrice() > sortedBooks[j + 1].getPrice()) {
                    // Меняем местами
                    Book temp = sortedBooks[j];
                    sortedBooks[j] = sortedBooks[j + 1];
                    sortedBooks[j + 1] = temp;
                }
            }
        }
        return sortedBooks;
    }
    
    // Рефакторинг: новая сортировка по названию
    public Book[] getBooksSortedByTitle() {
        Book[] sortedBooks = getBooks();
        
        for (int i = 0; i < sortedBooks.length - 1; i++) {
            for (int j = 0; j < sortedBooks.length - i - 1; j++) {
                if (sortedBooks[j].getTitle().compareTo(sortedBooks[j + 1].getTitle()) > 0) {
                    // Меняем местами
                    Book temp = sortedBooks[j];
                    sortedBooks[j] = sortedBooks[j + 1];
                    sortedBooks[j + 1] = temp;
                }
            }
        }
        return sortedBooks;
    }

    // Рефакторинг: улучшенный метод вывода книг
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

    // Рефакторинг: расширенная статистика
    public void printStatistics() {
        System.out.println("\nСТАТИСТИКА БИБЛИОТЕКИ:");
        System.out.println("=".repeat(50));
        System.out.println("Общее количество книг: " + books.length);
        
        if (books.length > 0) {
            double minPrice = Double.MAX_VALUE;
            double maxPrice = Double.MIN_VALUE;
            double totalPrice = 0;
            int minYear = Integer.MAX_VALUE;
            int maxYear = Integer.MIN_VALUE;
            
            Set<String> uniqueAuthors = new HashSet<>();
            
            for (Book book : books) {
                // Статистика по ценам
                if (book.getPrice() < minPrice) minPrice = book.getPrice();
                if (book.getPrice() > maxPrice) maxPrice = book.getPrice();
                totalPrice += book.getPrice();
                
                // Статистика по годам
                if (book.getPublicationYear() < minYear) minYear = book.getPublicationYear();
                if (book.getPublicationYear() > maxYear) maxYear = book.getPublicationYear();
                
                // Уникальные авторы
                uniqueAuthors.add(book.getAuthor());
            }
            
            double avgPrice = totalPrice / books.length;
            
            System.out.printf("Цены: от %.2f ₽ до %.2f ₽ (средняя: %.2f ₽)%n", 
                minPrice, maxPrice, avgPrice);
            System.out.println("Годы издания: от " + minYear + " до " + maxYear);
            System.out.printf("Общая стоимость библиотеки: %.2f ₽%n", totalPrice);
            System.out.println("Уникальных авторов: " + uniqueAuthors.size());
        }
    }
    
    // Рефакторинг: метод для получения самой дорогой книги
    public Book getMostExpensiveBook() {
        if (books.length == 0) return null;
        
        Book mostExpensive = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPrice() > mostExpensive.getPrice()) {
                mostExpensive = books[i];
            }
        }
        return mostExpensive;
    }
    
    // Рефакторинг: метод для получения самой старой книги
    public Book getOldestBook() {
        if (books.length == 0) return null;
        
        Book oldest = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPublicationYear() < oldest.getPublicationYear()) {
                oldest = books[i];
            }
        }
        return oldest;
    }
}
public class Main {
    public static void main(String[] args) {
        // Создаем массив книг
        Book[] booksArray = {
            new Book(1, "Мастер и Маргарита", "Михаил Булгаков", "АСТ", 1967, 384, 450.50, "Твердый"),
            new Book(2, "Преступление и наказание", "Федор Достоевский", "Эксмо", 1866, 672, 380.00, "Твердый"),
            new Book(3, "Война и мир", "Лев Толстой", "Азбука", 1869, 1274, 890.00, "Твердый"),
            new Book(4, "1984", "Джордж Оруэлл", "АСТ", 1949, 320, 320.75, "Мягкий"),
            new Book(5, "Три товарища", "Эрих Мария Ремарк", "Эксмо", 1936, 480, 420.00, "Твердый"),
            new Book(6, "Сто лет одиночества", "Габриэль Гарсия Маркес", "АСТ", 1967, 416, 510.25, "Твердый"),
            new Book(7, "Маленький принц", "Антуан де Сент-Экзюпери", "Эксмо", 1943, 96, 250.00, "Мягкий"),
            new Book(8, "Убить пересмешника", "Харпер Ли", "Азбука", 1960, 416, 380.50, "Твердый"),
            new Book(9, "Гарри Поттер и философский камень", "Джоан Роулинг", "Махаон", 1997, 432, 560.00, "Твердый"),
            new Book(10, "Властелин колец", "Джон Рональд Руэл Толкин", "АСТ", 1954, 1056, 1200.00, "Твердый")
        };

        BookManager manager = new BookManager(booksArray);

        // Вывод всех книг
        System.out.println("ВСЕ КНИГИ В БИБЛИОТЕКЕ:");
        System.out.println("=".repeat(110));
        System.out.printf("%-3s %-25s %-20s %-15s %-6s %-5s %-10s %-10s%n",
            "ID", "Название", "Автор", "Издательство", "Год", "Стр.", "Цена", "Переплет");
        System.out.println("-".repeat(110));
        for (Book book : booksArray) {
            System.out.println(book);
        }
        System.out.println("=".repeat(110));

        // a) Список книг заданного автора
        Book[] tolstoyBooks = manager.getBooksByAuthor("Толстой");
        BookManager.printBooks(tolstoyBooks, "КНИГИ ЛЬВА ТОЛСТОГО");

        // b) Список книг заданного издательства
        Book[] astBooks = manager.getBooksByPublisher("АСТ");
        BookManager.printBooks(astBooks, "КНИГИ ИЗДАТЕЛЬСТВА 'АСТ'");

        // c) Список книг, выпущенных после 1950 года
        Book[] booksAfter1950 = manager.getBooksPublishedAfterYear(1950);
        BookManager.printBooks(booksAfter1950, "КНИГИ, ВЫПУЩЕННЫЕ ПОСЛЕ 1950 ГОДА");

        // Дополнительно: книги определенного автора (частичное совпадение)
        Book[] remarcBooks = manager.getBooksByAuthor("Ремарк");
        BookManager.printBooks(remarcBooks, "КНИГИ ЭРИХА МАРИИ РЕМАРКА");

        // Дополнительно: сортировка по году
        Book[] sortedByYear = manager.getBooksSortedByYear();
        BookManager.printBooks(sortedByYear, "КНИГИ ОТСОРТИРОВАННЫЕ ПО ГОДУ ИЗДАНИЯ");

        // Дополнительно: сортировка по цене
        Book[] sortedByPrice = manager.getBooksSortedByPrice();
        BookManager.printBooks(sortedByPrice, "КНИГИ ОТСОРТИРОВАННЫЕ ПО ЦЕНЕ");

        // Статистика
        manager.printStatistics();

        // Дополнительные примеры запросов
        System.out.println("\nДОПОЛНИТЕЛЬНЫЕ ЗАПРОСЫ:");

        // Книги издательства Эксмо
        Book[] eksmoBooks = manager.getBooksByPublisher("Эксмо");
        BookManager.printBooks(eksmoBooks, "КНИГИ ИЗДАТЕЛЬСТВА 'ЭКСМО'");

        // Книги после 2000 года (должна быть пустая выборка)
        Book[] booksAfter2000 = manager.getBooksPublishedAfterYear(2000);
        BookManager.printBooks(booksAfter2000, "КНИГИ, ВЫПУЩЕННЫЕ ПОСЛЕ 2000 ГОДА");
    }
}

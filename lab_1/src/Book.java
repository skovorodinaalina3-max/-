/**
 * Класс Book представляет книгу в библиотечной системе.
 * Рефакторинг: улучшена валидация, добавлены equals/hashCode, улучшено форматирование
 */
public class Book {
    private final int id; // Рефакторинг: сделал id финальным для неизменяемости
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pageCount;
    private double price;
    private String bindingType;

    // Рефакторинг: улучшенный конструктор с валидацией
    public Book(int id, String title, String author, String publisher, 
               int publicationYear, int pageCount, double price, String bindingType) {
        // Валидация входных данных
        if (id <= 0) throw new IllegalArgumentException("ID должен быть положительным числом");
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Название не может быть пустым");
        if (author == null || author.trim().isEmpty()) throw new IllegalArgumentException("Автор не может быть пустым");
        if (publicationYear < 1000 || publicationYear > 2030) throw new IllegalArgumentException("Некорректный год издания");
        if (pageCount <= 0) throw new IllegalArgumentException("Количество страниц должно быть положительным");
        if (price < 0) throw new IllegalArgumentException("Цена не может быть отрицательной");
        
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
        this.publisher = (publisher != null) ? publisher.trim() : "Неизвестно";
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
        this.price = price;
        this.bindingType = (bindingType != null) ? bindingType.trim() : "Мягкий";
    }

    // Геттеры (без изменений)
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }
    public int getPageCount() { return pageCount; }
    public double getPrice() { return price; }
    public String getBindingType() { return bindingType; }

    // Рефакторинг: улучшенные сеттеры с валидацией
    public void setTitle(String title) { 
        if (title == null || title.trim().isEmpty()) 
            throw new IllegalArgumentException("Название не может быть пустым");
        this.title = title.trim(); 
    }
    
    public void setAuthor(String author) { 
        if (author == null || author.trim().isEmpty()) 
            throw new IllegalArgumentException("Автор не может быть пустым");
        this.author = author.trim(); 
    }
    
    public void setPublicationYear(int publicationYear) { 
        if (publicationYear < 1000 || publicationYear > 2030) 
            throw new IllegalArgumentException("Некорректный год издания");
        this.publicationYear = publicationYear; 
    }
    
    public void setPageCount(int pageCount) { 
        if (pageCount <= 0) 
            throw new IllegalArgumentException("Количество страниц должно быть положительным");
        this.pageCount = pageCount; 
    }
    
    public void setPrice(double price) { 
        if (price < 0) 
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        this.price = price; 
    }

    // Рефакторинг: улучшенный toString с StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-3d ", id));
        sb.append(truncateString(title, 25)).append(" ");
        sb.append(truncateString(author, 20)).append(" ");
        sb.append(truncateString(publisher, 15)).append(" ");
        sb.append(String.format("%-6d %-5d %8.2f ₽ %-10s", 
            publicationYear, pageCount, price, bindingType));
        return sb.toString();
    }

    // Рефакторинг: выделенный метод для усечения строк
    private String truncateString(String text, int maxLength) {
        if (text.length() > maxLength) {
            return text.substring(0, maxLength - 3) + "...";
        }
        return String.format("%-" + maxLength + "s", text);
    }

    // Рефакторинг: добавлены equals и hashCode БЕЗ Objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id; // Считаем книги равными, если совпадают ID
    }

    @Override
    public int hashCode() {
        return id; // Простой hashCode на основе id
    }

    // Рефакторинг: добавлены полезные методы
    public boolean isPublishedAfter(int year) {
        return publicationYear > year;
    }
    
    public boolean isAuthor(String authorName) {
        return author.toLowerCase().contains(authorName.toLowerCase());
    }
    
    public boolean isPriceInRange(double minPrice, double maxPrice) {
        return price >= minPrice && price <= maxPrice;
    }
}
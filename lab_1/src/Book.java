public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private int pageCount;
    private double price;
    private String bindingType;

    // Конструктор
    public Book(int id, String title, String author, String publisher, 
               int publicationYear, int pageCount, double price, String bindingType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.pageCount = pageCount;
        this.price = price;
        this.bindingType = bindingType;
    }

    // Геттеры
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getPublicationYear() { return publicationYear; }
    public int getPageCount() { return pageCount; }
    public double getPrice() { return price; }
    public String getBindingType() { return bindingType; }

    // Сеттеры
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setPrice(double price) { this.price = price; }
    public void setBindingType(String bindingType) { this.bindingType = bindingType; }

    @Override
    public String toString() {
        return String.format(
            "%-3d %-25s %-20s %-15s %-6d %-5d %8.2f ₽ %-10s",
            id,
            title.length() > 25 ? title.substring(0, 22) + "..." : title,
            author.length() > 20 ? author.substring(0, 17) + "..." : author,
            publisher.length() > 15 ? publisher.substring(0, 12) + "..." : publisher,
            publicationYear,
            pageCount,
            price,
            bindingType
        );
    }
}

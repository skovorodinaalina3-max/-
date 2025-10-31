/**
 * Класс Планета
 */
public class Planet {
    private String name;
    private Continent[] continents;
    private int count;
    
    public Planet(String name) {
        this.name = name;
        this.continents = new Continent[10]; // начальный размер
        this.count = 0;
    }
    
    /**
     * Метод для добавления материка на планету
     */
    public void addContinent(Continent continent) {
        if (count < continents.length) {
            continents[count++] = continent;
        }
    }
    
    /**
     * Вывести названия материков на консоль
     */
    public void printContinentNames() {
        System.out.println("Названия материков планеты " + name + ":");
        for (int i = 0; i < count; i++) {
            System.out.println("- " + continents[i].name);
        }
    }
    
    /**
     * Вывести название планеты на консоль
     */
    public void printPlanetName() {
        System.out.println("Название планеты: " + name);
    }
    
    /**
     * Вывести количество материков на консоль
     */
    public void printContinentCount() {
        System.out.println("Количество материков: " + count);
    }
    
    // Переопределение стандартных методов
    public String toString() {
        return "Планета{название='" + name + "', количествоМатериков=" + count + "}";
    }
    
    //сравнения объектов на равенство
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Planet planet = (Planet) obj;
        return name.equals(planet.name);
    }
    
    public int hashCode() {
        return name.hashCode();
    }
    
    // Геттер для доступа к массиву материков (для демонстрации)
    public Continent[] getContinents() {
        return continents;
    }
    
    public int getCount() {
        return count;
    }
}
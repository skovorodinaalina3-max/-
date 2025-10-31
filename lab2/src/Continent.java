/**
 * Класс Материк
 */
public class Continent extends Figure {
    private double area;
    
    public Continent(String name, double area) {
        super(name);
        this.area = area;
    }
    
    public void printInfo() {
        System.out.println("Материк: " + name + ", Площадь: " + area + " млн кв.км");
    }
    
    // Методы доступа
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    
    // Переопределение стандартных методов
    public String toString() {
        return "Материк{название='" + name + "', площадь=" + area + "}";
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Continent continent = (Continent) obj;
        return Double.compare(continent.area, area) == 0 && 
               name.equals(continent.name);
    }
    
    public int hashCode() {
        return name.hashCode() + Double.hashCode(area);
    }
}
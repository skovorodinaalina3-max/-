/**
 * Абстрактный класс Фигура
 */
public abstract class Figure {
    protected String name;
    
    public Figure(String name) {
        this.name = name;
    }
    
    public abstract void printInfo();
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
/**
 * Класс, представляющий автомобиль.
 * Рефакторинг: добавлены только самые необходимые улучшения
 */
public class Car {
    private String brand;
    private String carClass;
    private double weight;
    private Driver driver;
    private Engine engine;

    public Car() {
    }

    public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    // Геттеры (без изменений)
    public String getBrand() { return brand; }
    public String getCarClass() { return carClass; }
    public double getWeight() { return weight; }
    public Driver getDriver() { return driver; }
    public Engine getEngine() { return engine; }

    // Сеттеры (без изменений)
    public void setBrand(String brand) { this.brand = brand; }
    public void setCarClass(String carClass) { this.carClass = carClass; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public void setEngine(Engine engine) { this.engine = engine; }

    /**
     * Получить стаж вождения водителя этого автомобиля
     * Без изменений
     */
    public int getDriverExperience() {
        return driver != null ? driver.getDrivingExperienceYears() : 0;
    }

    /**
     * Проверить, является ли автомобиль советского производства
     * Без изменений
     */
    public boolean isSovietCar() {
        return engine != null && engine.isSovietManufactured();
    }

    /**
     * Рефакторинг: новый полезный метод - может ли водитель управлять автомобилем
     * (водители со стажем менее 1 года не могут управлять мощными автомобилями)
     */
    public boolean canDriverOperateCar() {
        if (driver == null || engine == null) return false;
        return driver.getDrivingExperienceYears() >= 1 || engine.getPower() <= 100;
    }

    /**
     * Рефакторинг: улучшенное строковое представление
     */
    @Override
    public String toString() {
        return String.format("Автомобиль: %s (%s класс)\nВес: %.0f кг, Мощность: %d л.с.\nПроизводитель: %s%s\nВодитель: %s (стаж: %d лет)%s",
            brand, carClass, weight, 
            engine != null ? engine.getPower() : 0,
            engine != null ? engine.getManufacturer() : "Неизвестно",
            isSovietCar() ? " (Советский)" : "",
            driver != null ? driver.getFullName() : "Не назначен",
            getDriverExperience(),
            canDriverOperateCar() ? "" : " ⚠️ Требуется проверка");
    }
}
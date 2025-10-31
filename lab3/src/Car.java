/**
 * Класс, представляющий автомобиль.
 * Содержит информацию о марке, классе, весе, а также композиционно связан
 * с классами Driver и Engine.
 */
public class Car {
    private String brand;
    private String carClass;
    private double weight;
    private Driver driver;
    private Engine engine;

    /**
     * Конструктор по умолчанию
     */
    public Car() {
    }

    /**
     * Конструктор с параметрами
     * @param brand марка автомобиля
     * @param carClass класс автомобиля
     * @param weight вес автомобиля в кг
     * @param driver водитель автомобиля
     * @param engine двигатель автомобиля
     */
    public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    /**
     * Получить марку автомобиля
     * @return марка автомобиля
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Установить марку автомобиля
     * @param brand марка автомобиля
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Получить класс автомобиля
     * @return класс автомобиля
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Установить класс автомобиля
     * @param carClass класс автомобиля
     */
    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    /**
     * Получить вес автомобиля
     * @return вес автомобиля в кг
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Установить вес автомобиля
     * @param weight вес автомобиля в кг
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Получить водителя автомобиля
     * @return объект водителя
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Установить водителя автомобиля
     * @param driver объект водителя
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Получить двигатель автомобиля
     * @return объект двигателя
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Установить двигатель автомобиля
     * @param engine объект двигателя
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    /**
     * Получить стаж вождения водителя этого автомобиля
     * @return стаж вождения в годах
     */
    public int getDriverExperience() {
        return driver != null ? driver.getDrivingExperienceYears() : 0;
    }

    /**
     * Проверить, является ли автомобиль советского производства
     * @return true если автомобиль советского производства
     */
    public boolean isSovietCar() {
        return engine != null && engine.isSovietManufactured();
    }

    /**
     * Получить строковое представление объекта Car
     * @return строковое представление автомобиля
     */
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', carClass='" + carClass + 
               "', weight=" + weight + ", driver=" + driver + 
               ", engine=" + engine + "}";
    }
}
/**
 * Класс, представляющий двигатель автомобиля.
 * Содержит информацию о мощности и производителе.
 */
public class Engine {
    private int power;
    private String manufacturer;

    /**
     * Конструктор по умолчанию
     */
    public Engine() {
    }

    /**
     * Конструктор с параметрами
     * @param power мощность двигателя в лошадиных силах
     * @param manufacturer производитель двигателя
     */
    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    /**
     * Получить мощность двигателя
     * @return мощность в лошадиных силах
     */
    public int getPower() {
        return power;
    }

    /**
     * Установить мощность двигателя
     * @param power мощность в лошадиных силах
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Получить производителя двигателя
     * @return производитель двигателя
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Установить производителя двигателя
     * @param manufacturer производитель двигателя
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Проверить, является ли двигатель советского производства
     * @return true если двигатель советского производства
     */
    public boolean isSovietManufactured() {
        return manufacturer != null && 
               (manufacturer.toLowerCase().contains("ссср") || 
                manufacturer.toLowerCase().contains("советск") ||
                manufacturer.toLowerCase().contains("ваз") ||
                manufacturer.toLowerCase().contains("газ"));
    }

    /**
     * Получить строковое представление объекта Engine
     * @return строковое представление двигателя
     */
    @Override
    public String toString() {
        return "Engine{power=" + power + ", manufacturer='" + manufacturer + "'}";
    }
}
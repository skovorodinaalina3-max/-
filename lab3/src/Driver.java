/**
 * Класс, представляющий водителя автомобиля.
 * Содержит информацию о ФИО и стаже вождения.
 */
public class Driver {
    private String fullName;
    private int drivingExperienceYears;

    /**
     * Конструктор по умолчанию
     */
    public Driver() {
    }

    /**
     * Конструктор с параметрами
     * @param fullName ФИО водителя
     * @param drivingExperienceYears стаж вождения в годах
     */
    public Driver(String fullName, int drivingExperienceYears) {
        this.fullName = fullName;
        this.drivingExperienceYears = drivingExperienceYears;
    }

    /**
     * Получить ФИО водителя
     * @return ФИО водителя
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Установить ФИО водителя
     * @param fullName ФИО водителя
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Получить стаж вождения
     * @return стаж вождения в годах
     */
    public int getDrivingExperienceYears() {
        return drivingExperienceYears;
    }

    /**
     * Установить стаж вождения
     * @param drivingExperienceYears стаж вождения в годах
     */
    public void setDrivingExperienceYears(int drivingExperienceYears) {
        this.drivingExperienceYears = drivingExperienceYears;
    }

    /**
     * Получить строковое представление объекта Driver
     * @return строковое представление водителя
     */
    @Override
    public String toString() {
        return "Driver{fullName='" + fullName + "', drivingExperienceYears=" + drivingExperienceYears + "}";
    }
}
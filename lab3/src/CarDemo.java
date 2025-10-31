import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Демонстрационное приложение для тестирования классов автомобильной системы.
 * Предоставляет интерактивное меню для взаимодействия с пользователем.
 */
public class CarDemo {
    private static List<Car> cars = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Главный метод приложения
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        initializeSampleData();
        showMainMenu();
    }
    
    /**
     * Показывает главное меню приложения
     */
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n=== АВТОМОБИЛЬНАЯ СИСТЕМА ===");
            System.out.println("1. Показать все автомобили");
            System.out.println("2. Найти водителей по стажу");
            System.out.println("3. Найти автомобили по производителю");
            System.out.println("4. Добавить новый автомобиль");
            System.out.println("5. Показать статистику");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");
            
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    showAllCars();
                    break;
                case 2:
                    findDriversByExperience();
                    break;
                case 3:
                    findCarsByManufacturer();
                    break;
                case 4:
                    addNewCar();
                    break;
                case 5:
                    showStatistics();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
            
            System.out.print("\nНажмите Enter для продолжения...");
            scanner.nextLine();
        }
    }
    
    /**
     * Показывает все автомобили в системе
     */
    public static void showAllCars() {
        System.out.println("\n--- ВСЕ АВТОМОБИЛИ В СИСТЕМЕ ---");
        if (cars.isEmpty()) {
            System.out.println("Автомобилей нет в системе.");
            return;
        }
        
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%d. %s (%s класс)\n", i + 1, car.getBrand(), car.getCarClass());
            System.out.printf("   Вес: %.0f кг, Мощность: %d л.с.\n", car.getWeight(), car.getEngine().getPower());
            System.out.printf("   Производитель: %s\n", car.getEngine().getManufacturer());
            System.out.printf("   Водитель: %s (стаж: %d лет)\n", 
                car.getDriver().getFullName(), car.getDriver().getDrivingExperienceYears());
            System.out.println();
        }
    }
    
    /**
     * Поиск водителей по стажу
     */
    public static void findDriversByExperience() {
        System.out.println("\n--- ПОИСК ВОДИТЕЛЕЙ ПО СТАЖУ ---");
        System.out.print("Введите минимальный стаж вождения (лет): ");
        int minExperience = getIntInput();
        
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDriverExperience() >= minExperience) {
                filteredCars.add(car);
            }
        }
        
        if (filteredCars.isEmpty()) {
            System.out.printf("Водителей со стажем %d лет и более не найдено.\n", minExperience);
        } else {
            System.out.printf("\nВодители со стажем %d лет и более:\n", minExperience);
            for (int i = 0; i < filteredCars.size(); i++) {
                Car car = filteredCars.get(i);
                Driver driver = car.getDriver();
                System.out.printf("%d. %s - стаж: %d лет (управляет: %s)\n", 
                    i + 1, driver.getFullName(), driver.getDrivingExperienceYears(), car.getBrand());
            }
        }
    }
    
    /**
     * Поиск автомобилей по производителю
     */
    public static void findCarsByManufacturer() {
        System.out.println("\n--- ПОИСК АВТОМОБИЛЕЙ ПО ПРОИЗВОДИТЕЛЮ ---");
        System.out.println("1. Советские автомобили");
        System.out.println("2. Иностранные автомобили");
        System.out.println("3. Поиск по названию производителя");
        System.out.print("Выберите тип поиска: ");
        
        int searchType = getIntInput();
        List<Car> filteredCars = new ArrayList<>();
        
        switch (searchType) {
            case 1:
                // Советские автомобили
                for (Car car : cars) {
                    if (car.isSovietCar()) {
                        filteredCars.add(car);
                    }
                }
                System.out.println("\n--- АВТОМОБИЛИ СОВЕТСКОГО ПРОИЗВОДСТВА ---");
                break;
                
            case 2:
                // Иностранные автомобили
                for (Car car : cars) {
                    if (!car.isSovietCar()) {
                        filteredCars.add(car);
                    }
                }
                System.out.println("\n--- ИНОСТРАННЫЕ АВТОМОБИЛИ ---");
                break;
                
            case 3:
                // Поиск по названию
                System.out.print("Введите название производителя для поиска: ");
                String manufacturer = scanner.nextLine();
                for (Car car : cars) {
                    if (car.getEngine().getManufacturer().toLowerCase().contains(manufacturer.toLowerCase())) {
                        filteredCars.add(car);
                    }
                }
                System.out.printf("\n--- АВТОМОБИЛИ ПРОИЗВОДИТЕЛЯ '%s' ---\n", manufacturer);
                break;
                
            default:
                System.out.println("Неверный выбор!");
                return;
        }
        
        if (filteredCars.isEmpty()) {
            System.out.println("Автомобилей не найдено.");
        } else {
            for (int i = 0; i < filteredCars.size(); i++) {
                Car car = filteredCars.get(i);
                System.out.printf("%d. %s - %s, %d л.с.\n", 
                    i + 1, car.getBrand(), car.getEngine().getManufacturer(), car.getEngine().getPower());
                System.out.printf("   Класс: %s, Вес: %.0f кг, Водитель: %s\n",
                    car.getCarClass(), car.getWeight(), car.getDriver().getFullName());
            }
        }
    }
    
    /**
     * Добавление нового автомобиля в систему
     */
    public static void addNewCar() {
        System.out.println("\n--- ДОБАВЛЕНИЕ НОВОГО АВТОМОБИЛЯ ---");
        
        System.out.print("Марка автомобиля: ");
        String brand = scanner.nextLine();
        
        System.out.print("Класс автомобиля: ");
        String carClass = scanner.nextLine();
        
        System.out.print("Вес автомобиля (кг): ");
        double weight = getDoubleInput();
        
        System.out.println("\n--- ДАННЫЕ ВОДИТЕЛЯ ---");
        System.out.print("ФИО водителя: ");
        String driverName = scanner.nextLine();
        
        System.out.print("Стаж вождения (лет): ");
        int experience = getIntInput();
        
        System.out.println("\n--- ДАННЫЕ ДВИГАТЕЛЯ ---");
        System.out.print("Мощность двигателя (л.с.): ");
        int power = getIntInput();
        
        System.out.print("Производитель двигателя: ");
        String manufacturer = scanner.nextLine();
        
        // Создаем объекты
        Driver driver = new Driver(driverName, experience);
        Engine engine = new Engine(power, manufacturer);
        Car car = new Car(brand, carClass, weight, driver, engine);
        
        cars.add(car);
        System.out.printf("\nАвтомобиль '%s' успешно добавлен в систему!\n", brand);
    }
    
    /**
     * Показывает статистику системы
     */
    public static void showStatistics() {
        System.out.println("\n--- СТАТИСТИКА СИСТЕМЫ ---");
        
        if (cars.isEmpty()) {
            System.out.println("В системе нет автомобилей.");
            return;
        }
        
        int totalCars = cars.size();
        int sovietCars = 0;
        int totalPower = 0;
        int totalExperience = 0;
        Car mostPowerfulCar = cars.get(0);
        Driver mostExperiencedDriver = cars.get(0).getDriver();
        
        for (Car car : cars) {
            // Считаем советские автомобили
            if (car.isSovietCar()) {
                sovietCars++;
            }
            
            // Суммируем мощность
            totalPower += car.getEngine().getPower();
            
            // Суммируем стаж
            totalExperience += car.getDriverExperience();
            
            // Находим самый мощный автомобиль
            if (car.getEngine().getPower() > mostPowerfulCar.getEngine().getPower()) {
                mostPowerfulCar = car;
            }
            
            // Находим самого опытного водителя
            if (car.getDriverExperience() > mostExperiencedDriver.getDrivingExperienceYears()) {
                mostExperiencedDriver = car.getDriver();
            }
        }
        
        System.out.printf("Общее количество автомобилей: %d\n", totalCars);
        System.out.printf("Советских автомобилей: %d (%.1f%%)\n", 
            sovietCars, (sovietCars * 100.0 / totalCars));
        System.out.printf("Средняя мощность: %.1f л.с.\n", (double) totalPower / totalCars);
        System.out.printf("Средний стаж водителей: %.1f лет\n", (double) totalExperience / totalCars);
        System.out.printf("Самый мощный автомобиль: %s (%d л.с.)\n", 
            mostPowerfulCar.getBrand(), mostPowerfulCar.getEngine().getPower());
        System.out.printf("Самый опытный водитель: %s (%d лет)\n", 
            mostExperiencedDriver.getFullName(), mostExperiencedDriver.getDrivingExperienceYears());
    }
    
    /**
     * Инициализирует тестовые данные
     */
    private static void initializeSampleData() {
        // Создаем водителей с разным стажем
        Driver driver1 = new Driver("Иванов Петр Сидорович", 3);
        Driver driver2 = new Driver("Петров Иван Васильевич", 7);
        Driver driver3 = new Driver("Сидорова Мария Ивановна", 10);
        Driver driver4 = new Driver("Козлов Алексей Дмитриевич", 2);
        Driver driver5 = new Driver("Николаев Дмитрий Сергеевич", 15);
        
        // Создаем двигатели разных производителей
        Engine engine1 = new Engine(75, "ВАЗ (СССР)");
        Engine engine2 = new Engine(120, "ГАЗ (СССР)");
        Engine engine3 = new Engine(150, "Ford Motors (USA)");
        Engine engine4 = new Engine(95, "Москвич (СССР)");
        Engine engine5 = new Engine(200, "BMW (Germany)");
        
        // Создаем автомобили
        cars.add(new Car("Жигули ВАЗ-2106", "C", 1100, driver1, engine1));
        cars.add(new Car("Волга ГАЗ-24", "E", 1500, driver2, engine2));
        cars.add(new Car("Ford Focus", "C", 1300, driver3, engine3));
        cars.add(new Car("Москвич-412", "C", 1050, driver4, engine4));
        cars.add(new Car("BMW X5", "F", 2100, driver5, engine5));
    }
    
    /**
     * Вспомогательный метод для получения целочисленного ввода
     */
    private static int getIntInput() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите целое число: ");
            }
        }
    }
    
    /**
     * Вспомогательный метод для получения дробного ввода
     */
    private static double getDoubleInput() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }
    }
}
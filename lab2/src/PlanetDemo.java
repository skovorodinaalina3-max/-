/**
 * Демонстрационный класс
 */
public class PlanetDemo {
    public static void main(String args[]) {
        // Создание планеты Земля
        Planet earth = new Planet("Земля");
        
        // Создание и добавление материков
        earth.addContinent(new Continent("Евразия", 54.76));
        earth.addContinent(new Continent("Африка", 30.37));
        earth.addContinent(new Continent("Северная Америка", 24.71));
        earth.addContinent(new Continent("Южная Америка", 17.84));
        earth.addContinent(new Continent("Австралия", 8.56));
        earth.addContinent(new Continent("Антарктида", 14.20));
        
        System.out.println("---------- ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССОВ ----------\n");
        
        // Вызов методов из задания
        System.out.println("1. ОСНОВНЫЕ МЕТОДЫ:");
        earth.printPlanetName();
        earth.printContinentCount();
        earth.printContinentNames();
        
        // Демонстрация toString()
        System.out.println("\n2. МЕТОД TOSTRING():");
        System.out.println("   " + earth.toString());
        
        // Демонстрация equals() и hashCode()
        System.out.println("\n3. СРАВНЕНИЕ ОБЪЕКТОВ:");
        Planet earth2 = new Planet("Земля");
        earth2.addContinent(new Continent("Евразия", 54.76));
        
        Planet mars = new Planet("Марс");
        mars.addContinent(new Continent("Великая Северная равнина", 15.0));
        
        System.out.println("    Сравнение Земли с другой Землей: " + 
                          (earth.equals(earth2) ? "ОБЪЕКТЫ РАВНЫ" : "объекты разные"));
        System.out.println("    Сравнение Земли с Марсом: " + 
                          (earth.equals(mars) ? "объекты равны" : "ОБЪЕКТЫ РАЗНЫЕ"));
        
        System.out.println("\n4. ХЭШ-КОДЫ ОБЪЕКТОВ:");
        System.out.println("    Земля:  " + earth.hashCode());
        System.out.println("    Земля2: " + earth2.hashCode() + 
                         " (совпадает с Землей)");
        System.out.println("    Марс:   " + mars.hashCode() + 
                         " (отличается от Земли)");
        
        // Демонстрация информации о материках
        System.out.println("\n5. ПОДРОБНАЯ ИНФОРМАЦИЯ О МАТЕРИКАХ:");
        for (int i = 0; i < earth.getCount(); i++) {
            System.out.print("   ");
            earth.getContinents()[i].printInfo();
        }
        
        //работа методов get и set
        System.out.println("\n6. РАБОТА С ОТДЕЛЬНЫМ МАТЕРИКОМ:");
        Continent firstContinent = earth.getContinents()[0];
        System.out.println("    Первый материк: " + firstContinent.toString());
        System.out.println("    Площадь Евразии: " + firstContinent.getArea() + " млн кв.км");
        
        // Изменим площадь
        firstContinent.setArea(55.0);
        System.out.println("    Новая площадь Евразии: " + firstContinent.getArea() + " млн кв.км");
        
        System.out.println("\n---------- ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ----------");
    }
}
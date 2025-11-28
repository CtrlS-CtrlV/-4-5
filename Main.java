import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦІЯ ПОЛІМОРФІЗМУ");
        
        // Створення колекції базового типу (List<Beverage>)
        List<Beverage> order = new ArrayList<>();
        
        // Використання фабрики для заповнення колекції
        order.add(BeverageFactory.createBeverage("espresso"));
        order.add(BeverageFactory.createBeverage("latte"));
        order.add(BeverageFactory.createBeverage("tea"));

        double total = 0;
        
        // Поліморфна обробка
        for (Beverage drink : order) {
            drink.printDescription(); // Викл методу абстрактного класу
            drink.prepare();          // Викл методу інтерфейсу
            drink.addCondiments();    // Викл (default або override)
            total += drink.getPrice();
            System.out.println("-------------------");
        }
        System.out.println("Загальна сума: " + total + " грн.\n");

        System.out.println("=== МОДУЛЬНІ ТЕСТИ (Manual) ===");
        runTests();
    }

    public static void runTests() {
        int passed = 0; 
        int failed = 0;

        // Тест 1: Фабрика створює правильний клас (Espresso)
        Beverage b1 = BeverageFactory.createBeverage("espresso");
        if (b1 instanceof Espresso) {
            passed++;
        } else { 
            System.out.println("Test 1 Failed: Factory did not create Espresso"); 
            failed++; 
        }

        // Тест 2: Перевірка ціни (Latte)
        Beverage b2 = BeverageFactory.createBeverage("latte");
        if (b2.getPrice() == 45.0) {
            passed++;
        } else { 
            System.out.println("Test 2 Failed: Wrong price for Latte"); 
            failed++; 
        }

        // Тест 3: Перевірка поліморфізму (instanceof)
        if (b2 instanceof Beverage && b2 instanceof Servable) {
            passed++;
        } else { 
            System.out.println("Test 3 Failed: Inheritance check"); 
            failed++; 
        }

        // Тест 4: (невідомий напій)
        try {
            BeverageFactory.createBeverage("beer");
            System.out.println("Test 4 Failed: Expected Exception was not thrown"); 
            failed++;
        } catch (IllegalArgumentException e) {
            passed++; // Тест пройдено, якщо вилетіла помилка
        }

        // Тест 5: Перевірка імені (Tea)
        Tea tea = new Tea();
        if (tea.getName().equals("Зелений чай")) {
            passed++;
        } else { 
            System.out.println("Test 5 Failed: Wrong name for Tea"); 
            failed++; 
        }

        System.out.println("Tests passed: " + passed + ", Failed: " + failed);
    }
}

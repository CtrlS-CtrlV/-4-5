public class BeverageFactory {
    
    public static Beverage createBeverage(String type) {
        switch (type.toLowerCase()) {
            case "espresso": 
                return new Espresso();
            case "latte": 
                return new Latte();
            case "tea": 
                return new Tea();
            default: 
                throw new IllegalArgumentException("Невідомий тип напою: " + type);
        }
    }
}

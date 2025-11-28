public class Tea extends Beverage {
    
    public Tea() { 
        super("Зелений чай", 25.0); 
    }

    @Override
    public void prepare() {
        System.out.print("Заварювання чайю...");
    }

    @Override
    public void printDescription() {
        System.out.println("[Напій]: " + getName() + ", Ціна: " + getPrice() + " грн.");
    }

    // Перевизначення методу за замовчуванням
    @Override
    public void addCondiments() {
        System.out.println(" -> Додано лимон та мед (Override).");
    }
}

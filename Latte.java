public class Latte extends Beverage {
    
    public Latte() { 
        super("Лате", 45.0); 
    }

    @Override
    public void prepare() {
        System.out.print("Заварювання еспресо та додавання молока...");
    }

    @Override
    public void printDescription() {
        System.out.println("[Напій]: " + getName() + " (з молоком), Ціна: " + getPrice() + " грн.");
    }
}

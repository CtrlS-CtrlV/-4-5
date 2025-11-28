public class Espresso extends Beverage {
    public Espresso() { super("Еспресо", 34.0); }
    @Override
    public void prepare() { System.out.print("Заварювання кави..."); }
    @Override
    public void printDescription() { System.out.println("Espresso: " + getPrice()); }
}

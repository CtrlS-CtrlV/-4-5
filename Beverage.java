public abstract class Beverage implements Servable {
    private String name;
    private double price;

    public Beverage(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public abstract void printDescription();
}

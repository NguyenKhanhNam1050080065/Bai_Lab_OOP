import java.util.Date;

public class HouseTransaction extends Transaction{
    private final String address;
    private final double modifier;
    public HouseTransaction(int id, Date transactionTime, double price, double area, String address, double modifier) {
        super(id, transactionTime, price, area);
        this.address = address;
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public double checkout() {
        return getArea() * getPrice() * modifier;
    }
}

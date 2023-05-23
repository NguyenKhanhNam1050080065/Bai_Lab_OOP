import java.util.Date;

public class RealEstateTransaction extends Transaction {
    @Override
    public double checkout() {
        return getArea() * getPrice() * priceModifier;
    }

    private final double priceModifier;
    public RealEstateTransaction(int id, Date transactionTime, double price, double area, double priceModifier) {
        super(id, transactionTime,  price, area);
        this.priceModifier = priceModifier;
    }
}

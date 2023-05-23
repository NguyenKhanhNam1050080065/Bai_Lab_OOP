import java.util.Date;

public class BClassRealEstateTransaction extends RealEstateTransaction {
    public BClassRealEstateTransaction(int id, Date transactionTime, double price, double area) {
        super(id, transactionTime, price, area, 1.0);
    }

}

import java.util.Date;

public class CClassRealEstateTransaction extends RealEstateTransaction {
    public CClassRealEstateTransaction(int id, Date transactionTime, double price, double area) {
        super(id, transactionTime, price, area, 1.0);
    }
}

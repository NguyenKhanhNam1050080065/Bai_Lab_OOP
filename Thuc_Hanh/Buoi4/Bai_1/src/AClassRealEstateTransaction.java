import java.util.Date;

public class AClassRealEstateTransaction extends RealEstateTransaction{
    public AClassRealEstateTransaction(int id, Date transactionTime, double price, double area) {
        super(id, transactionTime, price, area, 1.5);
    }
}

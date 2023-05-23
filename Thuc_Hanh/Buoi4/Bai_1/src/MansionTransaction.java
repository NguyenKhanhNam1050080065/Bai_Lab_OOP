import java.util.Date;

public class MansionTransaction extends HouseTransaction{
    public MansionTransaction(int id, Date transactionTime, double price, double area, String address) {
        super(id, transactionTime, price, area, address, 1.0);
    }
}

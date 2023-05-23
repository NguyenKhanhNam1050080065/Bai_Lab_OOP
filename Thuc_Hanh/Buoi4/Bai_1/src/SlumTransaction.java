import java.util.Date;

public class SlumTransaction extends HouseTransaction{
    public SlumTransaction(int id, Date transactionTime, double price, double area, String address) {
        super(id, transactionTime, price, area, address, 0.9);
    }
}

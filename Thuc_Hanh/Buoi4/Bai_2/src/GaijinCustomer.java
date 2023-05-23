import query_maker.QueryField;

import java.util.Date;
import java.util.List;

public class GaijinCustomer extends Customer{
    private final String nationality;
    public GaijinCustomer(int id, String name, Date transactionTime, double amount, double price, String nationality) {
        super(id, name, transactionTime, amount, price);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public List<QueryField> queryPrivate(){
        List<QueryField> re = super.queryPrivate();
        re.set(5, new QueryField(nationality, nationality.length()));
        return re;
    }

    @Override
    public double checkout() {
        return getAmount() * getPrice();
    }
}

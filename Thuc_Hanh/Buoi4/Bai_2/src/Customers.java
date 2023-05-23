import query_maker.QueryMaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customers {
    private final List<Customer> Customers = new ArrayList<>();
    private final QueryMaker maker = new QueryMaker().addFieldName("ID").addFieldName("Name").addFieldName("Time").addFieldName("Amount").addFieldName("Price").addFieldName("Note").addFieldName("Checkout total");
    public Customers add(Customer t){
        Customers.add(t);
        maker.addRow(t);
        return this;
    }
    public double checkoutAvg(){
        double re = 0;
        int count = Customers.size();
        for (Customer t : Customers){
            re += t.checkout();
        }
        return count == 0 ? 0.0 : re / count;
    }
    @Override
    public String toString(){
        return maker.toString();
    }
    public Customers queryByDate(Date from, Date to){
        Customers re = new Customers();
        long unixFrom = from.getTime();
        long unixTo = to.getTime();
        for (Customer t : Customers){
            long unixTime = t.getTransactionTime().getTime();
            if (unixTime >= unixFrom && unixTime < unixTo) re.add(t);
        }
        return re;
    }
}

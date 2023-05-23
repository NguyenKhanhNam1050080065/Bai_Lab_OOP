import query_maker.QueryMaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transactions {
    private final List<Transaction> transactions = new ArrayList<>();
    private final QueryMaker maker = new QueryMaker().addFieldName("ID").addFieldName("Time").addFieldName("Price").addFieldName("Area total").addFieldName("Checkout total");
    public Transactions add(Transaction t){
        transactions.add(t);
        maker.addRow(t);
        return this;
    }
    public double checkoutAvg(){
        double re = 0;
        int count = transactions.size();
        for (Transaction t : transactions){
            re += t.checkout();
        }
        return count == 0 ? 0.0 : re / count;
    }
    @Override
    public String toString(){
        return maker.toString();
    }
    public Transactions queryByDate(Date from, Date to){
        Transactions re = new Transactions();
        long unixFrom = from.getTime();
        long unixTo = to.getTime();
        for (Transaction t : transactions){
            long unixTime = t.getTransactionTime().getTime();
            if (unixTime >= unixFrom && unixTime < unixTo) re.add(t);
        }
        return re;
    }
}

import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Customer extends Queryable {
    private final int id;
    private final String name;
    private final Date transactionTime;
    private final double amount;
    private final double price;
    public Customer(int id, String name, Date transactionTime, double amount, double price){
        this.id = id;
        this.name = name;
        this.transactionTime = transactionTime;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public List<QueryField> queryPrivate(){
        lastQuery = null;
        List<QueryField> re = new ArrayList<>();
        String dateFormatted = new SimpleDateFormat("dd/MM/yyy").format(transactionTime);
        String amountFormatted = new DecimalFormat("###,###.00").format(amount) + " kWH";
        String priceFormatted = new DecimalFormat("###,###.00").format(price);
        String checkoutFormatted = new DecimalFormat("###,###.00").format(checkout());
        re.add(new QueryField(id, 5));
        re.add(new QueryField(name, name.length()));
        re.add(new QueryField(dateFormatted, dateFormatted.length()));
        re.add(new QueryField(amountFormatted, amountFormatted.length()));
        re.add(new QueryField(priceFormatted, priceFormatted.length()));
        re.add(new QueryField("", 0));
        re.add(new QueryField(checkoutFormatted, checkoutFormatted.length()));
        return re;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double checkout();
}

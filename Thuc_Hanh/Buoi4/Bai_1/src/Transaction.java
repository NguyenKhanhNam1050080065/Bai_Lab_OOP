import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Transaction extends Queryable {
    private final int id;
    private final Date transactionTime;
    private final double price;
    private final double area;
    public Transaction(int id, Date transactionTime, double price, double area){
        this.id = id;
        this.transactionTime = transactionTime;
        this.price = price;
        this.area = area;
    }

    @Override
    public List<QueryField> queryPrivate(){
        lastQuery = null;
        ArrayList<QueryField> re = new ArrayList<>();
        String timeFormatted = new SimpleDateFormat("dd/MM/yyy").format(transactionTime);
        String priceFormatted = new DecimalFormat("###,###.00").format(price);
        String areaFormatted = new DecimalFormat("###,###.00").format(area);
        String checkoutFormatted = new DecimalFormat("###,###.00").format(checkout());
        re.add(new QueryField(id, 5));
        re.add(new QueryField(timeFormatted, timeFormatted.length()));
        re.add(new QueryField(priceFormatted, priceFormatted.length()));
        re.add(new QueryField(areaFormatted, areaFormatted.length()));
        re.add(new QueryField(checkoutFormatted, checkoutFormatted.length()));
        return re;
    }

    public int getId() {
        return id;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }
    public abstract double checkout();
}

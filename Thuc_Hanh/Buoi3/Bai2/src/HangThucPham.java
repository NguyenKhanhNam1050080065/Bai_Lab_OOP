import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class HangThucPham extends HangHoa {
    private Date prod = new GregorianCalendar().getTime();
    private Date exp = new GregorianCalendar().getTime();

    public HangThucPham(int id) {
        super(id);
    }

    public HangThucPham(int id, String name, double price, Date prod, Date exp) {
        super(id, name, price);
        this.prod = prod;
        this.exp = exp;
    }

    @Override
    public String toString(){
        return "";
    }
    @Override
    public String evaluate(){
        return getCount() > 0 && (exp.before(new GregorianCalendar().getTime())) ? "Khó bán" : "Bán được";
    }
    public Date getExp() {
        return exp;
    }

    public Date getProd() {
        return prod;
    }

    public void setExp(Date exp) {
        long currentUnixTime = new GregorianCalendar().getTime().getTime();
        // Cong them 1 ngay (86400 * 1000 mili giay);
        if (exp.getTime() >= prod.getTime())
            this.exp = exp;
        else throw new RuntimeException("Faulty date");
    }



    public void setProd(Date prod) {
        long currentUnixTime = new GregorianCalendar().getTime().getTime();
        // Tru di 1 ngay (86400 * 1000 mili giay);
        if (exp.getTime() >= prod.getTime() && prod.getTime() < currentUnixTime - (86400 * 1000))
            this.prod = prod;
        else throw new RuntimeException("Faulty date");
    }
    public static String format(GregorianCalendar calendar) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }
//    @Override
//    public List<QueryField> queryPrivate() {
//        long currentUnixTime = new GregorianCalendar().getTime().getTime();
//        String prodFormatted = new SimpleDateFormat("dd/MM/yyy").format(prod);
//        String expFormatted  = new SimpleDateFormat("dd/MM/yyy").format(exp);
//        String priceFormatted = new DecimalFormat("###,###.00").format(getPrice()) + "VND";
//        lastQuery = new ArrayList<>();
//        lastQuery.add(new QueryField(getId(), 6));
//        lastQuery.add(new QueryField(getName(), getName().length()));
//        lastQuery.add(new QueryField(priceFormatted, priceFormatted.length()));
//        lastQuery.add(new QueryField(prodFormatted, prodFormatted.length()));
//        lastQuery.add(new QueryField(expFormatted, expFormatted.length()));
//        lastQuery.add(new QueryField(exp.getTime() < currentUnixTime ? "Hàng hết hạn" : "", 12));
//        return lastQuery;
//    }
}

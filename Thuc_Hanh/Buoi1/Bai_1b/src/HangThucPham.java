import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class HangThucPham extends Queryable {
    private final int id;
    private String name = "xxx";
    private double price;
    private Date prod = new GregorianCalendar().getTime();
    private Date exp = new GregorianCalendar().getTime();
    public HangThucPham(int id){
        this.id = id;
    }
    public HangThucPham(int id, String name, double price, Date prod, Date exp){
        this.id = id;
        setName(name);
        setPrice(price);
        // Dam bao ngay nhap dung
        this.prod = prod;
        this.exp = exp;
//        setProd(prod);
//        setExp(exp);
    }
    @Override
    public String toString(){
        return "HangThucPham(id=%d, name=%s, price=%f, prod=%s, exp=%s)"
                .formatted(id, name, price, prod, exp);
    }

    public Date getExp() {
        return exp;
    }

    public Date getProd() {
        return prod;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setExp(Date exp) {
        long currentUnixTime = new GregorianCalendar().getTime().getTime();
        // Cong them 1 ngay (86400 * 1000 mili giay);
        if (exp.getTime() >= prod.getTime())
            this.exp = exp;
        else throw new RuntimeException("Faulty date");
    }

    public void setName(String name) {
        if (name.isBlank()) throw new RuntimeException("Name is Blank");
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = Math.max(0, price);
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
    @Override
    public List<QueryField> queryPrivate() {
        long currentUnixTime = new GregorianCalendar().getTime().getTime();
        String prodFormatted = new SimpleDateFormat("dd/MM/yyy").format(prod);
        String expFormatted  = new SimpleDateFormat("dd/MM/yyy").format(exp);
        String priceFormatted = new DecimalFormat("###,###.00").format(price) + "VND";
        lastQuery = new ArrayList<>();
        lastQuery.add(new QueryField(id, 6));
        lastQuery.add(new QueryField(name, name.length()));
        lastQuery.add(new QueryField(priceFormatted, priceFormatted.length()));
        lastQuery.add(new QueryField(prodFormatted, prodFormatted.length()));
        lastQuery.add(new QueryField(expFormatted, expFormatted.length()));
        lastQuery.add(new QueryField(exp.getTime() < currentUnixTime ? "Hàng hết hạn" : "", 12));
        return lastQuery;
    }
}

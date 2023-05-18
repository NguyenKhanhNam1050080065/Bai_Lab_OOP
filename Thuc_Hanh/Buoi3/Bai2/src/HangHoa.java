import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class HangHoa extends Queryable {
    private final int id;
    private String name = "xxx";
    private double price;
    private int count;
    @Override
    public List<QueryField> queryPrivate() {
        lastQuery = new ArrayList<>();
        String priceFormatted = new DecimalFormat("#,### ").format(price) + "VND";
        lastQuery.add(new QueryField(id, 5));
        lastQuery.add(new QueryField(name, name.length()));
        lastQuery.add(new QueryField(priceFormatted, priceFormatted.length()));
        lastQuery.add(new QueryField(count, 5));
        lastQuery.add(new QueryField(evaluate(), evaluate().length()));
        return lastQuery;
    }
    public HangHoa(int id){
        this.id = id;
    }
    public HangHoa(int id, String name, double price){
        this.id = id;
        setName(name);
        setPrice(price);
    }
    public void setName(String name) {
        if (name.isBlank()) throw new RuntimeException("Name is Blank");
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = Math.max(0.01, price);
    }

    public void setCount(int count) {
        this.count = Math.max(0, count);;
    }
    public abstract String evaluate();
    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

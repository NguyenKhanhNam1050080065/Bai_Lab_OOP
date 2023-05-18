import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderDetail extends Queryable {
    private final int quantity;
    private final Product product;
    private int id;

    public int getId() {
        return id;
    }

    public OrderDetail setId(int id) {
        this.id = id; return this;
    }

    public OrderDetail(int q, Product p){
        quantity = q;
        product = p;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString(){
        return "OrderDetail(quantity=%d, product=%s)".formatted(quantity, product);
    }
    public double calcTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public List<QueryField> queryPrivate() {
        lastQuery = new ArrayList<>();
        String priceFormatted = new DecimalFormat("#,###").format(product.getPrice());
        String totalFormatted = new DecimalFormat("#,### ").format(calcTotalPrice()) + "VND";
        lastQuery.add(new QueryField(id, 3));
        lastQuery.add(new QueryField(product.getProductId(), product.getProductId().length() + 1));
        lastQuery.add(new QueryField(product.getDescription(), product.getDescription().length() + 1));
        lastQuery.add(new QueryField(priceFormatted, priceFormatted.length()));
        lastQuery.add(new QueryField(quantity, 5));
        lastQuery.add(new QueryField(totalFormatted, totalFormatted.length()));
        return lastQuery;
    }
}

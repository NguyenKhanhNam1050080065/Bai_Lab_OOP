import query_maker.QueryField;
import query_maker.Queryable;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productId;
    private String description;
    private double price;
    @Override
    public String toString(){
        return "Product(productId=%s, description=%s, price=%f)".formatted(productId, description, price);
    }
    public Product(){
        this("", "", 0.0);
    }
    public Product(String id, String des, double cost){
        description = des;
        productId = id;
        price = cost;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    @Override
//    public List<QueryField> queryPrivate() {
//        List<QueryField> re = new ArrayList<>();
//
//        return re;
//    }
}

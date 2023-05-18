import query_maker.QueryField;
import query_maker.QueryMaker;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Order {
    private final int orderId;
    private final QueryMaker maker = new QueryMaker();
    private LocalDate orderDate;
    private final List<OrderDetail> lineItems;
    public Order(int orderId, LocalDate orderDate){
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.lineItems = new ArrayList<>();
        maker.addFieldName("STT").addFieldName("Mã SP").addFieldName("Mô tả").addFieldName("Đơn giá").addFieldName("S. Lượng").addFieldName("Thành tiền");
    }
    @Override
    public String toString(){
        return "Mã HD: " + orderId + "\nNgày lập hóa đơn: " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(orderDate) + "\n" +
                maker + "\nTổng tiền thanh toán: " + new DecimalFormat("#,### ").format(calcTotalCharge()) + "VND";
    }
    public Order addLineItem(Product p, int count){
        OrderDetail newItem = new OrderDetail(count, p).setId(lineItems.size() + 1);
        lineItems.add(newItem);
        maker.addRow(newItem);
        return this;
    }
    public double calcTotalCharge(){
        double re = 0.0;
        for (OrderDetail d : lineItems){
            re += d.calcTotalPrice();
        }
        return re;
    }
    public int getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<OrderDetail> getLineItems() {
        return lineItems;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}

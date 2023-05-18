import query_maker.QueryField;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HangDien extends HangHoa {
    private int warranty;
    private double capacity;
    public HangDien(int id) {
        super(id);
    }

    public HangDien(int id, String name, double price) {
        super(id, name, price);
    }
    @Override
    public String evaluate(){
        return getCount() < 3 ? "Bán được" : "Khó bán";
    }

    public double getCapacity() {
        return capacity;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setCapacity(double capacity) {
        this.capacity = Math.max(0.0, capacity);
    }

    public void setWarranty(int warranty) {
        this.warranty = Math.max(0, warranty);
    }
}

import query_maker.QueryField;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class HangSanhSu extends HangHoa {
    private static final int DATE_LIMIT = 10;
    private String manufacturer = "";
    private Date inputDate = new GregorianCalendar().getTime();
    public HangSanhSu(int id) {
        super(id);
    }
    @Override
    public String evaluate(){
        return getCount() > 50 && (new GregorianCalendar().getTime().getTime() - inputDate.getTime() > DATE_LIMIT * 86400L) ? "Khó bán" : "Bán được";
    }
    public HangSanhSu(int id, String name, double price) {
        super(id, name, price);
    }

    public Date getInputDate() {
        return inputDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

import query_maker.QueryField;

import java.util.Date;
import java.util.List;

public class VietnameseCustomer extends Customer{
    public enum UsageType {
        HOME,
        BUSINESS,
        PRODUCTION;
        public static String stringify(UsageType type){
            switch (type){
                case HOME -> {
                    return "Sinh hoạt";
                }
                case BUSINESS -> {
                    return "Kinh doanh";
                }
                case PRODUCTION -> {
                    return "Sản xuất";
                }
                default -> {
                    return "";
                }
            }
        }
    }
    private final UsageType type;
    private final double threshold;
    public VietnameseCustomer(int id, String name, Date transactionTime, double amount, double price, UsageType type, double threshold) {
        super(id, name, transactionTime, amount, price);
        this.type = type;
        this.threshold = threshold;
    }

    public double getThreshold() {
        return threshold;
    }

    public UsageType getType() {
        return type;
    }
    @Override
    public List<QueryField> queryPrivate(){
        List<QueryField> re = super.queryPrivate();
        String formatted = UsageType.stringify(type);
        re.set(5, new QueryField(formatted, formatted.length()));
        return re;
    }
    @Override
    public double checkout() {
        return getAmount() * getPrice() + (Math.max(0.0, getAmount() - getThreshold()) * getPrice() * 2.5);
    }
}

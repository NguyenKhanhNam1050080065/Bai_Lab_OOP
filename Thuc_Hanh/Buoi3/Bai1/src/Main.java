import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Order o = new Order(1, new GregorianCalendar().toZonedDateTime().toLocalDate());
        o.addLineItem(new Product("1", "Gạo", 13_000), 12)
                .addLineItem(new Product("2", "Bánh mì", 13_000), 34)
                .addLineItem(new Product("3", "Phở", 13_000), 45)
                .addLineItem(new Product("4", "Thuốc lắc", 13_000_000), 3)
                .addLineItem(new Product("6", "Thịt heo", 36_000), 19);
        System.out.println(o);
    }
}
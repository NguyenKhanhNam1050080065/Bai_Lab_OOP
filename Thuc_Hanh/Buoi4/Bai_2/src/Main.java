import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Customers customers = new Customers();
        customers
                .add(new VietnameseCustomer(0, "Nguyen Van A", new GregorianCalendar(2018, GregorianCalendar.JULY, 10).getTime(), 30, 3_500, VietnameseCustomer.UsageType.HOME, 50))
                .add(new VietnameseCustomer(1, "Nguyen Van B", new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 1).getTime(), 120, 3_500, VietnameseCustomer.UsageType.BUSINESS, 100))
                .add(new GaijinCustomer(2, "Martin Luther King Jr.", new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 10).getTime(), 30, 3_500, "USA"));
        System.out.println("Unfiltered:");
        System.out.println(customers);
        System.out.println("In September 2013:");
        System.out.println(customers.queryByDate(new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 30).getTime()));
        System.out.printf("Average: %f%n", customers.checkoutAvg());
    }
}
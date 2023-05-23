import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Transactions transactions = new Transactions();
        transactions
                .add(new AClassRealEstateTransaction(0, new GregorianCalendar(2018, GregorianCalendar.JULY, 10).getTime(), 13_000_000.0, 360))
                .add(new BClassRealEstateTransaction(1, new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 10).getTime(), 3_500_000.0, 160))
                .add(new BClassRealEstateTransaction(2, new GregorianCalendar(2014, GregorianCalendar.SEPTEMBER, 10).getTime(), 3_500_000.0, 160))
                .add(new MansionTransaction(3, new GregorianCalendar(2017, GregorianCalendar.OCTOBER, 10).getTime(), 63_500_000.0, 560, "308 Negra Arroyo Lane, Albuquerque, New Mexico"))
                .add(new MansionTransaction(4, new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 29).getTime(), 3_000_000.0, 120, "308 Negra Arroyo Lane, Albuquerque, New Mexico"));
        System.out.println("Unfiltered:");
        System.out.println(transactions);
        System.out.println("In September 2013:");
        System.out.println(transactions.queryByDate(new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2013, GregorianCalendar.SEPTEMBER, 30).getTime()));
        System.out.printf("Average: %f%n", transactions.checkoutAvg());
    }
}
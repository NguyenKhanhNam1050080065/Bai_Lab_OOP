import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> tickets0 = new HashMap<>();
        tickets0.put("GA010", 2);
        tickets0.put("GA011", 0);
        tickets0.put("GA012", 3);
        Map<String, Double> tickets1 = new HashMap<>();
        tickets1.put("GA010", 20_000.0);
        tickets1.put("GA011", 32_000.0);
        tickets1.put("GA012", 17_323_000.0);
        CustomerQueue queue = new CustomerQueue(tickets0, tickets1);
        queue.addCustomer();
        System.out.println();
        queue.addCustomer();
        System.out.println();
        queue.addCustomer();
        System.out.println();
        System.out.printf("Customer list: %n%s", queue.customerList());
        while (queue.count() > 0){
            if (!queue.sellTicket()) System.out.println("Ran out of this ticket for this station!");
            else System.out.println("Success!");
        }
        System.out.printf("Opening stations: %n%s", queue.openingStations());
        System.out.printf("Statistic: %n%s", queue.statistic());
    }
}
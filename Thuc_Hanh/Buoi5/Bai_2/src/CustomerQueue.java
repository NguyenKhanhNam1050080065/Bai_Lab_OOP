import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerQueue {
    private final LinkedList<Customer> customers = new LinkedList<>();
    private final AtomicInteger customerCount = new AtomicInteger(0);
    private double totalProfit = 0.0;
    private final Map<String, Integer> ticketCount;
    private final Map<String, Double> ticketFee;

    public CustomerQueue(Map<String, Integer> tc, Map<String, Double> tf){
        ticketCount = new HashMap<>(tc);
        ticketFee = new HashMap<>(tf);
    }
    public void addCustomer(){
        Scanner scan = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scan.nextLine();
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Destination: ");
        String dest = scan.nextLine();
        if (!ticketFee.containsKey(dest)) {
            System.out.println("Destination not exist!");
            return;
        }
        synchronized (this){
            customers.add(new Customer(id, name, dest, ticketFee.get(dest)));
        }
    }
    public boolean sellTicket(){
        synchronized (this){
            if (customers.size() == 0) return false;
            Customer curr = customers.getFirst();
            customers.removeFirst();
            System.out.println("Resolving: " + curr.id());
            if (!ticketCount.containsKey(curr.toStation()) || ticketCount.get(curr.toStation()) <= 0) return false;
            ticketCount.put(curr.toStation(), ticketCount.get(curr.toStation()) - 1);
            totalProfit += ticketFee.get(curr.toStation());
            customerCount.incrementAndGet();
            return true;
        }
    }
    public boolean cancelCustomer(String id){
        synchronized (this){
            Iterator<Customer> iter = customers.iterator();
            while (iter.hasNext()){
                if (Objects.equals(iter.next().id(), id)) {
                    iter.remove(); return true;
                }
            }
            return false;
        }
    }
    public int count() { return customers.size(); }
    public String statistic(){
        return "Total customers: %d\nTotal profit: %s\n".formatted(customerCount.get(), new DecimalFormat("###,###.0").format(totalProfit));
    }
    public String openingStations() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> E : ticketCount.entrySet()){
            if (E.getValue() <= 0) continue;
            builder.append("Station %s: %d".formatted(E.getKey(), E.getValue())).append("\n");
        }
        return builder.toString();
    }
    public String customerList(){
        StringBuilder builder = new StringBuilder();
        for (Customer c : customers){
            builder.append("Customer(id%s, name=%s, destination=%s, fee=%s)".formatted(c.id(), c.name(), c.toStation(), new DecimalFormat("###,###.00").format(c.fee()))).append("\n");
        }
        return builder.toString();
    }
}

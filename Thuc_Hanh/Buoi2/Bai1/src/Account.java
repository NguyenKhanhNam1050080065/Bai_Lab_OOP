import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    public static final double INTEREST = 0.035;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final long id;
    private String name;
    private double balance;
    private String state;
    public Account(long id, String name, double amount){
        this.id = id;
        this.name = name;
        this.balance = amount;
        state = "";
    }
    public Account(long id){
        this(id, "chưa xác định", 50.0);
    }
    public Account(){
        this(999999, "chưa xác định", 50.0);
    }
    public static Account createAccount(String name, long amount){
        return new Account(counter.incrementAndGet(), name, amount);
    }
    public static Account consoleCreate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id: ");
        Account re = new Account(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Name: ");
        re.setName(scanner.nextLine());
        System.out.print("Balance: ");
        re.setBalance(scanner.nextDouble());
        return re;
    }
    public static boolean transact(final Account sender, final Account recipient, final double amount){
        synchronized (sender){
            synchronized (recipient){
                if (sender.getBalance() - 50 < amount) return false;
                return sender.withdraw(amount) && recipient.charge(amount);
            }
        }
    }

    public void setName(String name) {
        this.name = !name.isEmpty() ? name : new L<String>().log("Giá trị không hơợp lệ", "chưa xác định");
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setBalance(double amount) {
        synchronized (this){
            this.balance = amount > 50.0 ? amount : new L<Double>().log("Giá trị không hợp lệ", 50.0);
        }
    }

    public void setState(String state) {
        this.state = state;
    }
    public boolean withdraw(double amount){
        synchronized (this){
            if (amount > this.balance - 50 || amount < 0) return false;
            this.balance -= amount; return true;
        }
    }
    public boolean charge(double amount){
        if (amount < 0) return false;
        synchronized (this){
            this.balance += amount; return true;
        }
    }
    public void interestReturn(){
        charge(getBalance() * INTEREST);
    }
    @Override
    public String toString(){
        return "Account(id=%d, name=%s, amount=%s, state=%s)".formatted(id, name, NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN")).format(balance), state);
    }
}

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CD {
    private final long id;
    private String name;
    private int count;
    private double price;
    private ChangeEvent<Integer> countAction = null;
    private ChangeEvent<Double> priceAction = null;

    public CD(long id){
        this(id, "", 0, 0);
    }
    public CD(long id, String name, int count, double price){
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }
    public static CD input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Id = ");
        CD cd = new CD(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Name = ");
        cd.setName(scanner.nextLine());
        System.out.print("Count = ");
        cd.setCount(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Price = ");
        cd.setPrice(scanner.nextDouble());
        return cd;
    }
    public CD onCountChange(ChangeEvent<Integer> task){
        countAction = task;
        return this;
    }
    public CD onPriceChange(ChangeEvent<Double> task){
        priceAction = task;
        return this;
    }
    @Override
    public String toString(){
        return "CD(id=%d, name=%s, count=%d, price=%s)".formatted(id, name, count, NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN")).format(price));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (priceAction != null) priceAction.event(this.price, price);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (countAction != null) countAction.event(this.count, count);
        this.count = count;
    }
}

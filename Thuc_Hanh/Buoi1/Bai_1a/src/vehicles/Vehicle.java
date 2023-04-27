package vehicles;

import query_maker.QueryField;
import query_maker.Queryable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle extends Queryable {
    private final String owner;
    private final String type;
    private final int capacity;
    private final double value;
    private final double tax;
    public Vehicle(String owner, String type, int capacity, double value){
        this.owner = owner;
        this.type = type;
        this.capacity = capacity;
        this.value = value;
        this.tax = capacity < 100 ? 0.01 * value : capacity > 200 ? 0.05 * value : 0.03 * value;
    }
    @Override
    public List<QueryField> queryPrivate() {
        lastQuery = new ArrayList<>();
        String valFormatted = String.format("%.2f", value);
        String taxFormatted = String.format("%.2f", tax);
        lastQuery.add(new QueryField(owner, owner.length()));
        lastQuery.add(new QueryField(type, type.length()));
        lastQuery.add(new QueryField(capacity, String.valueOf(capacity).length()));
        lastQuery.add(new QueryField(valFormatted, valFormatted.length()));
        lastQuery.add(new QueryField(taxFormatted, taxFormatted.length()));
        return lastQuery;
    }
    public static Vehicle input(){
        Scanner scan = new Scanner(System.in);
        String o, t;
        int c;
        double v;
        System.out.print("Ten chu xe: ");
        o = scan.nextLine();
        System.out.print("Loai xe: ");
        t = scan.nextLine();
        System.out.print("Dung tich: ");
        c = scan.nextInt();
        System.out.print("Tri gia: ");
        v = scan.nextDouble();
        return new Vehicle(o, t, c, v);

    }
}

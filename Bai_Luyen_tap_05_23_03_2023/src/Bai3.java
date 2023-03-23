import java.util.ArrayList;
import java.util.List;

class Transaction {
    private final double rate;
    public Transaction(double rate){
        this.rate = rate;
    }
    public double getAmount(){
        return 0.0;
    }
    public Transaction setBill(double b){
        return this;
    }
    public double getBill(){
        return 1.0;
    }
    public double getRate() {
        return rate;
    }

    public double convert(double amount){
        return rate * amount;
    }
    public double convertDefault(){
        return convert(getAmount());
    }
    @Override
    public String toString(){
        return "%f".formatted(convertDefault());
    }
}

class GoldTransaction extends Transaction {

    private final double amount;

    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public double getBill() {
        return getRate();
    }

    public GoldTransaction(double amount) {
        super(62634);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "GoldTransaction(%s)".formatted(super.toString());
    }
}
class VNDtoEuro extends Transaction {
    private final double amount;

    @Override
    public double getAmount() {
        return amount;
    }
    public VNDtoEuro(double amount){
        super(0.000039);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "VNDtoEuro(%s)".formatted(super.toString());
    }
}
class EuroToVND extends Transaction {
    private final double amount;
    private double bill = 1.0;

    @Override
    public Transaction setBill(double bill) {
        this.bill = bill;
        return this;
    }
    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public double getBill() {
        return bill;
    }
    @Override
    public double convert(double amount){
        return getRate() * getBill() * amount;
    }

    public EuroToVND(double amount) {
        super(25562.20);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "EuroToVND(%s)".formatted(super.toString());
    }
}
class EuroToUSD extends Transaction {
    private final double amount;
    private double bill = 1.0;

    @Override
    public Transaction setBill(double bill) {
        this.bill = bill;
        return this;
    }
    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public double getBill() {
        return bill;
    }
    @Override
    public double convert(double amount){
        return getRate() * getBill() * amount;
    }

    public EuroToUSD(double amount) {
        super(1.08);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "EuroToUSD(%s)".formatted(super.toString());
    }
}
class USDtoVND extends Transaction {
    private final double amount;
    private double bill = 1.0;

    @Override
    public Transaction setBill(double bill) {
        this.bill = bill;
        return this;
    }
    @Override
    public double getAmount() {
        return amount;
    }
    @Override
    public double getBill() {
        return bill;
    }
    @Override
    public double convert(double amount){
        return getRate() * getBill() * amount;
    }
    public USDtoVND(double amount) {
        super(23733.90);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "USDToVND(%s)".formatted(super.toString());
    }
}
class VNDtoUSD extends Transaction {
    private final double amount;

    @Override
    public double getAmount() {
        return amount;
    }
    public VNDtoUSD(double amount) {
        super(0.0000421);
        this.amount = amount;
    }
    @Override
    public String toString(){
        return "VNDtoUSD(%s)".formatted(super.toString());
    }
}

class TransactionCenter {
    private final List<Transaction> transactionList = new ArrayList<>();
    public TransactionCenter(){

    }
    public TransactionCenter addTransaction(Transaction t){
        synchronized (this){
            transactionList.add(t);
        }
        return this;
    }
    public double toUSD(Transaction t){
        if (t.getClass() == GoldTransaction.class){
            return t.convertDefault();
        } else if (t.getClass() == EuroToVND.class){
            return new EuroToUSD(t.getAmount()).setBill(t.getBill()).convertDefault();
        } else if (t.getClass() == EuroToUSD.class) {
            return t.convertDefault();
        } else if (t.getClass() == VNDtoEuro.class) {
            return new VNDtoUSD(t.getAmount()).setBill(t.getBill()).convertDefault();
        } else if (t.getClass() == USDtoVND.class) {
            return t.getAmount() * t.getBill();
        } else if (t.getClass() == VNDtoUSD.class) {
            return t.convertDefault();
        }
        return 0.0;
    }
    public double totalUSD(){
        synchronized (this){
            double total = 0.0;
            for (Transaction t : transactionList){
                total += toUSD(t);
            }
            return total;
        }
    }
    public double totalAmount(){
        synchronized (this){
            double total = 0.0;
            for (Transaction t : transactionList){
                total += t.getAmount();
            }
            return total;
        }
    }
    public List<Transaction> getTransactionsUSD(double threshold){
        List<Transaction> re = new ArrayList<>();
        synchronized (this){
            for (Transaction t : transactionList){
                if (toUSD(t) > threshold) re.add(t);
            }
        }
        return re;
    }
    public List<Transaction> getTransactionsVND(double threshold){
        return getTransactionsUSD(new VNDtoUSD(threshold).convertDefault());
    }
    public String getTransactionsStringUSD(double threshold){
        List<Transaction> trans = getTransactionsUSD(threshold);
        StringBuilder re = new StringBuilder();
        for (Transaction t : trans){
            re.append(t.toString()).append(", ");
        }
        return re.toString();
    }
    public String getTransactionsStringVND(double threshold){
        return getTransactionsStringUSD(new VNDtoUSD(threshold).convertDefault());
    }
    public double averageUSD(){
        synchronized (this){
            int count = transactionList.size();
            if (count == 0) return 0.0;
            return totalUSD() / count;
        }
    }
    public double averageVND(){
        return new USDtoVND(averageUSD()).setBill(1.0).convertDefault();
    }
    @Override
    public String toString(){
        final StringBuilder re = new StringBuilder();
        synchronized (this){
            for (Transaction t : transactionList){
                re.append(t.toString()).append(", ");
            }
        }
        return re.toString();
    }
}

public class Bai3 {
    public static void l(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        Transaction gt = new GoldTransaction(10.0);
        Transaction ve = new VNDtoEuro(200_000.0);
        Transaction ev = new EuroToVND(10.0);
        TransactionCenter tc = new TransactionCenter();
        tc.addTransaction(gt).addTransaction(ve).addTransaction(ev);
        l(tc.toString());
        l(String.valueOf(tc.averageUSD()));
        l(tc.getTransactionsStringVND(1_000_000_000));
    }
}

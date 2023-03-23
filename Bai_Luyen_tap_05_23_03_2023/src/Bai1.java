class Ride {
    private final int id;
    private final String licensePlate;
    private String driverName = "";
    private double revenue;

    public Ride(int id, String licensePlate){
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    public String type(){
        return "undefined";
    }
}

class InnerCityRide extends Ride {
    private int tripCount;
    private double kilometerCount;

    public InnerCityRide(int id, String licensePlate){
        super(id, licensePlate);
    }

    public double getKilometerCount() {
        return kilometerCount;
    }
    public int getTripCount() {
        return tripCount;
    }
    public void setKilometerCount(double kilometerCount) {
        this.kilometerCount = kilometerCount;
    }
    public void setTripCount(int tripCount) {
        this.tripCount = tripCount;
    }

    @Override
    public String type(){
        return "inner_city";
    }
}

class InterStatesRide extends Ride {
    private String destination = "";
    private int dayCount;

    public InterStatesRide(int id, String licensePlate){
        super(id, licensePlate);
    }

    public int getDayCount() {
        return dayCount;
    }
    public String getDestination() {
        return destination;
    }
    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String type(){
        return "inter_states";
    }
}

public class Bai1 {
    public static void l(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        InnerCityRide r1 = new InnerCityRide(0, "10500");
        InterStatesRide r2 = new InterStatesRide(1, "80065");
        r1.setRevenue(120_000);
        r2.setRevenue(200_000);
        l("Loi nhuan chuyen xe noi thanh: %f".formatted(r1.getRevenue()));
        l("Loi nhuan chuyen xe ngoai thanh: %f".formatted(r2.getRevenue()));
        l("Loi nhuan chuyen ca 2 chuyen xe: %f".formatted(r1.getRevenue() + r2.getRevenue()));
    }
}

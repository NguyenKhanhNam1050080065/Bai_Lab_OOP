import query_maker.QueryMaker;
import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {
        QueryMaker maker = new QueryMaker();
        maker.masterSpacing = 5;

        maker.addFieldName("Tên chủ xe").addFieldName("Loại xe").addFieldName("Dung tích").addFieldName("Trị giá").addFieldName("Thuế phải nộp")
//                        .addRow(new Vehicle("Nguyen Thu Loan", "Future Neo", 100, 35_000_000.0))
//                        .addRow(new Vehicle("Le Minh Tinh", "Ford Ranger", 3000, 250_000_000.0))
//                        .addRow(new Vehicle("Nguyen Minh Triet", "Landscape", 1500, 1_000_000_000.0));
                      .addRow(Vehicle.input())
                      .addRow(Vehicle.input())
                      .addRow(Vehicle.input());
        System.out.println(maker);
    }
}
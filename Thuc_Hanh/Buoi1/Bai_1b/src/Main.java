import query_maker.QueryMaker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QueryMaker maker = new QueryMaker();
        maker.masterSpacing = 5;
        maker.addFieldName("Mã_Hàng").addFieldName("Tên_Hàng").addFieldName("Đơn_Giá").addFieldName("Ngày_Sản_Xuất").addFieldName("Ngày_Hết_Hạng").addFieldName("Ghi_Chú")
                        .addRow(new HangThucPham(1, "Gao", 100_000.0, new GregorianCalendar(2018, GregorianCalendar.JULY, 10).getTime(), new GregorianCalendar(2018, GregorianCalendar.JULY,  10).getTime()))
                        .addRow(new HangThucPham(2, "Mi", 5_000, new GregorianCalendar(2018, GregorianCalendar.MARCH, 1).getTime(), new GregorianCalendar(2018, GregorianCalendar.SEPTEMBER,   1).getTime()))
                        .addRow(new HangThucPham(3, "Nuoc", 10_000.0, new GregorianCalendar(2017, GregorianCalendar.MARCH, 10).getTime(), new GregorianCalendar(2017, GregorianCalendar.MARCH, 1).getTime()));
        System.out.println(maker);
        HangThucPham htp = new HangThucPham(13);
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap ngay san xuat: ");
        String[] splitProd = scan.nextLine().split("/");
        // 1 day = 86400 sec
        // 1 month = 2629743 sec
        // 1 year = 31556926 sec
        htp.setProd(new GregorianCalendar(Integer.parseInt(splitProd[2]), Integer.parseInt(splitProd[1]) - 1, Integer.parseInt(splitProd[0])).getTime());
        System.out.print("Nhap ngay het han ");
        String[] splitExp = scan.nextLine().split("/");
        htp.setExp(new GregorianCalendar(Integer.parseInt(splitExp[2]), Integer.parseInt(splitExp[1]) - 1, Integer.parseInt(splitExp[0])).getTime());
    }
}
import query_maker.QueryMaker;

import java.util.GregorianCalendar;

class DanhSachHangHoa{
//    private final HangHoa[] hangHoa = new HangHoa[10];
    private final QueryMaker maker = new QueryMaker().addFieldName("ID")
            .addFieldName("Tên").addFieldName("Giá").addFieldName("Tồn kho")
            .addFieldName("Đánh giá");
//    private int count = 0;

    public DanhSachHangHoa themHangHoa(HangHoa hh){
//        hangHoa[count++] = hh;
        maker.addRow(hh);
        return this;
    }
    public int soLuong(){
//        return count;
        return maker.rowCount();
    }
    @Override
    public String toString(){
        return maker.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        DanhSachHangHoa ds = new DanhSachHangHoa();
        HangHoa thucPham = new HangThucPham(0, "Thịt heo", 30_000, new GregorianCalendar(2018, GregorianCalendar.JULY, 10).getTime(), new GregorianCalendar(2018, GregorianCalendar.JULY,  10).getTime());
        thucPham.setCount(12);
        HangHoa doDien = new HangDien(1, "ổ điện", 15_000);
        doDien.setCount(2);
        HangHoa doSanhSu = new HangSanhSu(2, "Lọ hoa", 300_000);
        ds.themHangHoa(thucPham).themHangHoa(doDien).themHangHoa(doSanhSu);
        System.out.println(ds);
    }
}
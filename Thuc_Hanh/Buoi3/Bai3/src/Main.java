public class Main {
    public static void main(String[] args) {
        DanhSachSinhVien dssv = new DanhSachSinhVien();
        dssv.themSinhVien(new SinhVien(1, "A", 2003, "", ""))
                .themSinhVien(new SinhVien(2, "B", 2002, "", ""))
                .themSinhVien(new SinhVien(3, "C", 2001, "", ""))
                .themSinhVien(new SinhVien(4, "D", 1999, "", ""))
                .themSinhVien(new SinhVien(5, "E", 1998, "", ""))
                .themSinhVien(new SinhVien(6, "F", 1997, "", ""));
        System.out.println(dssv);
    }
}
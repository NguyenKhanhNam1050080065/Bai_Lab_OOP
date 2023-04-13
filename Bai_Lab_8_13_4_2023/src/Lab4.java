import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        SanPham sp1 = new SanPham(), sp2 = new SanPham();
        sp1.nhap();
        sp1.xuat();
        sp2.nhap();
        sp2.xuat();

        sp1 = new SanPham("Toyota Hilux", 130_000_000);
        sp2 = new SanPham("Kia Sonnet", 650_000_000, 0.25);
        sp1.xuat(); sp2.xuat();
    }
}

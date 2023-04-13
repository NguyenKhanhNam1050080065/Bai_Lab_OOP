import java.util.Scanner;

public class SanPham {
    private String tenSp = "";
    private double donGia = 0.0;
    private double giamGia = 0.0;

    public double getDonGia() {
        return donGia;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    private double getThueNhapKhau(){
        return 0.1 * donGia;
    }
    public void nhap(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ten san pham: ");
        tenSp = scan.nextLine();
        System.out.print("Don gia: ");
        donGia = scan.nextDouble();
        System.out.print("Giam gia: ");
        giamGia = scan.nextDouble();
    }
    public void xuat(){
        System.out.printf("Ten san pham: %s%n", tenSp);
        System.out.printf("Don gia: %f%n", donGia);
        System.out.printf("Giam gia: %f%n", giamGia);
        System.out.printf("Thue nhap khau: %f%n%n", getThueNhapKhau());
    }
    public SanPham(String sp, double dg, double gg){
        tenSp = sp; donGia = dg; giamGia = gg;
    }
    public SanPham(String sp, double dg){
        this(sp, dg, 0.0);
    }
    public SanPham(){}
}
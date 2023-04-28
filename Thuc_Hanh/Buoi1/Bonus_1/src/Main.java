import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap N = ");
        int n = scan.nextInt();
        if (n <= 0) throw new RuntimeException("Invalid array length");
        final SinhVien[] ds = new SinhVien[n];
        for (int i = 0; i < n; i++){
            ds[i] = new SinhVien();
            ds[i].input();
        }
        SinhVien.sort(ds, SinhVien.ASCENDING);
        for (SinhVien sv : ds){
            System.out.println(sv);
        }
    }
}
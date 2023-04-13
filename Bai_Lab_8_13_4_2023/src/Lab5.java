import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;


public class Lab5 {
    private static final List<String> list = new ArrayList<>();

    public static void nhap(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Ho va ten: ");
            String x = scanner.nextLine();
            list.add(x);

            System.out.print("Nhap them? (Y/N):");
        } while (!scanner.nextLine().equals("N"));
    }
    public static void xuat(){
        for (String s : list){
            System.out.println("Ho va Ten: " + s);
        }
    }
    public static void ngauNhien(){
        Collections.shuffle(list);
    }
    public static void giamDan(){
        Collections.sort(list); Collections.reverse(list);
    }
    public static void xoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tim ho ten: ");
        String f = scanner.nextLine();
        if (!list.contains(f)) System.out.println("Khong co ten trong danh sach");
        else {
            list.remove(f);
            System.out.println("Da xoa ten: " + f);
        }
    }
    public static void b1(){
        List<Double> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            Double x = scanner.nextDouble();
            list.add(x);

            System.out.println("Nhap them? (Y/N):");
            if (scanner.nextLine().equals("N")) break;
        }
    }
    public static void b2() { menu(); }
    public static void b3(){
        Scanner scanner = new Scanner(System.in);
        List<SanPham> sp = new ArrayList<>();
        do {
            SanPham newSp = new SanPham();
            newSp.nhap();
            sp.add(newSp);
            System.out.print("Nhap tiep? (Y/N): ");
        } while (!scanner.nextLine().equals("N"));
        sp.sort(Comparator.comparingDouble(SanPham::getDonGia));
        for (SanPham s : sp) s.xuat();
        System.out.print("Nhap ten san pham can xoa: ");
        String f = scanner.nextLine();
        for (int i = 0; i < sp.size(); i++){
            if (sp.get(i).getTenSp().equals(f)){
                sp.remove(i); f = ""; break;
            }
        }
        if (f.isEmpty()) System.out.println("Xoa san pham khong thanh cong");
        else System.out.println("Xoa san pham thanh cong");
    }
    public static void menu(){
        int selected = 0;
        final Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("1. Nhap%n2. Xuat%n3. Sap xep%n4. Ngau nhien%n5. Xoa%n6. Thoat%n");
            System.out.print("Lua chon: ");
            selected = scan.nextInt();
            switch (selected){
                case 1 -> nhap();
                case 2 -> xuat();
                case 3 -> giamDan();
                case 4 -> ngauNhien();
                case 5 -> xoa();
            }
        } while (selected != 0);
    }
    public static void main(String[] args) {
        b1(); b2(); b3();
    }
}

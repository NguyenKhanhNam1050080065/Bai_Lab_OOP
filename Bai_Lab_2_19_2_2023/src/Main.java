import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);
    static void ln(String msg){
        System.out.println(msg);
    }
    static void lf(String format, Object... args){
        System.out.printf(format, args);
    }
    static void solve_ax_b(){
        double a, b;
        lf("a = ");
        a = scan.nextDouble();
        lf("b = ");
        b = scan.nextDouble();
        if (a == 0 && b != 0) {
            ln("Phuong trinh vo nghiem"); return;
        }
        if (a == 0 && b == 0) ln("Phuong trinh vo so nghiem");
        else {
            lf ("Nghiem cua phuong trinh la x = %f%n", -b / a);
        }
    }
    static void solve_ax2_bx_c(){
        Scanner scan = new Scanner(System.in);
        double a, b, c;
        lf("a = ");
        a = scan.nextDouble();
        lf("b = ");
        b = scan.nextDouble();
        lf("c = ");
        c = scan.nextDouble();
        double delta = (b * b) - (4 * a * c);
        if (delta == 0.0){
            lf ("Nghiem cua phuong trinh la x1 = x2 = %f%n", - b / (2.0 * a));
        } else if (delta < 0.0){
            ln("Phuong trinh vo nghiem");
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            lf ("Nghiem cua phuong trinh la x1 = %s | x2 = %f%n", x1, x2);
        }

    }
    static void solve_electricity_bill(){
        double kwh_count = 0.0;
        lf("So dien su dung trong thang: "); kwh_count = scan.nextDouble();
        lf("Tien dien cua thang: %s%n", kwh_count < 50 ? kwh_count * 1000.0 : 50_000 + (kwh_count - 50) * 1200);
    }

    static boolean selector(){
        int option;
        lf("\nLua chon bai tap:\n\t1. %s\n\t2. %s\n\t3. %s\n\t4. %s\n",
                "Tinh phuong trinh bac 1",
                "Tinh phuong trinh bac 2",
                "Tinh tien dien",
                "Thoai khoi chuong trinh");
        lf("Lua chon cua ban: ");
        option = scan.nextInt();
        switch (option){
            case 1 -> { solve_ax_b(); }
            case 2 -> { solve_ax2_bx_c(); }
            case 3 -> { solve_electricity_bill(); }
            case 4 -> { return false; }
            default -> { ln("Lua chon khong hop le"); }
        }
        return true;
    }
    public static void main(String[] args) {
//        solve_ax_b();
        while (selector()){continue;}
    }
}
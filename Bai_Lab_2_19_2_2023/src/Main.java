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
    // Phương pháp bitmask
    static void exponent_of_2(){
        int n;
        lf("N = "); n = scan.nextInt();
        if (n > 0){
            if ((n & (n - 1)) == 0) {
                ln("N la so chinh phuong"); return;
            }
        }
        ln("N khong phai so chinh phuong");
    }
    static void scoring(){
        float point;
        lf("Nhap diem = "); point = scan.nextFloat();
        String result = point > 8.0 ? "Gioi" : point > 7.0 ? "Kha" : point > 5.0 ? "Trung binh" : "Kem";
        lf("Hoc sinh nay la Hoc sing %s%n".formatted(result));
    }

    static void to_str(){
        int n;
        lf("N = "); n = scan.nextInt();
        if (n < 100 || n > 999){
            ln("N khong phai so nguyen co 3 chu so"); return;
        }
        char[] str = new char[3];
        str[0] = (char) ((n / 100) + 48);
        str[1] = (char) ((n / 10) - ((str[0] - 48) * 10) + 48);
        str[2] = (char) (n - ((str[0] - 48) * 100) - ((str[1] - 48) * 10) + 48);
        lf("N duoi dang chuoi: \"%s\"".formatted(String.valueOf(str)));
    }
    static void permutation(){
        int n; long re = 1;
        lf("N = "); n = scan.nextInt();
        if (n < 1){
            ln("N khong hop le"); return;
        }
        for (int i = 1; i <= n; i++){
            re *= i;
        }
        lf("Giai thua cua N la %s%n".formatted(re));
    }

    static class AutoSortCell {
        public AutoSortCell next;
        public int value;

        public static AutoSortCell[] allocate(AutoSortCell[] cells, int power, int value){
            int idx = value % power;
            AutoSortCell re = new AutoSortCell();
            re.value = value;
            if (cells[idx] == null){
                cells[idx] = re;
                return cells;
            }
            AutoSortCell prev = null;
            AutoSortCell curr = cells[idx];
            while (curr != null){
                if (curr.value > value){
                    re.next = curr;
                    if (prev == null){
                        cells[idx] = re;
                    } else prev.next = re;
                    return cells;
                }
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) prev.next = re;
            return cells;
        }
    }

    static void sort_and_cut(){
        final int ARRAY_POWER = 1;
        AutoSortCell[] asc_table = new AutoSortCell[ARRAY_POWER];
        int n, x;
        do {
            lf("Nhap N = ");
            n = scan.nextInt();
        } while (n < 1);
        for (int i = 0; i < n; i++){
            lf("a[%d] = ".formatted(i));
            int val = scan.nextInt();
            AutoSortCell.allocate(asc_table, ARRAY_POWER, val);
        }
        StringBuilder out = new StringBuilder();
        do {
            lf("Nhap X = ");
            x = scan.nextInt();
        } while (x < 1);
        AutoSortCell prev = null, curr = null;
        for (int i = 0; i < ARRAY_POWER; i++){
            curr = asc_table[i];
            if (curr == null) continue;
            while (curr != null){
                if (curr.value == x){
                    if (prev == null) {
                        asc_table[i] = curr.next;
                        continue;
                    } else {
                        prev.next = curr.next;
                        curr = curr.next;
                    }
                }
                out.append(curr.value).append(" ");
                prev = curr;
                curr = curr.next;
            }
        }
        lf("Chuoi sau khi da xoa x: %s%n".formatted(out.toString()));
    }
    static void adjacent(){
        int n;
        do {
            lf("Nhap N = ");
            n = scan.nextInt();
        } while (n < 1);
        int[][] matrix = new int[n][n];
        boolean is_adjacent = true;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                lf("Matrix[%d][%d] = ".formatted(i, j));
                int inp = scan.nextInt();
                matrix[i][j] = inp;
                if (i >= j){
                    if (matrix[i][j] != matrix[j][i])
                        is_adjacent = false;
                }
            }
        }
        ln(is_adjacent ? "Ma tran doi xung" : "Ma tran khong doi xung");
    }

    static boolean selector(){
        int option;
        lf("\nLua chon bai tap:\n\t1. %s\n\t2. %s\n\t3. %s\n\t4. %s\n\t5. %s\n\t6. %s\n\t7. %s\n\t8. %s\n\t9. %s\n\t10. %s\n",
                "Tinh phuong trinh bac 1",
                "Tinh phuong trinh bac 2",
                "Tinh tien dien",
                "So chinh phuong",
                "Tinh danh hieu hoc sinh",
                "So nguyen co 3 chu so thanh chuoi",
                "Tinh giai thua",
                "Xoa phan tu va in ra man hinh",
                "Tim ma tran doi xung",
                "Thoai khoi chuong trinh");
        lf("Lua chon cua ban: ");
        option = scan.nextInt();
        switch (option){
            case 1 -> { solve_ax_b(); }
            case 2 -> { solve_ax2_bx_c(); }
            case 3 -> { solve_electricity_bill(); }
            case 4 -> { exponent_of_2(); }
            case 5 -> { scoring(); }
            case 6 -> { to_str(); }
            case 7 -> { permutation(); }
            case 8 -> { sort_and_cut(); }
            case 9 -> { adjacent(); }
            case 10 -> { return false; }
            default -> { ln("Lua chon khong hop le"); }
        }
        return true;
    }
    public static void main(String[] args) {
        while (selector()){continue;}
    }
}
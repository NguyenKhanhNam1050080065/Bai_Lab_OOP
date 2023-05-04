import java.util.Scanner;

public class AccountTest {
    private static boolean menu(AccountList list){
        System.out.printf("1. Them tai khoan%n2. Tai khoan hien co%n3. Thong tin tat ca%n4. Nap tien%n5. Rut tien%n6. " +
                "Chuyen tien%n7. Ket thuc%nChoice (1 - 7): ");
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()){
            case 1 -> System.out.println(list.add(Account.consoleCreate()) ? "Thanh cong" : "That bai");
            case 2 -> System.out.printf("Count: %d", list.size());
            case 3 -> System.out.println(list);
            case 4 -> {
                System.out.print("Id: ");
                Account ac = list.getById(scan.nextLong());
                if (ac == null) {
                    System.out.println("Khong tim thay tai khoan"); return true;
                }
                System.out.print("So luong: ");
                System.out.println(ac.charge(scan.nextDouble()) ? "Thanh cong" : "That bai");
            }
            case 5 -> {
                System.out.print("Id: ");
                Account ac = list.getById(scan.nextLong());
                if (ac == null) {
                    System.out.println("Khong tim thay tai khoan"); return true;
                }
                System.out.print("So luong: ");
                System.out.println(ac.withdraw(scan.nextDouble()) ? "Thanh cong" : "That bai");
            }
            case 6 -> {
                System.out.print("Id no.1: ");
                Account ac1 = list.getById(scan.nextLong());
                System.out.print("Id no.2: ");
                Account ac2 = list.getById(scan.nextLong());
                if (ac1 == null || ac2 == null) {
                    System.out.println("Khong tim thay tai khoan"); return true;
                }
                System.out.print("So luong: ");
                System.out.printf("%d -> %d: %s%n", ac1.getId(), ac2.getId(), Account.transact(ac1, ac2, scan.nextDouble()) ? "Thanh cong" : "That bai");
            }
            case 7 -> {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        AccountList list = new AccountList();
        while (menu(list)) {
            continue;
        }
    }
}
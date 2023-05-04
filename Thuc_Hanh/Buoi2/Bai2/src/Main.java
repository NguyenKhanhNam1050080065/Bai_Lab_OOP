import java.util.Scanner;

public class Main {
    private static boolean menu(CDList list){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("1. Them CD%n2. Thay doi gia%n3. Tong gia thanh%n4. Thong tin tat ca%n5. Giam dan theo gia%n6. Tang dan theo ten%n7. Ket thuc%nChoice (1-7): ");
        switch (scanner.nextInt()){
            case 1 -> System.out.println(list.add(CD.input()) ? "Thanh cong" : "That bai");
            case 2 -> {
                System.out.print("Id: ");
                CD cd = list.getById(scanner.nextLong());
                if (cd == null) {
                    System.out.println("CD khong ton tai"); return true;
                }
                scanner.nextLine();
                System.out.println("Gia moi: ");
                cd.setPrice(scanner.nextDouble());
                System.out.println("Thanh cong");
            }
            case 3 -> System.out.printf("Total: %f%n", list.getTotalPrice());
            case 4 -> System.out.println(list);
            case 5 -> list.descendByPrice();
            case 6 -> list.ascendByName();
            case 7 -> { return false; }
        }
        return true;
    }
    public static void main(String[] args) {
        CDList cdl = new CDList();
        while (menu(cdl)) {}

    }
}
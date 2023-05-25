import simple_menu.MenuAction;
import simple_menu.SimpleMenu;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        final ClassroomList list = new ClassroomList();
        final AtomicInteger counter = new AtomicInteger(1);
        final SimpleMenu menu = new SimpleMenu()
                .addAction(new MenuAction("Thêm phòng", () -> {
                    int curr = counter.getAndIncrement();
                    Classroom room;
                    if (curr % 4 == 0) {
                        room = new PracticalClassroom(curr, "A-%d".formatted(curr));
                        ((PracticalClassroom)room).setComputerCount(60);
                    }
                    else if (curr % 3 == 0) room = new LaboratoryClassroom(curr, "B-%d".formatted(curr));
                    else room = new TheoreticalClassroom(curr, "C-%d".formatted(curr));
                    list.add(room);
                    System.out.printf("Đã thêm %s%n", room);
                }))
                .addAction(new MenuAction("Tìm phòng", () -> {
                    System.out.printf("Tìm phòng id = 2: %s%n".formatted(list.get(2)));
                }))
                .addAction(new MenuAction("In toàn bộ", () -> {
                    System.out.println(list);
                }))
                .addAction(new MenuAction("Xếp theo dãy nhà", () -> {
                    list.sortByBuilding(ClassroomList.ASCENDING);
                    System.out.println("Thành công");
                }))
                .addAction(new MenuAction("Xếp theo diện tích", () -> {
                    list.sortByArea(ClassroomList.DESCENDING);
                    System.out.println("Thành công");
                }))
                .addAction(new MenuAction("Xếp theo bòng đèn", () -> {
                    list.sortByBulbCount(ClassroomList.ASCENDING);
                    System.out.println("Thành công");
                }))
                .addAction(new MenuAction("Cập nhật số máy", () -> {
                    list.updateComputerCount(4, 50);
                    System.out.println("Cập nhật số máy phòng 4 => 50");
                }))
                .addAction(new MenuAction("Xóa phòng", () -> {
                    System.out.println("Xóa phòng 1? (Y/N) ");
                    Scanner s = new Scanner(System.in);
                    String ans = s.nextLine();
                    if (Objects.equals(ans, "Y")) list.remove(1);
                }))
                .addAction(new MenuAction("Số phòng học", () -> {
                    System.out.printf("Số phòng: %d%n", list.count());
                }))
                .addAction(new MenuAction("Danh sách phòng có 60 máy", () -> {
                    System.out.println(list.has60Computer());
                }));
        while (!menu.render()) {}
    }
}
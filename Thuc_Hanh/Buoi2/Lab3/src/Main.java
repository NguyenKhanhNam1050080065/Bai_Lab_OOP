public class Main {

    public static void main(String[] args) {
        QuanLySach qls = new QuanLySach();
        qls.add(new Book(1));
        qls.add(new Magazine(2));
        qls.add(new Newspaper(3));
        qls.add(new Book(4));
        qls.add(new Book(5));
        qls.add(new Newspaper(6));
        System.out.printf("Tat ca tai lieu: %n%s%n", qls);
        qls.erase(4);
        System.out.printf("Xoa tai lieu 4: %n%s%n", qls);
        System.out.print("Thong tin tai lieu 3: ");
        qls.view(3);
        System.out.println("Tai lieu 'Newspaper': ");
        qls.viewByType("Newspaper");
    }
}
import java.util.Scanner;

public class SinhVien {
    public static final int ASCENDING = 0;
    public static final int DESCENDING = 1;
    private int id;
    private String name;
    private String address;
    private String phone;
    public SinhVien(int id, String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public SinhVien(){
        this(0, "", "", "");
    }
    @Override
    public String toString(){
        return "SinhVien(mssv=%d, ten=%s, diaChi=%s, SDT=%s)".formatted(id, name, address, phone);
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        if (phone.length() != 9) throw new RuntimeException("Invalid phone number");
        this.phone = phone;
    }
    public void input(){
        Scanner scan = new Scanner(System.in);
        System.out.println("MSSV: ");
        setId(Integer.parseInt(scan.nextLine()));
        System.out.println("Ten SV: ");
        setName(scan.nextLine());
        System.out.println("Dia chi: ");
        setAddress(scan.nextLine());
        System.out.println("SDT: ");
        setPhone(scan.nextLine());
    }
    private static void swap(Object[] arr, int ia, int ib){
        Object mediator = arr[ia];
        arr[ia] = arr[ib];
        arr[ib] = mediator;
    }
    // Bubble sort
    public static void sort(SinhVien[] list, int order){
        for (int i = 0; i < list.length - 1; i++)
            for (int j = 0; j < list.length - i - 1; j++){
                if (order == ASCENDING){
                    if (list[j].getId() > list[j + 1].getId()) swap(list, j, j + 1);
                } else {
                    if (list[j].getId() < list[j + 1].getId()) swap(list, j, j + 1);
                }
            }
    }
}

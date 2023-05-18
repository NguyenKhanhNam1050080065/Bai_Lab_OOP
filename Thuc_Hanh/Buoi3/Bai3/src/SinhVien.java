import query_maker.QueryField;
import query_maker.QueryMaker;
import query_maker.Queryable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SinhVien extends Queryable {
    public static final int ASCENDING = 0;
    public static final int DESCENDING = 1;
    private int id;
    private String name;
    private int dobYear;
    private String address;
    private String phone;
    public SinhVien(int id, String name, int dobYear, String address, String phone){
        this.id = id;
        this.name = name;
        this.dobYear = dobYear;
        this.address = address;
        this.phone = phone;
    }
    public SinhVien(){
        this(0, "", 2000, "", "");
    }
    @Override
    public String toString(){
        return "SinhVien(mssv=%d, ten=%s, namSinh=%d, diaChi=%s, SDT=%s)".formatted(id, name, dobYear, address, phone);
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

    public int getDobYear() {
        return dobYear;
    }

    public void setDobYear(int dobYear) {
        this.dobYear = dobYear;
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
    private static void swap(List<SinhVien> arr, int ia, int ib){
        SinhVien mediator = arr.get(ia);
        arr.set(ia, arr.get(ib));
        arr.set(ib, mediator);
    }
    // Bubble sort
    public static void sort(List<SinhVien> list, int order){
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++){
                if (order == ASCENDING){
                    if (list.get(j).getId() > list.get(j + 1).getId()) swap(list, j, j + 1);
                } else {
                    if (list.get(j).getId() < list.get(j + 1).getId()) swap(list, j, j + 1);
                }
            }
    }

    @Override
    public List<QueryField> queryPrivate() {
        lastQuery = new ArrayList<>();
        lastQuery.add(new QueryField(id, 5));
        lastQuery.add(new QueryField(name, name.length()));
        lastQuery.add(new QueryField(dobYear, 4));
        lastQuery.add(new QueryField(address, address.length()));
        lastQuery.add(new QueryField(phone, phone.length()));
        return lastQuery;
    }
}

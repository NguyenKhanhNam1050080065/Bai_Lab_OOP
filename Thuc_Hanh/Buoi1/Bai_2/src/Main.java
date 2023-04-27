public class Main {
    public static void main(String[] args) {
        SinhVien[] sv = { new SinhVien("123", "Nguyen Van A"),
                new SinhVien("456", "Le Thi B"),
                new SinhVien("321", "Luong Van C") };
        LopHocPhan lhp = new LopHocPhan("123456", "LT Hướng Đối Tượng", "Nguyễn Văn A", "Thứ 7, tiết 4-6, phòng A1.1", sv);
        System.out.println(lhp);
    }
}
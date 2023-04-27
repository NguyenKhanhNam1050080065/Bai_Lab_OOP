public class LopHocPhan {
    private String maLHP;
    private String tenLHP;
    private String tenGV;
    private String thongTinLopHoc;
    private SinhVien[] dsSV;
    public LopHocPhan(String maLHP, String tenLHP, String tenGV, String thongTinLopHoc, SinhVien[] dsSV){
        this.maLHP = maLHP;
        this.tenLHP = tenLHP;
        this.tenGV = tenGV;
        this.thongTinLopHoc = thongTinLopHoc;
        this.dsSV = dsSV;
    }
    public int getSoLuongSV() { return dsSV.length; }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("- Mã LHP: %s%n- Tên LHP: %s%n- GV giảng dạy: %s%n- Thông tin buổi học: %s%n%nDanh sách sinh viên:%n");
        for (SinhVien sv : dsSV){
            builder.append(sv.getMaSV()).append(" | ").append(sv.getHoTen()).append("\n");
        }
        return builder.append("Tổng số sinh viên: ").append(getSoLuongSV()).append("\n").toString().formatted(maLHP, tenLHP, tenGV, thongTinLopHoc);
    }
    public String getThongTinLopHoc() {
        return thongTinLopHoc;
    }

    public SinhVien[] getDsSV() {
        return dsSV;
    }

    public String getMaLHP() {
        return maLHP;
    }

    public String getTenGV() {
        return tenGV;
    }

    public String getTenLHP() {
        return tenLHP;
    }

    public void setThongTinLopHoc(String thongTinLopHoc) {
        this.thongTinLopHoc = thongTinLopHoc;
    }

    public void setDsSV(SinhVien[] dsSV) {
        this.dsSV = dsSV;
    }

    public void setMaLHP(String maLHP) {
        this.maLHP = maLHP;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public void setTenLHP(String tenLHP) {
        this.tenLHP = tenLHP;
    }
}

class NhanVien {
    private String ten;
    private long luong;
    public NhanVien(String ten, long luong){
        this.ten = ten;
        this.luong = luong;
    }
    public NhanVien(){
        this("", 0);
    }
    public String loaiNhanVien() { return ""; }

    public long getLuong() {
        return luong;
    }

    public String getTen() {
        return ten;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String xuatThongTin(){
        return "NhanVien(ten=%s, luuong=%d)".formatted(ten, luong);
    }
    @Override
    public String toString() { return xuatThongTin(); }
    public long tinhLuong(){
        return luong;
    }

}

class NhanVienFullTIme extends NhanVien {
    private int chucVu;
    private int ngayLamThem;
    public NhanVienFullTIme(){
        this("", -1, 0);
    }
    public NhanVienFullTIme(String ten, int chucVu, int ngayLamThem){
        super(ten, 0);
        this.chucVu = chucVu;
        this.ngayLamThem = ngayLamThem;
    }
    @Override
    public String loaiNhanVien() { return "NhanVienFullTIme"; }

    public int getChucVu() {
        return chucVu;
    }
    public int loaiChucVu() {
        return getChucVu();
    }

    public int getNgayLamThem() {
        return ngayLamThem;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    public void setNgayLamThem(int ngayLamThem) {
        this.ngayLamThem = ngayLamThem;
    }
    @Override
    public String xuatThongTin(){
        return "NhanVienFullTime(ten=%s, luuong=%d, chucVu=%d, ngayLamThem=%d)".formatted(getTen(), getLuong(), chucVu, ngayLamThem);
    }
}
class NhanVienPartTime extends NhanVien{
    private int gioLamViec;
    public NhanVienPartTime(){
        super("", 0);
    }
    public NhanVienPartTime(String ten, int gioLamViec){
        super(ten, 0);
        this.gioLamViec = gioLamViec;
    }
    @Override
    public String loaiNhanVien() { return "NhanVienPartTime"; }

    public int getGioLamViec() {
        return gioLamViec;
    }

    public void setGioLamViec(int gioLamViec) {
        this.gioLamViec = gioLamViec;
    }
}

class HocSinh {
    private String stID;
    private String stName;
    private String stClass;
    private double toan = 0.0;
    private double ly = 0.0;
    private double hoa = 0.0;

    public HocSinh(String id, String name, String cl, double t, double l, double h){
        stID = id;
        stName = name;
        stClass = cl;
        toan = t;
        ly = l;
        hoa = h;
    }
    public HocSinh(){
        this("696969", "Mary Sue", "UngaBunga", 0.0, 0.0, 0.0);
    }
    public HocSinh(HocSinh other){
        copy(other);
    }
    public static double clamp(double value, double min, double max){
        return value < min ? min : Math.min(value, max);
    }
    public void copy(HocSinh other){
        stClass = other.stClass;
        stID = other.stID;
        stName = other.stName;
        toan = other.toan;
        ly = other.ly;
        hoa = other.hoa;
    }
    public HocSinh duplicate(){
        return new HocSinh(this);
    }
    public String getStClass() {
        return stClass;
    }
    public String getStID() {
        return stID;
    }
    public String getStName() {
        return stName;
    }
    public void setStClass(String stClass) {
        this.stClass = stClass;
    }
    public void setStID(String stID) {
        this.stID = stID;
    }
    public void setStName(String stName) {
        this.stName = stName;
    }
    public double getHoa() {
        return hoa;
    }
    public double getLy() {
        return ly;
    }
    public double getToan() {
        return toan;
    }
    public void setHoa(double hoa) {
        this.hoa = clamp(hoa, 0.0, 10.0);
    }
    public void setLy(double ly) {
        this.ly = clamp(ly, 0.0, 10.0);
    }
    public void setToan(double toan) {
        this.toan = clamp(toan, 0.0, 10.0);
    }
    public double trungBing(){
        return (toan + ly + hoa) / 3.0;
    }

    @Override
    public String toString(){
        return "Student(stID = %s, stName = %s, stClass = %s, toan=%f, ly=%f, hoa=%f)".formatted(stID, stName, stClass, toan, ly, hoa);
    }
}

class HocSinhChuyenToan extends HocSinh{
    public HocSinhChuyenToan(String id, String name, String cl, double t, double l, double h){
        super(id, name, cl, t, l, h);
    }
    public HocSinhChuyenToan(){
        super();
    }
    public HocSinhChuyenToan(HocSinh other){
        super(other);
    }
    @Override
    public double trungBing(){
        return ((getToan() * 2.0) + getLy() + getHoa()) / 4.0;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}

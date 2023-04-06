class HangSanXuat {
    public String tenHangSanXuat;
    public String tenQuocGia;
    public HangSanXuat(){ this ("", ""); }
    public HangSanXuat(String a, String b) {
        tenHangSanXuat = a; tenQuocGia = b;
    }
}

abstract class PhuongTienDiChuyen {
    protected String loaiPhuongTien;
    protected final HangSanXuat hangSanXuat;

    public PhuongTienDiChuyen(HangSanXuat h){
        hangSanXuat = h;
    }
    String layTenHangSanXuat(){
        return hangSanXuat.tenHangSanXuat;
    }
    abstract void batDau();
    abstract void tangToc();
    abstract void dungLai();
    abstract double layVanToc();
}

class MayBay extends PhuongTienDiChuyen {
    String loaiNhienLieu;

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }

    public MayBay(){
        super(new HangSanXuat("Airbus", "EUR"));
    }
    @Override
    void batDau() {

    }

    @Override
    void tangToc() {

    }

    @Override
    void dungLai() {

    }

    @Override
    double layVanToc() {
        return 330.0;
    }
}

class XeOto extends PhuongTienDiChuyen {
    String loaiNhienLieu;

    public String getLoaiNhienLieu() {
        return loaiNhienLieu;
    }

    public void setLoaiNhienLieu(String loaiNhienLieu) {
        this.loaiNhienLieu = loaiNhienLieu;
    }
    public XeOto(){
        super(new HangSanXuat("Porsche", "GER"));
    }
    @Override
    void batDau() {

    }

    @Override
    void tangToc() {

    }

    @Override
    void dungLai() {

    }

    @Override
    double layVanToc() {
        return 57.0;
    }
}

class XeDap extends PhuongTienDiChuyen {
    public XeDap(){
        super(new HangSanXuat("VienBike", "VIE"));
    }
    @Override
    void batDau() {

    }

    @Override
    void tangToc() {

    }

    @Override
    void dungLai() {

    }

    @Override
    double layVanToc() {
        return 10.0;
    }
}

public class BaiTap1 {
    public static void main(String[] args) {

    }
}

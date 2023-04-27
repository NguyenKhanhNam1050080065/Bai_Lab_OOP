public class SinhVien {
    private String maSV;
    private String hoTen;
    public SinhVien(String maSV, String hoTen){
        this.maSV = maSV;
        this.hoTen = hoTen;
    }
    @Override
    public String toString(){
        return "SinhVien(maSV=%s, hoTen=%s)".formatted(maSV, hoTen);
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
}

public class CongNhan extends CanBo{
    private int grade;
    public CongNhan(String name, int grade){
        super(name, "Cong Nhan");
        this.grade = grade;
    }
    @Override
    public String toString(){
        return "CongNhan(ten=%s, capBac=%s)".formatted(getName(), grade);
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}

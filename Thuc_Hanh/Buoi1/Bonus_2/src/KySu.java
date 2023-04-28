public class KySu extends CanBo{
    String education;
    public KySu(String name, String gd){
        super(name, "Ky Su");
        education = gd;
    }
    @Override
    public String toString(){
        return "KySu(ten=%s, trinhDoGiaoDuc=%s)".formatted(getName(), education);
    }
    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }
}

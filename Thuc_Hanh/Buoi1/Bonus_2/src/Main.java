import java.util.ArrayList;
import java.util.List;

class DanhSachCanBo{
    private final List<CanBo> personnel = new ArrayList<>();
    public void add(CanBo p){
        personnel.add(p);
    }
    public CanBo find(String name){
        for (CanBo p : personnel){
            if (p.nameSearch(name)) return p;
        }
        return null;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("DanhSachCanBo(");
        for (int i = 0; i < personnel.size(); i++){
            builder.append(personnel.get(i));
            if (i != personnel.size() - 1) builder.append(", ");
        }
        return builder.append(")").toString();
    }
}

public class Main {
    public static void main(String[] args) {
        DanhSachCanBo ds = new DanhSachCanBo();
        ds.add(new CongNhan("AAA Alpha", 10));
        ds.add(new KySu("BBB Beta", "Thac Si"));
        System.out.println(ds.find("A Al"));
    }
}
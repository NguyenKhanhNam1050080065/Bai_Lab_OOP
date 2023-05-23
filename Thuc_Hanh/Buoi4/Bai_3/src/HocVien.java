import query_maker.QueryField;
import query_maker.QueryMaker;
import query_maker.Queryable;

import java.util.ArrayList;
import java.util.List;

public class HocVien {
    private final List<DiemHocVien> students = new ArrayList<>();
    public String generalInfos(){
        QueryMaker maker = new QueryMaker().addFieldName("Name").addFieldName("Year of Birth").addFieldName("Status");
        for (DiemHocVien hv : students){
            final DiemHocVien locked = hv;
            maker.addRow(new Queryable() {
                @Override
                public List<QueryField> queryPrivate() {
                    List<QueryField> re = new ArrayList<>();
                    re.add(new QueryField(locked.getName(), locked.getName().length()));
                    re.add(new QueryField(locked.getYearOfBirth(), 4));
                    int below5count = 0;
                    for (int i = 0; i < 5; i++){
                        below5count += locked.getGrade(i) < 5.0 ? 1 : 0;
                    }
                    if (below5count > 0) re.add(new QueryField("Not passed", 10));
                    else {
                        if (locked.average() > 7.0) re.add(new QueryField("Thesis", 6));
                        else re.add(new QueryField("Pass", 4));
                    }
                    return re;
                }
            });
        }
        return maker.toString();
    }
    public HocVien add(DiemHocVien hv){
        students.add(hv);
        return this;
    }
    public String scores(){
        QueryMaker maker = new QueryMaker().addFieldName("Name").addFieldName("Subject0").addFieldName("Subject1").addFieldName("Subject2").addFieldName("Subject3").addFieldName("Subject4");
        for (DiemHocVien hv : students){
            maker.addRow(hv);
        }
        return maker.toString();
    }
}

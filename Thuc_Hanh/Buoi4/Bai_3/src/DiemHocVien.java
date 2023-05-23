import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DiemHocVien extends Queryable {
    private String name;
    private int yearOfBirth;
    private final double[] grades;
    private double total = 0.0;
    public DiemHocVien(String name, int yearOfBirth){
        this(name, yearOfBirth, new double[5]);
    }
    public DiemHocVien(String name, int yearOfBirth, double[] grades){
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.grades = grades;
        for (double g : grades){
            total += g;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double average(){
        return total / 5.0;
    }
    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth <= 1900) throw new RuntimeException();
        this.yearOfBirth = yearOfBirth;
    }
    public void setGrade(int idx, double grade){
        if (idx <0 || idx >= 5 || grade < 0.0 || grade > 10.0) throw new RuntimeException();
        total -= grades[idx];
        total += grade;
        grades[idx] = grade;
    }
    public double getGrade(int idx){
        if (idx <0 || idx >= 5) throw new RuntimeException();
        return grades[idx];
    }

    @Override
    public List<QueryField> queryPrivate() {
        List<QueryField> re = new ArrayList<>();
        re.add( new QueryField(getName(), getName().length()));
        for (double g : grades){
            String formatted = new DecimalFormat("###,###.00").format(g);
            re.add(new QueryField(formatted, formatted.length()));
        }
        return re;
    }
}

import query_maker.QueryField;
import query_maker.Queryable;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class Classroom extends Queryable {
    private final int id;
    private final String buildingBlock;
    private double area;
    private int lightBulbCount;

    @Override
    public List<QueryField> queryPrivate(){
        List<QueryField> re = new ArrayList<>();
        String areaFormatted = new DecimalFormat("###,###.00").format(area);
        re.add(new QueryField(id, 5));
        re.add(new QueryField(buildingBlock, buildingBlock.length()));
        re.add(new QueryField(areaFormatted, areaFormatted.length()));
        re.add(new QueryField(lightBulbCount, 5));
        re.add(new QueryField(isUpToStandard() ? "Good" : "Bad", 5));

        return re;
    }
    public Classroom(int id, String buildingBlock){
        this.id = id;
        this.buildingBlock = buildingBlock;
    }

    public int getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public int getLightBulbCount() {
        return lightBulbCount;
    }

    public String getBuildingBlock() {
        return buildingBlock;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setLightBulbCount(int lightBulbCount) {
        this.lightBulbCount = lightBulbCount;
    }
    public boolean isUpToStandard(){
        return area > 10 && lightBulbCount > 1;
    }
}

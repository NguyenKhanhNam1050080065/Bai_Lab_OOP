import query_maker.QueryMaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassroomList {
    public static final int ASCENDING = 0;
    public static final int DESCENDING = 1;
    private final Map<Integer, Classroom> map = new HashMap<>();
    private final List<Classroom> list = new ArrayList<>();
    public ClassroomList add(Classroom room){
        if (map.containsKey(room.getId())) return this;
        map.put(room.getId(), room);
        list.add(room);
        return this;
    }
    @Override
    public String toString(){
        QueryMaker maker = new QueryMaker().addFieldName("ID").addFieldName("Building").addFieldName("Area").addFieldName("Light bulb count").addFieldName("Is up to standard");
        for (Classroom E : list){
            maker.addRow(E);
        }
        return maker.toString();
    }
    public String printQualified(){
        QueryMaker maker = new QueryMaker().addFieldName("ID").addFieldName("Building").addFieldName("Area").addFieldName("Light bulb count").addFieldName("Is up to standard");
        for (Classroom E : list){
            if (E.isUpToStandard()) maker.addRow(E);
        }
        return maker.toString();
    }
    private static void swap(List<Classroom> arr, int ia, int ib){
        Classroom mediator = arr.get(ia);
        arr.set(ia, arr.get(ib));
        arr.set(ib, mediator);
    }
    // Bubble sort
    public void sortByBuilding(int order){
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++){
                if (order == ASCENDING){
                    if (list.get(j).getBuildingBlock().charAt(0) > list.get(j + 1).getBuildingBlock().charAt(0)) swap(list, j, j + 1);
                } else {
                    if (list.get(j).getBuildingBlock().charAt(0) < list.get(j + 1).getBuildingBlock().charAt(0)) swap(list, j, j + 1);
                }
            }
    }
    public void sortByArea(int order){
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++){
                if (order == ASCENDING){
                    if (list.get(j).getArea() > list.get(j + 1).getArea()) swap(list, j, j + 1);
                } else {
                    if (list.get(j).getArea() < list.get(j + 1).getArea()) swap(list, j, j + 1);
                }
            }
    }
    public void sortByBulbCount(int order){
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++){
                if (order == ASCENDING){
                    if (list.get(j).getLightBulbCount() > list.get(j + 1).getLightBulbCount()) swap(list, j, j + 1);
                } else {
                    if (list.get(j).getLightBulbCount() < list.get(j + 1).getLightBulbCount()) swap(list, j, j + 1);
                }
            }
    }
    public void sortById(int order){
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = 0; j < list.size() - i - 1; j++){
                if (order == ASCENDING){
                    if (list.get(j).getId() > list.get(j + 1).getId()) swap(list, j, j + 1);
                } else {
                    if (list.get(j).getId() < list.get(j + 1).getId()) swap(list, j, j + 1);
                }
            }
    }
    public void updateComputerCount(int id, int newCount){
        if (!map.containsKey(id)) return;
        Classroom room = map.get(id);
        if (room.getClass() != PracticalClassroom.class) return;
        PracticalClassroom casted = (PracticalClassroom) room;
        casted.setComputerCount(newCount);
        map.put(id, casted);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id) {
                list.set(i, casted); break;
            }
        }
    }
    public void remove(int id){
        map.remove(id);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id) {
                list.remove(i); break;
            }
        }
    }
    public int count(){
        return map.size();
    }
    public String has60Computer(){
        QueryMaker maker = new QueryMaker().addFieldName("ID").addFieldName("Building").addFieldName("Area").addFieldName("Light bulb count").addFieldName("Is up to standard");
        for (Classroom E : list){
            if (E.getClass() == PracticalClassroom.class && ((PracticalClassroom)E).getComputerCount() == 60) maker.addRow(E);
        }
        return maker.toString();
    }
    public Classroom get(int id){
        if (map.containsKey(id)) return map.get(id);
        return null;
    }
}

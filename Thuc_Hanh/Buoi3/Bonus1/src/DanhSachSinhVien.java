import query_maker.QueryMaker;

import java.util.*;

public class DanhSachSinhVien {
    private final Map<String, SinhVien> cache = new HashMap<>();
    private final List<SinhVien> dsSinhVien = new ArrayList<>();

    public DanhSachSinhVien themSinhVien(SinhVien sv){
        if (cache.containsKey(sv.getId())) throw new RuntimeException();
        cache.put(sv.getId(), sv);
        dsSinhVien.add(sv);
        return this;
    }
    public DanhSachSinhVien xoaSinhVien(String id) {
        if (!cache.containsKey(id)) return this;
        cache.remove(id);
        for (int i = 0; i < dsSinhVien.size(); i++){
            if (Objects.equals(dsSinhVien.get(i).getId(), id)){
                dsSinhVien.remove(i); break;
            }
        }
        return this;
    }
    public DanhSachSinhVien suaSinhVien(String id, SinhVien sv){
        if (!cache.containsKey(id)) throw new RuntimeException();
        cache.put(sv.getId(), sv);
        for (int i = 0; i < dsSinhVien.size(); i++){
            if (Objects.equals(dsSinhVien.get(i).getId(), id)){
                dsSinhVien.set(i, sv); break;
            }
        }
        return this;
    }
    public SinhVien timTheoId(String id){
        if (!cache.containsKey(id)) return null;
        return cache.get(id);
    }
    public DanhSachSinhVien sapXep(int order){
        SinhVien.sortByAverage(dsSinhVien, order);
        return this;
    }
    public DanhSachSinhVien sapXep(){
        SinhVien.sortByAverage(dsSinhVien, SinhVien.ASCENDING);
        return this;
    }
    private static int findSub(String str, String findStr){
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
    public SinhVien timTheoTen(String name){
        for (SinhVien sv : dsSinhVien){
            if (findSub(sv.getName(), name) > 0) return sv;
        }
        return null;
    }
    @Override
    public String toString(){
        final QueryMaker maker = new QueryMaker();
        maker.addFieldName("ID").addFieldName("Tên").addFieldName("Năm sinh").addFieldName("Địa chỉ").addFieldName("SĐT").addFieldName("Điểm trung bình");
        for (SinhVien sv : dsSinhVien){
            maker.addRow(sv);
        }
        return maker.toString();
    }
}

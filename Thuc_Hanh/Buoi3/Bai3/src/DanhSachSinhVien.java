import query_maker.QueryMaker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhSachSinhVien {
    private final Map<Integer, SinhVien> cache = new HashMap<>();
    private final List<SinhVien> dsSinhVien = new ArrayList<>();

    public DanhSachSinhVien themSinhVien(SinhVien sv){
        if (cache.containsKey(sv.getId())) throw new RuntimeException();
        cache.put(sv.getId(), sv);
        dsSinhVien.add(sv);
        return this;
    }
    public DanhSachSinhVien xoaSinhVien(int id) {
        if (!cache.containsKey(id)) return this;
        cache.remove(id);
        for (int i = 0; i < dsSinhVien.size(); i++){
            if (dsSinhVien.get(i).getId() == id){
                dsSinhVien.remove(i); break;
            }
        }
        return this;
    }
    public DanhSachSinhVien suaSinhVien(int id, SinhVien sv){
        if (!cache.containsKey(id)) throw new RuntimeException();
        cache.put(sv.getId(), sv);
        for (int i = 0; i < dsSinhVien.size(); i++){
            if (dsSinhVien.get(i).getId() == id){
                dsSinhVien.set(i, sv); break;
            }
        }
        return this;
    }
    public SinhVien timTheoId(int id){
        if (!cache.containsKey(id)) return null;
        return cache.get(id);
    }
    public DanhSachSinhVien sapXep(int order){
        SinhVien.sort(dsSinhVien, order);
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
        maker.addFieldName("ID").addFieldName("Tên").addFieldName("Năm sinh").addFieldName("Địa chỉ").addFieldName("SĐT");
        for (SinhVien sv : dsSinhVien){
            maker.addRow(sv);
        }
        return maker.toString();
    }
}

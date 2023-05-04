import java.util.HashMap;
import java.util.Map;

public class CDList {
    private final CD[] arr;
    private final Map<Long, Integer> cache;
    private int pointer = 0;
    private double totalPrice = 0.0;
    public CDList(){
        this(10);
    }
    public CDList(int size){
        arr = new CD[size];
        cache = HashMap.newHashMap(size);
    }
    public boolean add(CD cd){
        if (pointer >= arr.length || cache.containsKey(cd.getId())) return false;
        arr[pointer++] = cd;
        cache.put(cd.getId(), pointer - 1);
        totalPrice += cd.getPrice();
        cd.onPriceChange((oldValue, newValue) -> {
            totalPrice -= oldValue;
            totalPrice += newValue;
        });
        return true;
    }
    public CD getById(long id){
        if (!cache.containsKey(id)) return null;
        return arr[cache.get(id)];
    }
    private void buildCache(){
        cache.clear();
        for (int i = 0; i < pointer; i++){
            cache.put(arr[i].getId(), i);
        }
    }
    private static void swap(Object[] arr, int idx, int idy){
        Object in = arr[idx];
        arr[idx] = arr[idy];
        arr[idy] = in;
    }
    public void descendByPrice(){
        int i, j;
        int n = pointer;
        for (i = 0; i < n - 1; i++)
            for (j = 0; j < n - i - 1; j++)
                if (arr[j].getPrice() < arr[j + 1].getPrice())
                    swap(arr, j, j + 1);
        buildCache();
    }
    public void ascendByName(){
        int i, j;
        int n = pointer;
        for (i = 0; i < n - 1; i++)
            for (j = 0; j < n - i - 1; j++)
                if (arr[j].getName().charAt(0) > arr[j + 1].getName().charAt(0))
                    swap(arr, j, j + 1);
        buildCache();
    }
    public int size(){
        return pointer;
    }
    public double getTotalPrice(){
        return totalPrice;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (CD cd : arr) {
            builder.append(cd).append("\n");
        }
        return builder.toString();
    }
}

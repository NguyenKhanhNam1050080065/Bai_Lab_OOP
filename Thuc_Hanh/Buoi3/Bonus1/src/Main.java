import java.util.HashMap;
import java.util.Map;

class IntHolder {
    public static final int CAPACITY = 10;
    private final Integer[] array = new Integer[CAPACITY];
    private final Map<Integer, Integer> countCache = new HashMap<>();
    private int isNegativeCount = 0;
    private int maxNegative = 0;
    private int minPositive = 0;
    private int count = 0;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[ ");
        for (int i = 0; i < count - 1; i++){
            builder.append(array[i]).append(", ");
        }
        if (count > 0) builder.append(array[count - 1]);
        return builder.append(" ]").toString();
    }
    public IntHolder add(int value){
        if (count >= CAPACITY) return this;
        array[count++] = value;
        if (countCache.containsKey(value)){
            countCache.put(value, countCache.get(value) + 1);
        } else countCache.put(value, 1);
        if (value < 0) {
            maxNegative = Math.max(maxNegative, value);
            isNegativeCount++;
        } else if (value != 0) {
            minPositive = Math.min(minPositive, value);
        }
        return this;
    }
    public IntHolder remove(int index){
        if (index >= count) return this;
        if (array[index] < 0) {
            isNegativeCount--;
        }
        countCache.put(array[index], countCache.get(array[index]) - 1);
        for (int i = 0; i < count - 1; i++){
            if (i >= index)
                array[i] = array[i + 1];
            if (array[i] < 0){
                maxNegative = Math.max(array[i], maxNegative);
            } else if (array[i] != 0){
                minPositive = Math.min(array[i], minPositive);
            }
        }
        count--;
        return this;
    }
    private static void swap(Object[] arr, int ia, int ib){
        Object mediator = arr[ia];
        arr[ia] = arr[ib];
        arr[ib] = mediator;
    }
    private Integer[] sortAscend(){
        Integer[] re = new Integer[CAPACITY];
        System.arraycopy(array, 0, re, 0, CAPACITY);
        for (int i = 0; i < re.length - 1; i++)
            for (int j = 0; j < re.length - i - 1; j++){
                if (re[j] > re[j + 1]) swap(re, j, j + 1);
            }
        return re;
    }
    private Integer[] sortDescend(){
        Integer[] re = new Integer[CAPACITY];
        System.arraycopy(array, 0, re, 0, CAPACITY);
        for (int i = 0; i < re.length - 1; i++)
            for (int j = 0; j < re.length - i - 1; j++){
                if (re[j] < re[j + 1]) swap(re, j, j + 1);
            }
        return re;
    }
    public boolean exist(int value){
        return duplicateOf(value) != 0;
    }
    public int duplicateOf(int value){
        return countCache.getOrDefault(value, 0);
    }
    public int getMaxNegative() {
        return maxNegative;
    }

    public int getMinPositive() {
        return minPositive;
    }

    public int getIsNegativeCount() {
        return isNegativeCount;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
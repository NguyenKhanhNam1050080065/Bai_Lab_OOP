import java.util.HashMap;
import java.util.Map;

public class AccountList {
    public static final int DEFAULT_SIZE = 10;
    private Account[] accountList;
    private final Map<Long, Integer> indexCache = new HashMap<>();
    private int pointer = 0;
    public AccountList(){
        accountList = new Account[DEFAULT_SIZE];
    }
    public AccountList(int count){
        accountList = new Account[count];
    }
    public void resize(int newSize){
        final Account[] oldArray = accountList;
        accountList = new Account[newSize];
        pointer = Math.min(newSize, oldArray.length);
        System.arraycopy(oldArray, 0, accountList, 0, pointer);
    }
    public boolean add(Account account){
        if (pointer >= accountList.length || indexCache.containsKey(account.getId())) return false;
        push(account);
        return true;
    }
    public void push(Account account){
        if (pointer >= accountList.length) resize(pointer + DEFAULT_SIZE);
        indexCache.put(account.getId(), pointer++);
        accountList[pointer - 1] = account;
    }
    public Account getById(long id){
        if (!indexCache.containsKey(id)) return null;
        int cached = indexCache.get(id);
        return accountList[cached];
    }
    public boolean deleteById(long id){
        if (!indexCache.containsKey(id)) return false;
        accountList[indexCache.get(id)] = null;
        indexCache.remove(id);
        return true;
    }
    public int size(){
        return pointer;
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (Account account : accountList) {
            builder.append(account).append("\n");
        }
        return builder.toString();
    }
}

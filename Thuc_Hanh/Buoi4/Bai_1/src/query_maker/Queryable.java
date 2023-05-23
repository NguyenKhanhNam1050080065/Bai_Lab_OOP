package query_maker;


import java.util.List;

public abstract class Queryable {
    protected List<QueryField> lastQuery = null;
    public List<QueryField> query(){
        if (lastQuery != null) return lastQuery;
        return queryPrivate();
    }
    public abstract List<QueryField> queryPrivate();

}

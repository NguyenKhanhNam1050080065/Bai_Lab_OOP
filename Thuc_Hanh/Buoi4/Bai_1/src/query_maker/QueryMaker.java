package query_maker;

import java.util.ArrayList;
import java.util.List;

public class QueryMaker {
    private final List<Queryable> queryable = new ArrayList<>();
    private final List<String> fieldsName = new ArrayList<>();
    public int masterSpacing = 1;
    public QueryMaker addRow(Queryable row){
        queryable.add(row);
        return this;
    }
    public QueryMaker addFieldName(String name){
        fieldsName.add(name);
        return this;
    }
    private int getColumnSpacing(int col){
        int maxSpacing = 0;
        for (Queryable row : queryable) {
            List<QueryField> fields = row.query();
            if (fields.size() <= col) continue;
            maxSpacing = Math.max(maxSpacing, fields.get(col).spacing());
        }
        maxSpacing = Math.max(fieldsName.get(col).length(), maxSpacing);
        return maxSpacing + masterSpacing;
    }
    public String makeString(){
        if (queryable.isEmpty()) return "";
        List<Integer> spacings = new ArrayList<>();
        int totalSpacing = 0;
        for (int i = 0; i < fieldsName.size(); i++) {
            int s = getColumnSpacing(i);
            spacings.add(s);
            totalSpacing += s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fieldsName.size(); i++){
            String f = fieldsName.get(i);
            int delta = spacings.get(i) - f.length();
            delta = Math.max(1, delta);
            builder.append(f).append(" ".repeat(delta)).append(i == fieldsName.size() - 1 ? "" : "| ");
        }
        builder.append("\n");
//        builder.append("=".repeat(totalSpacing)).append("\n");
        for (Queryable value : queryable) {
            List<QueryField> row = value.query();
            for (int j = 0; j < fieldsName.size(); j++) {
                QueryField field = row.get(j);
                String f = field.target().toString();
                int delta = spacings.get(j) - f.length();
                delta = Math.max(1, delta);
                builder.append(f).append(" ".repeat(delta)).append(j == fieldsName.size() - 1 ? "" : "| ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    @Override
    public String toString(){
        return makeString();
    }
}

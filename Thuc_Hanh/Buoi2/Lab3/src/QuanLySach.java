import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class QuanLySach {
    private final Map<Long, PaperMedium> media = new HashMap<>();
    public boolean add(PaperMedium medium){
        if (media.containsKey(medium.getId())) return false;
        media.put(medium.getId(), medium);
        return true;
    }
    public boolean erase(long id){
        return media.remove(id) != null;
    }
    public PaperMedium get(long id){
        if (media.containsKey(id)) return media.get(id);
        return null;
    }
    public void view(long id){
        PaperMedium medium = get(id);
        if (medium == null) System.out.println("Khong co tai lieu");
        System.out.println(medium);
    }
    public void viewByType(String type){
        switch (type){
            case "Book" -> media.forEach((aLong, paperMedium) -> {
                if (paperMedium.getClass() == Book.class) System.out.println(paperMedium);
            });
            case "Magazine" -> media.forEach((aLong, paperMedium) -> {
                if (paperMedium.getClass() == Magazine.class) System.out.println(paperMedium);
            });
            case "Newspaper" -> media.forEach((aLong, paperMedium) -> {
                if (paperMedium.getClass() == Newspaper.class) System.out.println(paperMedium);
            });
        }
    }
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        media.forEach((aLong, paperMedium) -> builder.append(paperMedium).append("\n"));
        return builder.toString();
    }
}

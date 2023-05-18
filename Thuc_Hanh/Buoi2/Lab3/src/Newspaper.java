import java.util.Date;
import java.util.GregorianCalendar;

public class Newspaper extends PaperMedium {
    private Date publicationDate = new GregorianCalendar().getTime();
    public Newspaper(long id, String publisher) {
        super(id, publisher);
    }

    public Newspaper(long id) {
        super(id);
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate == null ? new GregorianCalendar().getTime() : publicationDate;
    }
    @Override
    public String toString(){
        return "Newspaper(id=%d, publisher=%s, batchSize=%d, publicationDate=%s)".formatted(getId(), getPublisher(), getBatchSize(), publicationDate);
    }
}

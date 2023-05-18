public class Magazine extends PaperMedium {
    private long publicationId;
    private int publicationMonth;
    public Magazine(long id, String publisher) {
        super(id, publisher);
    }

    public Magazine(long id) {
        super(id);
    }

    public void setPublicationId(long publicationId) {
        this.publicationId = publicationId;
    }

    public long getPublicationId() {
        return publicationId;
    }

    public void setPublicationMonth(int publicationMonth) {
        publicationMonth = Math.min(publicationMonth, 12);
        publicationMonth = Math.max(publicationMonth, 1);
        this.publicationMonth = publicationMonth;
    }

    public int getPublicationMonth() {
        return publicationMonth;
    }
    @Override
    public String toString(){
        return "Magazine(id=%d, publisher=%s, batchSize=%d, publicationId=%d, publicationMonth=%d)".formatted(getId(), getPublisher(), getBatchSize(), publicationId, publicationMonth);
    }
}

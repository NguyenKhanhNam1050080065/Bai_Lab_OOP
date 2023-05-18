public class PaperMedium {
    private final long id;
    private String publisher;
    public long batchSize;
    public PaperMedium(long id, String publisher){
        this.id = id;
        this.publisher = publisher;
    }
    public PaperMedium(long id){
        this(id, "");
    }

    public long getId() {
        return id;
    }

    public long getBatchSize() {
        return batchSize;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBatchSize(long batchSize) {
        this.batchSize = batchSize;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

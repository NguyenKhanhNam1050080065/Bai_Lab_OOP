public class Book extends PaperMedium {
    private String author;
    private int pageCount;
    public Book(long id, String publisher) {
        super(id, publisher);
    }
    public Book(long id) {
        super(id);
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = Math.max(pageCount, 1);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString(){
        return "Book(id=%d, publisher=%s, batchSize=%d, author=%s, pageCount=%d)".formatted(getId(), getPublisher(), getBatchSize(), author, pageCount);
    }
}

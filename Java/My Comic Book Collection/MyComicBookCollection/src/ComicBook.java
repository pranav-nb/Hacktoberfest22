import java.io.Serializable;

public class ComicBook implements Serializable {
    private String title;
    private int issue;
    private String author;
    private String artist;
    private double originalPrice;
    private String publisher;
    private int numCopies;

    public ComicBook(String title, int issue, String author, String artist, double originalPrice, String publisher, int numCopies) {
        this.title = title;
        this.issue = issue;
        this.author = author;
        this.artist = artist;
        this.originalPrice = originalPrice;
        this.publisher = publisher;
        this.numCopies = numCopies;
    }

    @Override
    public String toString() {

        return String.format("""
                        Title: %s
                        Issue #: %d
                        Author: %s
                        Artist: %s
                        Original Price : $%,.2f
                        Publisher: %s
                        Number of Copies: %d""", this.getTitle(), this.getIssue(), this.getAuthor(), this.getArtist(),
                this.getOriginalPrice(), this.getPublisher(), this.getNumCopies());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }
}

package Library_Management;

public class Books {
    private String title;

    private String author;

    private boolean availability;

    private int isbn;

    Books(String title,String author,boolean availability,int isbn){
        this.title=title;
        this.author=author;
        this.availability=availability;
        this.isbn=isbn;
    }


    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    
}

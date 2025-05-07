package Tester.demo.dto;

public class Book {
    private int tid;
    private String name;
    private String genre;


    public Book()   {

    }

    public Book(int tid, String name, String genre) {
        this.tid = tid;
        this.name = name;
        this.genre = genre;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

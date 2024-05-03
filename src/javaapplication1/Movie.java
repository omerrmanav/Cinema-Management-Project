package javaapplication1;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private LocalDate date;

    // lazım 
    public Movie(String title, String genre, int duration, LocalDate date) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
    }
    
    public Movie(int id, String title, String genre, int duration, LocalDate date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.date = date;
    }
    
    public Movie(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}


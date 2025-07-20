package org.example;

public abstract class Disk {
    // PROPERTIES
    private String artist;
    private String title;
    private int year;
    private double duration;

    // CONSTRUCTOR
    public Disk(String artist, String title, int year, double duration) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.duration = duration;
    }
    // GETTERS & SETTERS
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Disk{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }
}

package org.example;

public class Disk {
    // PROPERTIES
    private static int nextId = 1;
    private int id;
    private String artist;
    private String title;
    private int year;
    private double duration;

    // EMPTY CONSTRUCTOR
    public Disk() {
        this.id = nextId++;
    }

    // CONSTRUCTOR
    public Disk(String artist, String title, int year, double duration) {
        this.id = nextId++;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getDuration() {
        return duration;
    }

    // SETTERS
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // TO STRING
    @Override
    public String toString() {
        return "ID #" + id + " | " + artist + " - " + title + " (" + year + ") [" + duration + " min]";
    }
}
package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // A LIST IS CREATED WITH 5 ALBUMS
        ArrayList<Disk> Disks = new ArrayList<>();
        Disk disk1 = new Disk("Pink Floyd", "The Dark Side of the Moon", 1973, 42.49);
        Disks.add(disk1);
        Disk disk2 = new Disk("Michael Jackson", "Thriller", 1982, 42.19);
        Disks.add(disk2);
        Disk disk3 = new Disk("The Beatles", "Abbey Road", 1969, 47.23);
        Disks.add(disk3);
        Disk disk4 = new Disk("Nirvana", "Nevermind", 1991, 49.23);
        Disks.add(disk4);
        Disk disk5 = new Disk("Bob Marley & The Wailers", "Legend", 1984, 51.04);
        Disks.add(disk5);

        // WE ASK THE USER FOR AN ACTION
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        do {
            System.out.println("\n" +
                    "-----------------------------------------------------\n" +
                    "ALL TIME CLASSICS ALBUM LIST\n\n" +
                    "Press the number of the action you want to take:\n" +
                    "1) Add an album to the list\n" +
                    "2) Check the full list\n" +
                    "3) Search an specific album\n" +
                    "4) Edit an album of the list\n" +
                    "5) Remove an album of the list\n\n" +
                    " >>> Press 'e' key to exit <<< \n" +
                    "-----------------------------------------------------");

            String response = sc.nextLine();

            switch (response) {
                case "1":
                    Disks.add(createAlbum());
                    System.out.println("The new album was successfully added");
                    break;
                case "2":
                    for (Disk i : Disks) {
                        System.out.println(i);
                    }
                    break;
                case "3":

                    break;
                case "e":
                    System.out.println("Bye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again");
            }
        } while(running);
    }

    public static Disk createAlbum(){
        Disk disk = new Disk();
        Scanner sc = new Scanner (System.in);
        System.out.println("Write the name of the author");
        disk.setArtist(sc.nextLine());
        System.out.println("Write the title of the Album");
        disk.setTitle(sc.nextLine());
        System.out.println("Write the year of debut");
        disk.setYear(sc.nextInt());
        sc.nextLine();
        System.out.println("Write the duration of the album (MM.SS)");
        String input = sc.nextLine();
        disk.setDuration(Double.parseDouble(input.replace(",", ".")));
        return disk;
    }

    public static Disk checkList(){
        for (Disk i : Disks) {
            System.out.println(i);
        }
    }
}
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

            String response = sc.nextLine().toLowerCase();

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
                    searchAlbum(Disks);
                    break;
                case "4":
                    editAlbum(Disks);
                    break;
                case "5":
                    removeAlbum(Disks);
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

    public static void searchAlbum(ArrayList<Disk> Disks){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press the number of the criteria you want to apply in your search: \n" +
                          "1) Search album by artist name\n" +
                          "2) Search album by tittle name\n" +
                          "3) Search album by launch year\n" +
                          "4) Search album by duration");
        String response = sc.nextLine();
        switch (response){
            case "1":
                System.out.println("Enter the name of the artist:");
                String artistName = sc.nextLine().toLowerCase();
                boolean foundArtist = false;
                for (int i = 0; i < Disks.size(); i++) {
                    Disk disk = Disks.get(i);
                    if (disk.getArtist().toLowerCase().contains(artistName)) {
                        System.out.println("✔ Found in position " + i + ": " + disk);
                        foundArtist = true;
                    }
                }
                if (!foundArtist) {
                    System.out.println("✖ No artist found with that name.");
                }
                break;
            case "2":
                System.out.println("Enter the title of the album");
                String albumTitle = sc.nextLine().toLowerCase();
                boolean foundTitle = false;
                for (int i = 0; i < Disks.size(); i++) {
                    Disk disk = Disks.get(i);
                    if (disk.getTitle().toLowerCase().contains(albumTitle)) {
                        System.out.println("✔ Found in position " + i + ": " + disk);
                    }
                }
                if (!foundTitle) {
                    System.out.println("✖ No album found with that title.");
                }
                break;
            case "3":
                System.out.println("Enter the launch year of the album");
                int albumYear = sc.nextInt();
                boolean foundYear = false;
                for (int i = 0; i < Disks.size(); i++) {
                    Disk disk = Disks.get(i);
                    if (disk.getYear() == albumYear) {
                        System.out.println("✔ Found in position " + i + ": " + disk);
                    }
                }
                if (!foundYear) {
                    System.out.println("✖ No album found with that year.");
                }
                break;
            case "4":
                System.out.println("Enter the album duration (MM.SS)");
                double albumDuration = sc.nextDouble();
                boolean foundDuration = false;
                for (int i = 0; i < Disks.size(); i++) {
                    Disk disk = Disks.get(i);
                    if (disk.getDuration() == albumDuration) {
                        System.out.println("✔ Found in position " + i + ": " + disk);
                    }
                }
                if (!foundDuration) {
                    System.out.println("✖ No album found with that duration.");
                }
                break;
            default:
                System.out.println("Invalid option, try again");
                searchAlbum(Disks);
        }
    }

    public static void editAlbum(ArrayList<Disk> Disks) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < Disks.size(); i++) {
            System.out.println(i + ") " + Disks.get(i));
        }

        System.out.print("Enter the number of the album you want to edit: ");
        int index = sc.nextInt();
        sc.nextLine(); // Clear line break

        if (index < 0 || index >= Disks.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        Disk disk = Disks.get(index);

        System.out.println("What do you want to edit?\n" +
                "1) Artist\n" +
                "2) Title\n" +
                "3) Year\n" +
                "4) Duration");

        String option = sc.nextLine();

        switch (option) {
            case "1":
                System.out.print("Enter the new artist name: ");
                disk.setArtist(sc.nextLine());
                break;
            case "2":
                System.out.print("Enter the new album title: ");
                disk.setTitle(sc.nextLine());
                break;
            case "3":
                System.out.print("Enter the new year: ");
                disk.setYear(sc.nextInt());
                sc.nextLine();
                break;
            case "4":
                System.out.print("Enter the new duration (MM.SS): ");
                String durationInput = sc.nextLine();
                disk.setDuration(Double.parseDouble(durationInput.replace(",", ".")));
                break;
            default:
                System.out.println("❌ Invalid option.");
                return;
        }

        System.out.println("✅ Album updated successfully: " + disk);
    }

    public static void removeAlbum(ArrayList<Disk> Disks) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < Disks.size(); i++) {
            System.out.println(i + ") " + Disks.get(i));
        }

        System.out.print("Enter the number of the album you want to remove: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index < 0 || index >= Disks.size()) {
            System.out.println("❌ Invalid index.");
            return;
        }

        System.out.print("Are you sure you want to delete this album? (y/n): ");
        String confirmation = sc.nextLine().toLowerCase();

        if (confirmation.equals("y")) {
            Disk removed = Disks.remove(index);
            System.out.println("✅ Album removed: " + removed);
        } else {
            System.out.println("❎ Deletion cancelled.");
        }
    }
}
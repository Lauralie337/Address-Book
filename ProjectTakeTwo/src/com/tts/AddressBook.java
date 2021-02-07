package com.tts;

import java.util.*;

public class AddressBook {
    //create ArrayList of generic type

    private static List<Entry> entryList = new ArrayList<>();

    // getter and setter for entryList
    public static List<Entry> getEntryList() {
        return entryList;
    }

    public static void setEntryList(List<Entry> entryList) {
        AddressBook.entryList = entryList;
    }

    // create input option tree
    public static void inputOptions() {
        System.out.println("""
                 Press the corresponding number key to execute\s
                 1 - add an entry to the book\s
                 2 - remove an entry from the book\s
                 3 - search for a specific entry\s
                 4 - print the contents of the book\s
                 5 - delete the entire address book\s
                 6 - exit the program
                """);
    }

    // create add method
    public static void addEntry(Entry entry) {

        boolean verifyUniqueness = entryList.stream().anyMatch(entryVerification -> entry.getEmail().equalsIgnoreCase(entry.getEmail()));

        if (verifyUniqueness) {
            System.out.println("This email address is taken, please try again with a unique email.\n");
        } else {
            entryList.add(entry);
            System.out.println("Added:\n" + entry);
        }
//        entryList.add(entry);
//        System.out.println("Added:\n" + entry);
    }

    //create delete method
    public static void delEntry(String email) {
        System.out.println("\nDeleting...");
        System.out.println(findEntry(email));
        entryList.removeIf(entry -> email.equals(entry.email));
        System.out.println("\n...Deleted.\n");
    }

    // create search method for list
    // thank you sawyer for this partial search method
    // I modified it so that it would accept partials in ANY case (upper || lower)
    public static void searchEntryList(List<Entry> entryList, String searchTerm) {
        List<Entry> found = new ArrayList<>();
        for(Entry entry : entryList) {
            if (entry.toString().toLowerCase(Locale.ROOT).contains(searchTerm)) {
                found.add(entry);
            }  else if (entry.toString().toUpperCase(Locale.ROOT).contains(searchTerm)) {
                found.add(entry);
            }else if (entry.toString().contains(searchTerm)) {
                found.add(entry);
            }
//            else if (found.toString().compareToIgnoreCase(searchTerm)) {
//                found.add(entry);
//            }
        }
        boolean existsLower = found.toString().toLowerCase(Locale.ROOT).contains(searchTerm);
        boolean existsUpper = found.toString().toUpperCase(Locale.ROOT).contains(searchTerm);
        boolean existsStandard = found.toString().contains(searchTerm);
        int existsProper = found.toString().compareToIgnoreCase(searchTerm);
        if (existsLower || existsUpper || existsStandard || existsProper == 0) {
            System.out.println(found);
        } else {
            System.out.println("We don't have any matches, check your spelling and maybe try again?");
        }
    }


    // create .clear() method to clear the whole book
    public static void listCleaner() {
        entryList.clear();
        System.out.println("The entry list has been emptied. Printing the updated entry list.");
        System.out.println(getEntryList());
    }


    // finder method:
    public static Entry findEntry(String email) {
        return entryList.stream()
                .filter(entry -> entry.getEmail().equals(email))
                .findFirst()
                .orElseThrow();
    }




    public static void deepBreathing() throws InterruptedException {

        Thread.sleep(250);
        System.out.println("Breathe in through your nose!");
        Thread.sleep(1000);
        System.out.println("One");
        Thread.sleep(1000);
        System.out.println("Two");
        Thread.sleep(1000);
        System.out.println("Three");
        Thread.sleep(1000);
        System.out.println("Now hold it!");
        Thread.sleep(1000);
        System.out.println("One");
        Thread.sleep(1000);
        System.out.println("Two");
        Thread.sleep(1000);
        System.out.println("Three");
        Thread.sleep(1000);
        System.out.println("Four");
        Thread.sleep(1000);
        System.out.println("Five");
        Thread.sleep(1000);
        System.out.println("Six");
        Thread.sleep(1000);
        System.out.println("Seven");
        Thread.sleep(250);
        System.out.println("And breathe out through your mouth!");
        Thread.sleep(1000);
        System.out.println("One");
        Thread.sleep(1000);
        System.out.println("Two");
        Thread.sleep(1000);
        System.out.println("Three");
        Thread.sleep(1000);
        System.out.println("Four");
        Thread.sleep(1000);
        System.out.println("Five");
        Thread.sleep(1000);
        System.out.println("Six");
        Thread.sleep(1000);
        System.out.println("Seven");
        Thread.sleep(1000);
        System.out.println("Eight");
        Thread.sleep(1000);
    }
}

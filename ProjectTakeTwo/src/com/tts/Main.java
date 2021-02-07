package com.tts;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        // write your code here
//        // starting scanner up top for this silly wanna stretch question
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Hi, how are you today?\s
                I hope that all is well in your world.\s
                \nScience has proven that a calmer mind is more efficient.\s
                So, would you mind if we take a quick breather before we get started?\s
                You can tell me yes or no without hurting my feelings!
                """);

        String reply = scan.nextLine();
        boolean stretch = (reply.equalsIgnoreCase("y")) || reply.equalsIgnoreCase("yes");
        if (stretch) {
            System.out.println("""
                    Then let's take a quick breather!\s
                    Follow after me!\s
                            """);
            AddressBook.deepBreathing();
            System.out.println("Okay, let's do that again.");
            AddressBook.deepBreathing();
            System.out.println("One last time!!");
            AddressBook.deepBreathing();
            Thread.sleep(1000);
            System.out.println("""
                    How does that feel?\s
                    I hope you feel as relaxed as I do!!\s
                    Now, then, let's get started!\s
                            """);
        } else {
            System.out.println("No worries, let's get right to work then!!");
            // *** BADLY NEED A TRY/CATCH BECAUSE TYPING CHARACTERS AT START WILL CRASH IT ***
            // done :)
        }


        boolean shallContinue = true;
        while (shallContinue) {
            // found that I needed to recall scan
            scan = new Scanner(System.in);
            AddressBook.inputOptions();
            try {
                int directory = scan.nextInt();
                switch (directory) {
                    case 1 -> { // adding
                        System.out.println("Option 1 - adding an entry");
                        System.out.println("Please provide the following information for your entry");
                        System.out.println("The first name of your entry: ");
                        String firstName = scan.next();
                        System.out.println("The last name of your entry: ");
                        String lastName = scan.next();
                        System.out.println("The email address of your entry: ");
                        String emailAddress = scan.next();
                        System.out.println("The phone number of your entry: ");
                        String phoneNumber = scan.next();
                        System.out.println("Preparing your entry...");

                        AddressBook.addEntry(new Entry(firstName, lastName, emailAddress, phoneNumber));
                    }

                    case 2 -> {
                        System.out.println("Option 2 - deleting an entry");
                        System.out.println("Please enter the unique email address that will be used to locate the entry to be deleted.");
                        String deleteMe = scan.next();
                        AddressBook.delEntry(deleteMe);
                    }
                    case 3 -> {
                        System.out.println("Option 3 - searching for a specific entry");
                        System.out.println("Please enter information such as a first or last name, an email address, or a phone number to help us find the correct entry");
                        String findMe = scan.next();
//                            AddressBook.findEntry(findMe);
                        AddressBook.searchEntryList(AddressBook.getEntryList() , findMe);

                    }
                    case 4 -> {
                        System.out.println("Option 4 - print the entire address book");
                        System.out.println(AddressBook.getEntryList());
                    }
                    case 5 -> {
                        System.out.println("Option 5 - clear the entire address book");
                        //maybe should still add an if-else to confirm
                        AddressBook.listCleaner();
                    }
                    case 6 -> {
                        System.out.println("Option 6 - quit the program");
                        System.out.println("See you next time! Bye!");
                        shallContinue = false;
                    }
                }
            } catch (InputMismatchException e){
                e.printStackTrace();
                System.out.println("WHAT DID YOU DO!?!?!?! YOU BROKE MY PROGRAM!!! I'M GONNA CALL MOM!\n \n Just kidding!!\n :)\n");
                System.out.println("This program gets really sad if you don't use number keys to navigate.");
                System.out.println("Try again only using number keys this time!!\n");
            }
        }
    }
}

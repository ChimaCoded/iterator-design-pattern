package com.company;

import com.company.classes.Channel;
import com.company.classes.ChannelCollectionImpl;
import com.company.enumerator.ChannelTypeEnum;
import com.company.interfaces.ChannelCollection;
import com.company.interfaces.ChannelIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//            create a scanner object
        Scanner remoteControl = new Scanner(System.in);
        ChannelCollection channels = null;
        do {
//            print tv menu
            printMenu();

//            get input from remote control.
            int userChoice = remoteControl.nextInt();

//            perform appropriate, action based on user input.
            switch (userChoice) {
                case 1:
                    channels = populateChannels();
                    break;
                case 2:
                    if (channels != null) {
                        ChannelIterator baseIterator = channels.iterator(ChannelTypeEnum.ALL);
                        while (baseIterator.hasNext()) {
                            Channel c = baseIterator.next();
                            System.out.println("|-----------------------------------------------|");
                            System.out.println(c.toString());
                        }
                        System.out.println("|-----------------------------------------------|\n");
                    } else {
                        systemAlert();
                    }
                    break;
                case 3:
                    if (channels != null) {
                        ChannelTypeEnum lang = filterPrompt();
                        // Channel Type Iterator
                        ChannelIterator englishIterator = channels.iterator(lang);
                        while (englishIterator.hasNext()) {
                            Channel c = englishIterator.next();
                            System.out.println("|-----------------------------------------------|");
                            System.out.println(c.toString());
                        }
                        System.out.println("|-----------------------------------------------|\n");
                    } else {
                        systemAlert();
                    }
                    break;

            }
        } while (true);
    }

    private static void printMenu(){
        System.out.println("+===================================================+");
        System.out.println("|           WELCOME TO TURNTABL SMART TV            |");
        System.out.println("+===================================================+");
        System.out.println("| Choose from the list of options                   |");
        System.out.println("| #1. Populate tv channels                          |");
        System.out.println("| #2. Display channel info                          |");
        System.out.println("| #3. Display filtered channel info                 |");
        System.out.println("+===================================================+");
    }

    private static ChannelTypeEnum filterPrompt(){
        System.out.println("+===================================================+");
        System.out.println("|        PLEASE CHOOSE ONE OF THE LANGUAGES         |");
        System.out.println("+===================================================+");
        System.out.println("| Choose from the list of options                   |");
        System.out.println("| #1. English                                       |");
        System.out.println("| #2. Hausa                                         |");
        System.out.println("| #3. French                                        |");
        System.out.println("+===================================================+");
        Scanner remoteControl = new Scanner(System.in);
        int userChoice = remoteControl.nextInt();
        switch (userChoice){
            case 1:
                return ChannelTypeEnum.ENGLISH;
            case 2:
                return ChannelTypeEnum.HINDI;
            case 3:
                return ChannelTypeEnum.FRENCH;
        }
        System.out.println("\nSorry can not recognise user input.");
        return ChannelTypeEnum.ALL;
    }

    private static void systemAlert(){
        System.out.println("+-----------------------------------------------+");
        System.out.println("|                   SYSTEM  ALERT               |");
        System.out.println("|-----------------------------------------------|");
        System.out.println("| Please, subscribe to turntabl channels to     |");
        System.out.println("| perform this operation                        |");
        System.out.println("+-----------------------------------------------+");
    }

    private static ChannelCollection populateChannels() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
        return channels;
    }

}

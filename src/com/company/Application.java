package com.company;

import java.util.Scanner;

public class Application {

    private ListLinked list = new ListLinked();

    public void run() {
        String num = userChoice();
        while (!num.equals("0")) {
            switch (num) {
                case "1":
                    addNewValue();
                    break;
                case "2":
                    removeValue();
                    break;
                case "3":
                    searchValue();
                    break;
            }
            num = userChoice();
        }
    }

    private void addNewValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Before value: ");
        String before = in.nextLine();
        System.out.print("New value: ");
        String value = in.nextLine();
        list.addBefore(before, value);
        list.showAllList();
    }

    private void removeValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Remove value: ");
        String removeValue = in.nextLine();
        list.removeLast(removeValue);
        list.showAllList();
    }

    private void searchValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Search value: ");
        String value = in.nextLine();
        if (list.searchText(value)) {
            System.out.println("Value is find!");
        } else {
            System.out.println("Value not found!");
        }
    }

    private String userChoice() {
        showMenu();
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private void showMenu() {
        System.out.println("-----------------");
        System.out.println("MENU:");
        System.out.println("-----------------");
        System.out.println("1. Insert before");
        System.out.println("2. Remove last");
        System.out.println("3. Search value");
        System.out.println("0. Exit");
        System.out.println("-----------------");
        System.out.print("YOU SELECT: ");
    }

}

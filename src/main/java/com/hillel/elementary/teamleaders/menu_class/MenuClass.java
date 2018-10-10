package com.hillel.elementary.teamleaders.menu_class;

import java.util.Scanner;

public class MenuClass {

    private String repeatKey;
    private int position;
    private int sizeOfMatrix;
    private Scanner scan = new Scanner(System.in);

    public MenuClass() {
        repeatKey = "";
        position = -1;
        sizeOfMatrix = -1;
    }

    public MenuClass(String key, int pos, int size) {
        repeatKey = key;
        position = pos;
        sizeOfMatrix = size;
    }

    private void setRepeatKey() {
        this.repeatKey = scan.nextLine();
    }

    private void setPosition() {
        this.position = scan.nextInt();
    }
    public int getPosition() {
        return this.position;
    }

    private void setSizeOfMatrix() {
        this.sizeOfMatrix = scan.nextInt();
    }
    public int getSizeOfMatrix() {
        return this.sizeOfMatrix;
    }

    boolean repeatFunk(String choose1, String choose2, String title) {
        System.out.println(title);
        setRepeatKey();
        if (!(this.repeatKey.equalsIgnoreCase(choose1) || this.repeatKey.equalsIgnoreCase(choose2))) {
            repeatFunk(choose1, choose2, "");
        }
        return this.repeatKey.equalsIgnoreCase(choose2);
    }

    public boolean sizeAndPositionMenu() {
        System.out.println("Please, print size of matrix:");
        setSizeOfMatrix();
        if (this.sizeOfMatrix <= 0) {
            System.out.println("Wrong size!");
            return true;
        }
        System.out.println("Please, print position:");
        setPosition();
        this.position--;
        if (this.position >= this.sizeOfMatrix || this.position < 0) {
            System.out.println("Wrong position!");
            return true;
        }
        return false;
    }

}
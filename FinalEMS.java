package com.mycompany.finalems;

public class FinalEMS {

    public static void main(String[] args) {
        HomeScreen theScreen = new HomeScreen();
        theScreen.setVisible(true);
        
        MyHashTable masterHashTable = new MyHashTable(10);
        theScreen.setMastHashTable(masterHashTable);
        
    }
}

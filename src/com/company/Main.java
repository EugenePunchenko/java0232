package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Item{

    private String key;

    public Item(String key)
    {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
 class HashTable {

    //массив для хранения элементов
    private Item[] table;
    //количество элементов в таблице
    private int count;
    //размер таблицы
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }
     private int hash(String key)
     {
         int hash = 0;

         for(int i = 0; i < key.length(); i++)
             hash = (31 * hash + key.charAt(i)) % size;

         return hash;
     }
     public void insert(String key)
     {
         Item item = new Item(key);
         int hash = hash(key);
         while(table[hash] != null)
         {
             hash++;
             hash %= size;
         }
         table[hash] = item;
     }
     public void print()
     {
         for(int i = 0; i < size; i++)
             if(table[i] != null)
                 System.out.println(i + " " + table[i].getKey());
     }
     public Item find(String key)
     {
         int hash = hash(key);
         while(table[hash] != null)
         {
             if(table[hash].getKey().equals(key))
                 return table[hash];
             hash++;
             hash = hash % size;
         }

         return null;
     }

}
public class Main {



    public static void main(String[] args) {

        HashTable hashTable = new HashTable(97);

        hashTable.insert("rhino");
        hashTable.insert("man");
        hashTable.insert("computer");
        hashTable.insert("home");
        hashTable.insert("basket");
        Item item = hashTable.find("ban");

        if(item != null)
            System.out.println("Элемент найден!");
        else
            System.out.println("Элемент не найден!");
        hashTable.print();

    }
}

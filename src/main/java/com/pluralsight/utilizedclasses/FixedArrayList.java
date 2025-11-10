package com.pluralsight.utilizedclasses;

import java.util.ArrayList;
import java.util.List;

// class is generic and accepts any type T of Objects
public class FixedArrayList<T> {

    // private fields, one limiting size of the other
    private final int maxSize;
    private final ArrayList<T> items;

    // constructor taking in only maxSize, and then initializes new empty ArrayList
    public FixedArrayList(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<T>();
    }

    // method to add any type item T to FixedList
    public void add(T item) {
        // since add can only accept one parameter at a time, check if the FixedList is at maxSize
        if (items.size() == maxSize) {
            // if yes, throw newly defined IllegalArgumentException
            throw new IllegalArgumentException("Cannot add item: FixedList is already full.");
        } else {
            // otherwise, add the item to the ArrayList
            items.add(item);
        }
    }

    // getter for ArrayList
    public List<T> getItems() {
        return items;
    }


}

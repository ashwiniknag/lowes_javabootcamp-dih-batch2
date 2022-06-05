package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemp {
    public static void main(String[] args) {
        // collection->list->
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        //display
        for (Object obj : linkedList) {
            System.out.println(obj);

        }

        //update
        linkedList.set(2, 100);
        System.out.println("After updation");
        for (Object obj : linkedList) {
            System.out.println(obj);

        }
        //remove
        linkedList.remove(2);
        System.out.println("After removal");
        for (Object obj : linkedList) {
            System.out.println(obj);

        }

        //iterator
        System.out.println("print using iterator");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}

package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        // collection->list->
        ArrayList arrayList =new ArrayList();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        //display
        for (Object obj: arrayList)
              {
                  System.out.println(obj);
            
        }

        //update
        arrayList.set(2,100);
        System.out.println("After updation");
        for (Object obj: arrayList)
        {
            System.out.println(obj);

        }
        //remove
        arrayList.remove(2);
        System.out.println("After removal");
        for (Object obj: arrayList)
        {
            System.out.println(obj);

        }

        //iterator
        System.out.println("print using iterator");
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    //arraylist of integer type
        ArrayList<Integer> arrayList1 =new ArrayList<>();
        arrayList1.add(101);
        arrayList1.add(201);
        arrayList1.add(301);

        //display
        for(Integer item : arrayList1)
        {
            System.out.println(item);

        }

        //update
        arrayList1.set(2,100);
        System.out.println("After updation");
        for (Integer item : arrayList1)
        {
            System.out.println(item);

        }
        //remove
        arrayList1.remove(2);
        System.out.println("After removal");
        for(Integer item : arrayList1)
        {
            System.out.println(item);

            System.out.println("print using iterator");
            Iterator<Integer> iterator1 = arrayList.iterator();
            while(iterator1.hasNext()){
                System.out.println(iterator1.next());
            }

        }
    }

}

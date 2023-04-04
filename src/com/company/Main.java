package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         CustomList<String> test1 = new CustomList<>();
         test1.addFirst("1");
         test1.addLast("2");
         System.out.println(test1.getFirst()+" "+ test1.getLast());

         List<String> test2 = new CustomList<>();
         test2.add("Test1");
         test2.add("Test2");

         for(String element : test2) {
             System.out.println(element);
         }

    }

}
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

         String test3 = "";
         Double test4 = 2.0;

         class X {

         }
         class Y extends X {

         }

          List<Object> list = new ArrayList<>();
          list.add("213");
          list.add(123);
          list.add(215);
          list.add(512);
          list.add(21515L);
          list.add(new X());
          list.add(new Y());
          findSameType(list, X.class).forEach(System.out::println);

    }

    // List<?> findSameType(dasds, List.class)
    static <T> List<T> findSameType(List<T> elements, Class<?> clazz) {
         List<T> list = new ArrayList<>();
         for (T element : elements) {
              if (clazz.isAssignableFrom(element.getClass())) {
                   list.add(element);
              }
//              if(element.getClass().equals(clazz)) {
//                   list.add(element);
//              }
         }
         return list;
    }
}
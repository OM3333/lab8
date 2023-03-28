package com.company;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
     
=======
        try {
            ArrayList<String> paths = new ArrayList<>();
            paths.add("test/test_rodzice/p1.txt");
            paths.add("test/test_rodzice/p2.txt");
            paths.add("test/test_rodzice/p3.txt");
            paths.add("test/test_rodzice/p4.txt");
            paths.add("test/test_rodzice/p5.txt");
            paths.add("test/test_rodzice/p6.txt");
            paths.add("test/test_rodzice/p7.txt");
            paths.add("test/test_rodzice/p8.txt");
            paths.add("test/test_rodzice/p9.txt");
            paths.add("test/test_rodzice/p10.txt");
            paths.add("test/test_rodzice/p11.txt");
            List<Person> people = Person.getPeople(paths);
            for (Person person : people) {
                System.out.println(person);
            }
        } catch (FileNotFoundException | IncestException e) {
            e.printStackTrace();
        } catch (AmbigiousPersonException e) {
            System.out.println(e.conflictPath1);
            System.out.println(e.conflictPath2);
        }
>>>>>>> 3c6375800a58a7d7fa304e6499b6c5ffdabb3fca
    }
}
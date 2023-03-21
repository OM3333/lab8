package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private LocalDate birth, death;
    private Person parents[] = new Person[2];

    public Person(String name, LocalDate birth) {
        this(name, birth, null);
    }

    public Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
        try {
            if (birth.isAfter(death)) {
                throw new NegativeLifespanException(birth, death, "Possible time-space loophole.");
            }
        } catch (NullPointerException e) {}
    }

    public Person(String name, LocalDate birth, LocalDate death, Person parent1, Person parent2) throws IncestException {
        this(name, birth, death);
        parents[0] = parent1;
        parents[1] = parent2;

        checkForIncest();
    }

    public Person(String name, LocalDate birth, Person parent1, Person parent2) throws IncestException {
        this(name, birth, null, parent1, parent2);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }

    void checkForIncest() throws IncestException {
        if(parents[0] == null || parents[1] == null)
            return;
        for(var leftSideParent : parents[0].parents) {
            if (leftSideParent == null) continue;
            for (var rightSideParent : parents[1].parents) {
                if (rightSideParent == null) continue;
                if (leftSideParent == rightSideParent)
                    throw new IncestException(leftSideParent, this);
            }
        }
    }

    static List<TemporaryPerson> people = new ArrayList<>();

    public static Person getPersonFromFile(String path) throws FileNotFoundException,AmbigiousPersonException {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            String nameAndLastName = sc.nextLine();
            LocalDate birthdayDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate deathDate = null;
            if(sc.hasNextLine()){
                deathDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            }
            for(var person : people){
                if(person.name.compareTo(nameAndLastName)==0){
                    throw new AmbigiousPersonException(person.name,path,person.path);
                }
            }
            people.add(new TemporaryPerson(nameAndLastName,path));
            return new Person(nameAndLastName, birthdayDate, deathDate);
    }
}
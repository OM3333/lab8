package com.company;

public class AmbigiousPersonException extends Exception {
    public AmbigiousPersonException(String nameAndLastName) {
        super(nameAndLastName);
    }
}

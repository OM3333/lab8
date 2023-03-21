package com.company;

public class AmbigiousPersonException extends Exception {
    public String conflictPath1;
    public String conflictPath2;
    public AmbigiousPersonException(String nameAndLastName,String path1, String path2) {
        super(nameAndLastName);
        this.conflictPath1=path1;
        this.conflictPath2=path2;
    }
}

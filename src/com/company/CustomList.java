package com.company;

import java.util.NoSuchElementException;

public class CustomList <T> {
    private class Node{
        T value;
        Node next;
    }
    private Node first = null;
    private Node last = null;
    public void addLast(T value){
        Node node = new Node();
        node.next=null;
        node.value=value;
        if(first==null){
            first = node;
            last = node;
        }
        else{
            last.next=node;
            last = node;
        }
    }
    public T getLast(){
        if(last==null){
            throw new NoSuchElementException();
        }
        return last.value;
    }
    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        node.next=null;
        if(first==null){
            first=node;
            last=node;
        }
        else{
            node.next=first;
            first=node;
        }
    }
    public T getFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        return first.value;
    }
    public T removeFirst(){
        if(first==null){
            throw new NoSuchElementException();
        }
        T oldFirstElement =  getFirst();
        if(first == last){
            first = null;
            last = null;
        }else {
            first = first.next;
        }
        return oldFirstElement;
    }
    public T removeLast(){
        if(last == null){
            throw new NoSuchElementException();
        }
        T oldLastElement = getLast();
        if(first == last){
            first = null;
            last = null;
        }else{
            Node ourElement = first;
            while (ourElement.next!=last){
                ourElement = ourElement.next;
            }
            ourElement.next = null;
            last = ourElement;
        }
        return oldLastElement;
    }
}

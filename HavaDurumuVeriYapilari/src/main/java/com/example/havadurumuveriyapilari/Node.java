package com.example.havadurumuveriyapilari;

import java.util.LinkedList;

public class Node {

    public LinkedList<String> data;
    public Node next;

    public Node(LinkedList<String> data) {
        this.data = data;
        this.next = null;
    }
}

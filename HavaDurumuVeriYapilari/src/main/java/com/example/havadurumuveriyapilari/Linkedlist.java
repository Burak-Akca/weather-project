/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.havadurumuveriyapilari;

/**
 *
 * @author merve
 */
public class Linkedlist {
    NodeLinkedList head;

    public Linkedlist() {
        this.head = null;
    }

    // Listenin sonuna eleman ekleme
    public void add(String data) {
        NodeLinkedList newNode = new NodeLinkedList(data);
        if (head == null) {
            head = newNode;
        } else {
            NodeLinkedList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Listenin elemanlarını ekrana yazdırma
    public void display() {
        NodeLinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public String get(int index) {
        if (head == null || index < 0) {
            return null;
        }
        NodeLinkedList temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }
    
}
       
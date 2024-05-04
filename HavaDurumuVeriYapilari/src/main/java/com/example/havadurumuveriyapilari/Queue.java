package com.example.havadurumuveriyapilari;

import java.util.LinkedList;

public class Queue {


    Node front = null;
int sayac=0;
    Node rear = null;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(LinkedList<String> data){sayac++;

        Node newNode = new Node(data);

        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public LinkedList<String> dequeue(){
        Node deletedValue=null;
        if(front == null){
            System.out.println("Queue is empty");
        }

        else {
            deletedValue=front;
            front = front.next;
        }

        return deletedValue.data;
    }

    public void print(){

        if(front == null){
            System.out.println("Queue is empty");
        }
        else {
            System.out.print("front");
            Node temp = front;
            while (temp != null){
                System.out.print(" ->"+temp.data);
                temp = temp.next;
            }
            System.out.println(" ->rear");
        }

    }


}
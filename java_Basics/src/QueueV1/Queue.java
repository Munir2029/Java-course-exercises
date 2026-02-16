package QueueV1;

import stackV1.Element;
import stackV1.Stack;

import java.util.Arrays;


public class Queue {

    Element back;
    Element front;
    int size;

    public Queue() {
        front = null;
        back = null;
        size = 0;
    }

    public void enqueue(int value) {

        Element neu = new Element(value);
        if (front == null) {
            front = neu;
            back=neu;
        } else {
            back.next = neu;
            back = neu;
        }
        size++;
    }

    public int size() {

        return size;
    }

    public int dequeue() {
        if (size > 0) {
            int temp = front.value;
            front = front.next;
            size--;
            return temp;
        } else {
            return -1;
        }

    }

    public int[] dequeue(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = dequeue();
        }
        return arr;
    }


    public String toString() {
        String returner = " ";
        Element print = front;
        while (print != null) {
            returner += " " + print.value;
            print = print.next;
        }
        return returner;
    }


}

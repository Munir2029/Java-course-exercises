package stackV1;

import java.util.ArrayList;

public class Stack {
    Element top;
    int size;


    public Stack() {
        top = null;
        size = 0;
    }

//لأضافة لارقم جديد او عنصر جديد
    public void push(int value) {
        Element neu = new Element(value);

        if (top == null) {         //هذا يعني ان ال stack فارغ
            top = neu;             // هنا نضيف العنصر الجديدال الستاك ويصبح هو التوب
        } else {
            //اذا لم يكن الستاك فارغ
            //  ضع في المكان الفارغ الخاص ب Element ال  top لكي يفضى مكان للعنصر الجديد
            neu.next = top;
            top = neu;              //عندما يفرغ مكان وقتها نضع العنصر الجديد في ال top
        }
        size++;
    }

    public int size() {
        return size;
    }
//ازالة العنصر العلوي top من ال stack وارجاع قيمته
    public int pop() {
        if (size > 0) {
            Element temp = top;
            top = top.next;
            size--;
            return temp.value;
        } else {
            return -1;
        }
    }


    //تستخدم لرؤية قيمة العنصر العلوي بدون ازالته

    public int peek() {
        if (size == 0) {
            return -1;
        }

        return top.value;
    }


    public int[] pop(int n){
        if (n >= 0 && n <= size) {
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = pop();
            }

            return arr;
        }
        else {
            return null;
        }
    }




    public String toString(){
        String returner =" ";

        Element print= top;

        while (print!=null){
            returner +=" "+print.value;
            print=print.next;
        }
        return returner;
    }

}




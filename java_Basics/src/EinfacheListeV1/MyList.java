package EinfacheListeV1;

public class MyList {
    public Element head;
    Element tail;
    int size;


    public MyList() {
        this.size = 0;
        this.head = null;
    }

    public void add(int zahl) {
        Element neu = new Element(zahl);
        if (head == null) {
            head = neu;
            tail = neu;
        } else {
            Element temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = neu;
        }

        size++;
    }

    public boolean add(int index, int zahl) {
        if (index >= 0 && index < size) {
            Element neu = new Element(zahl);
            if (head == null && index == 0) {
                head = neu;
                return true;
            } else {
                Element temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                neu.next = temp.next;
                temp.next = neu;
                return true;
            }

        }
        return false;
    }

    int size() {
        return size;
    }

    public int get(int index) {

        if (index <= size) {
            Element temp = head;
            if (index == 0) {
                System.out.println("index value= " + temp.value);
                return temp.value;

            } else {
                for (int i = 0; i < index; i++) {

                    temp = temp.next;
                }
                System.out.println("index value= " + temp.value);
                return temp.value;

            }
        }
        System.out.println("diese index nicht verfügber");
        return -1;

    }

    public int remove(int index) {
        if (index <= size && head != null) {

            if (index == 0) {
                int removeHead = head.value;
                head = head.next;
                return removeHead;
            } else {

                Element temp = head;

                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                int x = temp.next.value;
                temp.next = temp.next.next;
                return x;
            }
        } else {
            System.out.println("diese index nicht verfügber");
            return -1;
        }
    }

    public void sort() {
        if (head.next != null) {

            Element temp = head;
            for (int i = 0; i < size - 1; i++) {


                if (temp.value > temp.next.value) {
                    int x = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = x;

                    //System.out.println(head);

                    temp = head;
                    i = -1;
                }
                else {
                    temp = temp.next;
                }


            }
        }
    }


    public String toString() {
        String result = "";
        Element temp = head;
        while (temp != null) {

            result += temp + " ";
            temp = temp.next;

        }


        return result;
    }


}
package DoppeltVerketteListeV1;

public class MyList {
    Element head;
    Element tail;
    int size;


    public MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void add(int zahl) {
        Element neu = new Element(zahl);

        if (tail == null) {
            tail = neu;
            head = neu;


        } else {
            tail.next = neu;
            neu.last = tail;
            tail = neu;

        }
        size++;
    }


    public boolean add(int index, int zahl) {
        if (index >= 0 && index <= size) {
            Element neu = new Element(zahl);
            if (head == null) {
                head = neu;
                tail = neu;
                return true;
            } else {
                if (index == 0) {
                    neu.next = head;
                    head.last = neu;
                    head = neu;
                } else if (index == size) {
                    neu.last = tail;
                    tail.next = neu;
                    tail = neu;
                } else if (index < size / 2) {
                    // von links suchen
                    Element temp = head;
                    for (int i = 0; i < index - 1; i++) {
                        temp = temp.next;
                    }
                    neu.next = temp.next;
                    temp.next.last = neu;
                    neu.last = temp;
                    temp.next = neu;
                    size++;
                } else {//       index>size/2
                    // von rechts suchen
                    Element tempTail = tail;
                    for (int i = 0; i < size - index; i++) {
                        tempTail = tail.last;
                    }
                    neu.next = tempTail;
                    tempTail.last.next = neu;
                    neu.last = tempTail.last;
                    tempTail.last = neu;

                    size++;


                }
                return true;
            }

        }
        return false;
    }


    public int size() {
        return size;
    }

    public int get(int index) {
        Element temp = head;
        if (index <= size && index >= 0) {
            if (index == 0) {
                System.out.println("index value = " + temp.value);
                return temp.value;
            }

            for (int i = 0; i < index; i++) {
                temp = temp.next;


            }
            System.out.println("index value = " + temp.value);
            return temp.value;


        } else {
            System.out.println("ungültiger index number");
        }

        return index;
    }

    public int remove(int index) {

        if (head != null && index < size) {
            if (index == 0) {
                int removeHead = head.value;
                head = head.next;
                head.next.last = null;
                return removeHead;

            } else if (index + 1 == size) {

                //letzt index
                Element temptail=tail;
                int removeTail = tail.value;
              temptail=temptail.last;
              temptail.next=null;
                return removeTail;
            } else if (index < size / 2) {
                // remove von links
                Element temp = head;
                for (int i = 0; i < index - 1; i++) {

                    temp = temp.next;

                }
                int dasgelöschteIndexValue = temp.next.value;

                temp.next = temp.next.next;
                temp.next.last = temp;


                return dasgelöschteIndexValue;
            } else { // remove von rechts
                Element tempTail = tail;
                for (int i = 0; i < index - size; i++) {
                    tempTail = tempTail.last;

                }
                int dasgelöschteIndexValue = tempTail.last.value;
                tempTail.last = tempTail.last.last;
                tempTail.last.next = tempTail;
                return dasgelöschteIndexValue;

            }

        }

        System.out.println("diese index nicht verfügber");
        return -1;
    }

    public void sort() {
        if (head != null) {
            Element temp = head;
            for (int i = 0; i < size - 1; i++) {
                if (temp.value > temp.next.value) {
                    int x = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = x;

                    temp = head;
                    i = -1;
                } else {
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




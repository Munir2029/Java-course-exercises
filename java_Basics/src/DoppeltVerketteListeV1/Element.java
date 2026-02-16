package DoppeltVerketteListeV1;

public class Element {
    int value;
    Element next;
    Element last;


    public Element(int value) {
        this.value = value;
        this.next = null;
        this.last = null;

    }



   public String toString() {
        String result= "[" + this.value + "]";

        return result;
    }

}
package EinfacheListeV1;

public class Element {
    public int value;
    public Element next;


    public Element(int value) {
        this.value = value;
        this.next = null;

    }


    public String toString() {
        String result = "[" + this.value + "]";
//        Element temp = ;
//        while ( temp!= null) {
//
//            result += temp.value + " ";
//            temp = temp.next;
//
//        }

        return result;
    }

}
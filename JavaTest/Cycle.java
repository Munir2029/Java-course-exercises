package JavaTest;

public class Cycle {

    Step first;

    int size;
    boolean isCycle;


    public Cycle() {
        this.first = null;

        this.size = 0;
        this.isCycle = false;

    }


    public void addStep(String nextSchrittText) {
        Step nextSchritt = new Step(nextSchrittText);


        if (size == 0) {
            first = nextSchritt;
        } else {
            Step temp = first;

            while (temp.next != null) {
                if (temp.value.equals(nextSchrittText)){
//                 Step copy=temp;
                    isCycle=true;
                }
                temp = temp.next;
            }
            temp.next = nextSchritt;
        }
        size++;


    }
}




package lootov1Wiederholong;

public class LottoSchein {
    static int counter;
    int nr;


    public LottoSchein(){
        counter++;
        this.nr= counter;

    }


    public String toString(){

        return "Lotooschein nr " + nr +" ";
    }
}

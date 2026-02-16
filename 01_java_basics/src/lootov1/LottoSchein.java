package lootov1;

public class LottoSchein {
    static int counter = 0;        //static heißt jedes veränderung gelt für alle
                                   // lotto scheine
    int nr;

    //das ist Konstrukter
    public LottoSchein() {
        counter++;
        this.nr = counter;
    }

    public String toString(){
        return "[Lottoschein"+ nr +"]";
    }
}

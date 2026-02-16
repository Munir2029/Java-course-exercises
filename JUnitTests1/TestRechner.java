package JUnitTests1;

import DateizugriffeV1.Dateizugriffe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static WörterbuchV1.worterbuchOrginal.add2all;
import static org.junit.jupiter.api.Assertions.*;

public class TestRechner {

    @Test
    @DisplayName("blubb")
    public void testDivision() {
        Rechner r=new Rechner();
        assertEquals(4,r.division(8,2));
        assertEquals(-1,r.division(5,0));
    }
//    @Test
//    @DisplayName("bil")
//    public void isTheRightName(){
//        Rechner r=new Rechner();
//        assertEquals(true,r.isTheRightName("munir"));
//        assertEquals(false,r.isTheRightName("Nico"));
//
//    }
    @Test
    @DisplayName("MohsenMetode")
    public void einfachNameOhneZahlOderZichen(){
        Rechner r=new Rechner();
        assertEquals(true,r.einfachNameOhneZahlOderZichen("munir"));
        assertEquals(false,r.einfachNameOhneZahlOderZichen("Nico1"));

    }

//    @Test
//    public void testWörterbuch() {
//
//        File file = new File("allWords");
//        List<String> lines = Dateizugriffe.readFileLineByLine("C://Users//Codersbay//IdeaProjects//itOrietirung1//src//WörterbuchV1//allWords");
//
//        for (String line : lines) {
//            String[] word;
//            line = line.replaceAll(";", ", ");
//
//            word = line.split(",");
//
//            add2all(word[0], word[1]);
//        }
//
//        assertEquals(" ball is", WörterbuchV1.worterbuchOrginal.translateDeEn("Ball ist"));
//    }

//    @Test
//    @DisplayName("muhseUndMunir erste")
//    public void einfachNameOhneZahlOderZichen(){
//
//        Rechner r=new Rechner();
//        assertEquals(true,"dsfgdsgfdsgfds");
//        assertEquals(false,"Mu3ni!r");
//        assertEquals(false,"Mu3n i!r");
//
//
//    }
//

}

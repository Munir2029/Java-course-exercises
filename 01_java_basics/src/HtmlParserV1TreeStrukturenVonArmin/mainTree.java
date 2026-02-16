package HtmlParserV1TreeStrukturenVonArmin;

public class mainTree{
    public static void main(String[] args) {

        Node n1 =new Node(null,"root");
        Node n2=new Node(n1,"head");
        Node n3=new Node(n1,"body");
        Node n4 =new Node(n3,"h1");
        String text="<html><head></head><body><h1></h1></body><html>";
        Node parsed=new HtmlParser().parse(n3,"dslkjf");
        System.out.println(parsed);
    }
}

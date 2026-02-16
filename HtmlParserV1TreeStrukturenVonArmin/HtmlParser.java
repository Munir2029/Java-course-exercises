package HtmlParserV1TreeStrukturenVonArmin;

public class HtmlParser {
    Node root = new Node(null, "root");

    public Node parse(Node parent, String text) {
        return parseRec(root, text);
    }

    public Node parseRec(Node parent, String text) {
        if (text.length() == 0) {
            return root;
        }

        System.out.println("parent: " + parent.tag);

        //suche tag name              komment  (mohsen)

        int start = text.indexOf("<");                  //?????
        int end = text.indexOf(">");                        //?????
        String tag = text.substring(start + 1, end);                //?????
        System.out.println(tag);                           //?????


        //   tag von text abziehen                             komment  (mohsen)

        text = text.substring(end + 1);

        // schau ob tag "/" am anfang hat

        if (tag.charAt(0) != '/') {

            System.out.println("öffnen!");
            // mache neuen Node
            Node neu = new Node(parent, tag);
            parseRec(neu, text);
        } else {
            System.out.println("schließen!");
            parseRec(parent.parent, text);

        }

        return root;
    }
}






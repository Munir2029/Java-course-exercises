package HtmlParserV1TreeStrukturenVonAdel;

public class TreeMain {
    public static void main(String[] args) {
        String txt = "<html><head></head>" +
                "<body><h1></h1></body></html>";
        String txt1 = "<html><head></head><body><h1></h1><h1></h1><h1></h1><h1></h1></body></html>";
        //Creating a new tree Node and adding the parse method.
        //can also be done like "root.parse(text)"
        TreeParser parser = new TreeParser();
        TreeNode root = parser.parse(txt);

//        TreeNode root1 = parser.parse(txt1);

        System.out.println(root);
//        System.out.println("-----------------");
//        System.out.println(root1);
    }
}
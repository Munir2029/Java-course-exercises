package HtmlParserV1TreeStrukturenVonAdel;

public class TreeParser {

    TreeNode root;

    public TreeParser() {
        // existiert automatisch auch wenn wir ihn nicht schreiben, nur macht er dann nix
    }

    public TreeNode parse(String text) {
        root = new TreeNode(null, "root");
        return parseRec(root, text); //recursion method. if the parse method is called, it automatically calls the parseRec
    }

    public TreeNode parseRec(TreeNode current, String text) {

        if (text.length() <= 0) { //if the length of our text is less than 0, just return the root at "root"
            return root;
        }

        int start = text.indexOf('<'); //If it begins with "<"
        int end = text.indexOf('>'); //If it ends with ">"

        String tag = text.substring(start + 1, end); // the start includes the first value but end excludes it.
        //start + 1 because we do not want the < to be actually printed

        System.out.println(tag);

        text = text.substring(end + 1); //adding plus 1 to end so we know the closing or ending tags when printing remaining text
        System.out.println("REST: " + text);

        if (tag.charAt(0) == '/') {
            // closing tag
            parseRec(current.parent, text); //If the closing tag is "/", connect it to the current parent...
            //if the next value still has a closing tag, it will connect to the current--parents--parent and so on till it gets to the root.
        }
        else {
            // opening tag
            TreeNode neu = new TreeNode(current, tag); //if it's an opening tag, create a new child and add its tag
            parseRec(neu, text); //connect the child to its current parent
        }

        return root; // return the Tree Node
    }

}
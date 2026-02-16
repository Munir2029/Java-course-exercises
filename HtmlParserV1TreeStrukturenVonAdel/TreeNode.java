package HtmlParserV1TreeStrukturenVonAdel;

import java.util.ArrayList;

public class TreeNode {

    String tag;
    TreeNode parent;
    ArrayList<TreeNode> children;

    public TreeNode(TreeNode parent, String tag) {
        this.tag = tag; // assign value
        this.parent = parent; // connect this to parent
        this.children = new ArrayList<>(); // allow this node to have children

        if (this.parent != null) { // if parent exists
            this.parent.children.add(this); // add this as a new child to parent's children list

        } /*else {
            TreeNode root = new TreeNode(null, "root");
        }*/
    }

    public String toString() {
        printing(this, 0);
        return "";
    }

    public String printing(TreeNode current, int depth) { //depth is like a counter
        System.out.println("-".repeat(depth) + current.tag); // using ".repeat(depth)" to repeat the "-" as per the depth
        //current tag is the value of the current element in the string. beginning from the root and moving to the child/parent if its no more empty

        if (!current.children.isEmpty()) { //if the size of the arraylist is not 0(Not empty)...
            for (int i = 0; i < current.children.size(); i++) { // for "i" is less than the size of the Arraylist, starting from 0
                printing(current.children.get(i), depth + 1); // print the parents child at the value "i"
            }
        }
        return current.tag; //Returning the value of the current child or Parent
    }
}
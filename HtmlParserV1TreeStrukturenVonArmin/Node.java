package HtmlParserV1TreeStrukturenVonArmin;

import java.util.ArrayList;

public class Node {

    String tag;//
    Node parent;

    ArrayList<Node> children;


    public Node(Node parent,String tag) {
        this.tag = tag;
        this.parent=parent;
        this.children = new ArrayList<>();


        if(parent!=null){
            this.parent.children.add(this);       //???????????
        }


    }
    public  String tostring(){
        String ret="";
        ret += printRec(this,0);
        return ret;
    }

    public String printRec(Node parent, int depth){
        String returner="\n";
        returner +="-".repeat(2 * depth) + parent.tag;
        if (parent.children.size()==0) {

        }

            for (int k=0;k<parent.children.size();k++){
                returner+=printRec(parent.children.get(k),depth+1);
            }
            return returner;
        }
    }





package JavaTest;

public class Main {
    public static void main(String[] args) {
       Cycle s=new Cycle();


//        System.out.println(s.isCycle);
//        System.out.println(s.size);





        s.addStep("1"); //1
        System.out.println(s.size);
        s.addStep("2");
        System.out.println(s.isCycle);
        s.addStep("3");
        System.out.println(s.isCycle);
        s.addStep("2");
        System.out.println(s.isCycle);


    }
}

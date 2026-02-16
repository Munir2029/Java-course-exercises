public class CleanThisOriginal {
    public static void main(String[] args) {
        int age = 3;
        boolean withAdult = true;
        boolean vip = false;
        boolean approved=true;
        if (age >= 18) {
            System.out.println("Grünes Band");
        } else if (age >= 16 ) {
            System.out.println("Gelbes Band");
        } else if (age >= 4 && withAdult) {
            System.out.println("rotes Armband");
        } else {
            System.out.println("kein Zutritt");
            approved=false;
        }
        if (approved && vip) {
            System.out.println("Goldenes Band dazu!");
        } else  if (approved && !vip) {
            System.out.println("Kein goldenes Band dazu!");
        }
    }
}
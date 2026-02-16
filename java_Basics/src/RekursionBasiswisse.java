public class RekursionBasiswisse {
    public static void nextStep(int v0, int t) {
        double h = v0 * t * 0.1 - 9.81 * t * t * 0.01;
        if (h >= 0) {
            System.out.println(String.valueOf(h));
            nextStep(v0, t + 1);
        } else {
            System.out.println("die Rakte ist am boden");
            return;
        }

    }


    public static void main(String[] args) {

      nextStep(60,0);

    }
}

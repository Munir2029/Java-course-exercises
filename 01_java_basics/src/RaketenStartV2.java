public class RaketenStartV2 {


    public static double maxHeight(int v0, int t, double maxH) {

        double h = v0 * t * 0.1 - 9.81 * t * t * 0.01;
        if (h >= 0 && h >= maxH) {
            System.out.println(String.valueOf(h));
            maxH = h;

        } else {
            System.out.println("die maximalhöhe: " + maxH);
            return maxH;
        }


        return maxHeight(v0, t + 1, maxH);
    }

    public static void main(String[] args) {
        RaketenStartV2.maxHeight(30, 0, 0);

    }
}





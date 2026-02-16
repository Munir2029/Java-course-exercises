import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MineSweeperV1 {
    public static void main(String[] args) {

        int[][] map = new int[10][10];
        Random r = new Random();
        int mineCount = 0;



         

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.println(map[i][j]);
                        map[i][j] = r.nextInt(0, 4);
                if (map[i][j] == 0) {
                    mineCount++;
                }
            }


        }


        System.out.println(map);
        System.out.println("mineCount = " + mineCount);
    }
}

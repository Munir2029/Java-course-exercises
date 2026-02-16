public class ZeichneMirEinHausV2 {


    public static void drawLine(char symbol, int offset, int length) {
        for (int i = 0; i < offset; i++) {
            System.out.print(" ");
        }
        char[] arry = new char[length];
        for (int i = 0; i < arry.length; i++) {
            System.out.print(symbol);

        }
        System.out.println();

    }

    public static void drawTriangle(char symbol, int offset, int height, int growth) {
        int length = 1;


        if (height > 1) {

            for (int j = 0; j < height - 1; j++) {
                drawLine(symbol, offset, length);

                offset -= growth;
                length += growth * 2;

            }

            //drawTriangle(symbol, offset, height - 1, growth);
        }
    }

    public static void drawTemple(char symbol, int offset, int height, int growth) {
        drawTriangle(symbol, offset, height, growth);
        if (height > 2) {
            drawTemple(symbol, offset, height - 1, growth);
        }
    }


    public static void main(String[] args) {
        drawTemple('x', 20, 6, 2);
    }
}

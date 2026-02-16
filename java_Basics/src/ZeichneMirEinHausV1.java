public class ZeichneMirEinHausV1 {
    public static void main(String[] args) {
        drawTriangle('*',44,5,2);
        drawRectangle('#', 35, 19, 6);
        drawLine('=', 30, 30);



    }

                                          //*        //3       //4        //1
    public static void drawTriangle(char symbol, int offset, int height, int growth) {


        int length = 1;

        for (int j = 0; j < height-1; j++) {

            /*for (int i = 0; i < offset; i++) {
                System.out.print(" ");
            }
            System.out.println(symbol);
            for (int k = 0; k <; k++) {
                System.out.print(symbol);
            }*/
            drawLine(symbol, offset, length);

            offset-=growth;
            length += growth*2;
        }
    }


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

    public static void drawRectangle(char symbol, int offset, int length, int height) {


        for (int j = 0; j < height; j++) {

            for (int i = 0; i < offset; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < length; i++) {
                System.out.print(symbol);

            }
            System.out.println();
        }


        // TODO: Ein Rechteck aus Symbolen zeichnen mit Abstand zu links von offset
        // und Länge length und Höhe height

    }
}
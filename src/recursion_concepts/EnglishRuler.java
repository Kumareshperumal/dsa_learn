package recursion_concepts;

public class EnglishRuler {
    public static void main(String[] args) {
        int nInches = 3, tickLength =3;
        drawRuler(nInches,tickLength);
    }

    private static void drawRuler(int nInches, int tickLength) {
        drawLine(tickLength, 0);
        for (int i = 1; i<= nInches; i++){
            drawInterval(tickLength -1);
            drawLine(tickLength, i);
        }
    }

    private static void drawInterval(int tickLength) {
        if(tickLength >= 1){
            drawInterval(tickLength-1);
            drawLine(tickLength);
            drawInterval(tickLength-1);
        }
    }

    private static void drawLine(int tickLength) {
        drawLine(tickLength,-1);
    }

    private static void drawLine(int tickLength, int inches) {
        for (int i = 1; i<= tickLength; i++){
            System.out.print("-");
        }
        if(inches >=0) System.out.print(" "+inches);
        System.out.println();
    }
}

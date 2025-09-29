package recursion;

public class EnglishRuler {
    public static void main(String[] args) {
        int nInches = 2, majorLength = 3;
        drawRuler(nInches, majorLength);
    }

    private static void drawRuler(int nInches, int majorLength) {
        drawLines(majorLength, 0);  //draw inch 0 line and label
        for (int i = 1; i <= nInches; i++) {
            drawInterval(majorLength - 1);  //draw interior ticks for inch
            drawLines(majorLength, i);  //draw inch i line and label
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {                           //otherwise, do nothing.
            drawInterval(centralLength - 1);    //recursively draw top interval
            drawLines(centralLength);                       //draw center tick line without label
            drawInterval(centralLength - 1);    //recursively draw bottom interval
        }
    }

    private static void drawLines(int tickLength, int tickLabel) {
        for (int i = 0; i < tickLength; i++)
            System.out.print("-");
        if (tickLabel >= 0) System.out.print("  " + tickLabel);
        System.out.println();
    }

    //Draw line with no label.
    private static void drawLines(int centralLength) {
        drawLines(centralLength, -1);
    }
}

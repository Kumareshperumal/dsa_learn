package recursion;

public class PrintBinary2 {
    public static void main(String[] args) {
        printBinary(3);
    }

    private static void printBinary(int num) {
        printBinary(num, "");
    }

    private static void indent(int num) {
        for (int i = 0; i <= num; i++)
            System.out.print("     ");
    }

    private static void printBinary(int num, String prefix) {
//        indent(num);
//        System.out.println(num + " ? indent " + s);
        if (num == 0) {
            System.out.println(prefix);
        } else {
//            printBinary(num - 1, s + "0");
            for (int i = 0; i < 2; i++) {
                printBinary(num - 1, prefix + i + "");
            }
        }
    }
}

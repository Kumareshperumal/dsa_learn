package recursion;

import java.util.Arrays;

import static java.lang.Character.isDigit;

public class Evaluate {
    public static int index = 0;

    public static void main(String[] args) {
        String data = "(1+((2*3)+4))";
        evaluateString(data);
        data = "((1+1)*(2*(3+3)))";
        evaluateString(data);
        data = "(1+(2*4))";
        evaluateString(data);
    }

    private static void evaluateString(String data) {
        char[] charArr = data.toCharArray();
        int sum = evaluateStringHelper(charArr);
        System.out.println("sum of evaluate " + Arrays.toString(charArr) + " ? " + sum);
        index = 0;
        sum = evaluateStringHelper2(charArr,0);
        System.out.println("sum of evaluate " + Arrays.toString(charArr) + " ? " + sum);
    }

    private static void indent(int index) {
        for (int i = 0; i < index; i++) {
            System.out.print("  ");
        }
    }

    private static int evaluateStringHelper2(char[] data, int index) {
        indent(index);
        System.out.print(data[index] + ", " + index);
        System.out.println();
        if (isDigit(data[index])) {
            {
               int num = data[index] - '0';
                index = index +1;
                return num;
            }
        } else {
            index++;
            int operand1 = evaluateStringHelper(data);
            char op = data[index++];
            int operand2 = evaluateStringHelper(data);
            index = index + 1;
            if (op == '+') {
                return operand1 + operand2;
            } else {
                return operand1 * operand2;
            }
        }
    }

    private static int evaluateStringHelper(char[] data) {
        indent(index);
        System.out.print(data[index] + ", " + index);
        System.out.println();
        if (isDigit(data[index])) {
            return data[index++] - '0';
        } else {
            index++;
            int operand1 = evaluateStringHelper(data);
            char op = data[index++];
            int operand2 = evaluateStringHelper(data);
            index++;
            if (op == '+') {
                return operand1 + operand2;
            } else {
                return operand1 * operand2;
            }
        }
    }
}

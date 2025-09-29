package recursion;

public class RecursionEval {
        private static int index = 0;

    public static void main(String[] args) {
       int res = calculate("1 + 1");
        System.out.println(res);
    }
        public static int calculate(String s) {
            s = s.trim();
            String newS = "";
            for(int i =0;i<s.length();i++)
            {
                if(s.charAt(i) == ' '){
                    continue;
                }
                newS += s.charAt(i)+ "";
            }
            return calculateHelper(newS);
        }
        private static int calculateHelper(String data) {
            if (Character.isDigit(data.charAt(index))) {
                int oprd = data.charAt(index) - '0';
                index++;
                return oprd;
            } else {
                if(data.charAt(index) == '(') index++;
                int operand1 = calculateHelper(data);
                char op = data.charAt(index);
                index++;
                int operand2 = calculateHelper(data);
                if(data.charAt(index) == ')') index++;
                if (op == '+') {
                    return operand1 + operand2;
                } else {
                    return operand1 - operand2;
                }
            }
        }
}

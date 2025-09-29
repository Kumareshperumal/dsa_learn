package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleSolve {
    public static void main(String[] args) {
        int num = 3;
        List<Character> result = new ArrayList<>();
        List<Character> input = new ArrayList<>(Arrays.asList('a', 'b', 'c','d','e','h'));
        combinationSolve(num, input, result);
    }

    private static void combinationSolve(int num, List<Character> input, List<Character> result) {
        for (int i = 0; i < input.size(); i++) {
            result.add(input.get(i));
            input.remove(i);
            if (num == 1) System.out.println(result);
            else
                combinationSolve(num - 1, input, result);
            char ch = result.remove(result.size() - 1);
            input.add(i, ch);
        }
    }
}

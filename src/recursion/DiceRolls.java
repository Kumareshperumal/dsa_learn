package recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRolls {
    public static void main(String[] args) {
        diceRoll(2, 7);
    }

    private static List<Integer> diceRoll(int dice, int desiredSum) {
        List<Integer> chosen = new ArrayList<>();
//        List result = new ArrayList();
        diceRoll(dice, desiredSum, chosen, 0);
//        System.out.println("returning chosen data ? " + result);
        return chosen;

    }

    private static void diceRoll(int dice, int desiredSum, List<Integer> chosen, int sumSoFar) {
        /*
        1. at the end of this method call chosen will be empty, bcz we are removing all the chosen values after each
        recursion call.
        2. but when dice = 0 we get the actual result & we print them or store in an array. we explored all the options.
        */
        if (dice == 0) {
            System.out.println(chosen);
//            result.add(new ArrayList<>(chosen));
        } else {
            for (int i = 1; i <= 6; i++) {
                //reduce the number of call.
                int min = sumSoFar + i + 1 * (dice - 1);
                int max = sumSoFar + i + 6 * (dice - 1);
                if (desiredSum >= min && desiredSum <= max) {
                    //choose
                    chosen.add(i);
                    //explore
                    diceRoll(dice - 1, desiredSum, chosen, sumSoFar + i);
                    //un-choose
                    chosen.remove(chosen.size() - 1);
                }
            }
        }
    }
}

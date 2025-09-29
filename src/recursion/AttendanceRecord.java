package recursion;

import javax.swing.text.Keymap;
import java.awt.image.ImageProducer;
import java.util.*;

public class AttendanceRecord {
    static int count = 0;

    public static void main(String[] args) {
        /*
        1. The student was absent ('A') for strictly fewer than 2 days total.
        2. The student was never late ('L') for 3 or more consecutive days.
         */
        int n = 10;
        checkRecord(n);
    }

    private static void checkRecord(int n) {

        List<Character> ch = new ArrayList<>(Arrays.asList('A', 'P', 'L'));
        List<Character> chosen = new ArrayList<>();
        checkRecordHelper(n, ch, chosen);
        System.out.println("count of output ? " + count);
    }

    private static int checkRecordHelper(int n, List<Character> ch, List<Character> chosen) {

        if (n == 0) {
//            System.out.println(chosen);
            count++;
        } else {
            for (int i = 0; i <= 2; i++) {
                char chA = ch.get(i);
                char chL = ch.get(i);
                if (chA == 'A' && !chosen.isEmpty() && chosen.contains('A')) {
                } else if (chL == 'L' && chosen.size() >= 2 && chosen.get(chosen.size() - 1) == 'L' && chosen.get(chosen.size() - 2) == 'L') {
                } else {
                    //choose
                    chosen.add(ch.get(i));
                    //explore
                    int result = checkRecordHelper(n - 1, ch, chosen);
                    //unchoose
                    chosen.remove(chosen.size() - 1);
                }
            }
        }
        return count;
    }
}

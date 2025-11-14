package october_learn_2025;

import java.util.Arrays;

import static java.lang.Math.ceil;

public class SuccessfulPairsOfSpellsandPotions {
    public static void main(String[] args) {
        int[] spells = new int[]{3,1,2};
        int[] potions = new int[]{8,5,8};
        int success = 16;
        Arrays.sort(potions);
        sposap(spells,potions,success);
    }

    private static void sposap(int[] spells, int[] potions, int success) {
        int pLen = potions.length;
        int[] s = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            long target = (success + spells[i] -1) /spells[i];
            s[i] = potions.length - pairscheck(potions,target);
        }
        System.out.println(Arrays.toString(s));
    }

    private static int pairscheck(int[] potions, long target) {
        int left =0, right = potions.length;
        while(left < right){
            int mid = left+(right-left)/2;
            if(potions[mid] < target) left = mid+1;
            else right = mid;
        }
        return left;
    }
}

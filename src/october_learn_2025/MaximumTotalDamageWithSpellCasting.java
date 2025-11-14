package october_learn_2025;

import java.util.*;

public class MaximumTotalDamageWithSpellCasting {
    private static int max = 0;
    public static void main(String[] args) {
        int[] power = {1,1,3,4};
        spellCasting(power);
    }
    static Map<Integer,Long> map = new HashMap<>();
    static Map<Integer,Long> sum = new HashMap<>();

    private static void spellCasting(int[] power) {
        List<Integer> damage = new ArrayList<>();

        scHelper(power,damage,0,0);
        System.out.println("max ?? "+ max);

        max = 0;
        Arrays.sort(power);
        for (int i: power)
            sum.put(i, sum.getOrDefault(i, 0L) + i);
        long m = schelper1(power,0);
        System.out.println("Using memo ? " + m);
    }

    private static long schelper1(int[] power, int index) {
//        if(index >= power.length) return 0;
//
//        if(map.containsKey(index)) return map.get(index);
//
//        int c = power[index];
//        int next = index+1;
//        while(next < power.length && Math.abs(power[next] - c) <=2)
//            next++;
//
//        int t = c + schelper1(power,next);
//
//        int r = schelper1(power,index+1);
//
//        int m = Math.max(r,t);
//        map.put(index,m);
//
//        return m;

        if(index >= power.length) return 0;

        if(map.containsKey(index)) return map.get(index);

        int c = power[index];
        int next = index +1;
        long take = sum.get(c);

        while(next < power.length && Math.abs(power[next] - c) <= 2)
            next++;

        long choose = take + schelper1(power, next);

        long skip = schelper1(power, index + 1);

        long r = Math.max(skip, choose);
        map.put(index, r);
        return r;
    }

    private static void scHelper(int[] power, List<Integer> damage, int start, int total) {

            if(start == power.length) return;
            for(int i=start;i<power.length;i++){
                int c = power[i];
                if(damage.contains(c)) continue;
                total+=c;

                damage.add(c+1);
                damage.add(c+2);
                damage.add(c-1);
                damage.add(c-2);

                max=Math.max(max,total);
                scHelper(power,damage,i+1,total);

                total -= c;
                damage.remove(damage.size()-1);
                damage.remove(damage.size()-1);
                damage.remove(damage.size()-1);
                damage.remove(damage.size()-1);

        }
    }
}

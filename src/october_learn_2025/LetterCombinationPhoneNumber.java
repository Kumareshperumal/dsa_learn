package october_learn_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        lcpn(map);
    }

    private static void lcpn(Map<Integer, String> map) {
        List<String> c= new ArrayList<>();
        String digits = "23";
        lcpnHelper(digits, map, c, 0,"");
        System.out.println(c);
        c = new ArrayList<>();
        lcpnHelper1(digits, map, c, 0,"");
        System.out.println("Using Java 8 functional way " + c);
    }

    private static void lcpnHelper(String digits, Map<Integer, String> map, List<String> c, int start, String str) {

        if(start == digits.length())
        {
            c.add(str);
            return;
        }
        String d = map.get(Integer.parseInt(digits.charAt(start) +""));

        for(int i=0;i<d.length();i++)
        {
            str += d.charAt(i);
            lcpnHelper(digits,map,c,start+1, str);
            str = str.substring(0, str.length()-1);
        }

    }

    private static void lcpnHelper1(String digits, Map<Integer, String> map, List<String> c1, int start, String str){
        if(digits.length() == start){
            c1.add(str);
            return;
        }
        String getDigitsData = map.getOrDefault(Integer.parseInt(digits.charAt(start)+""),"");
        getDigitsData.chars()
                .mapToObj(eachChar -> (char) eachChar)
                .forEach(ch -> lcpnHelper1(digits, map, c1, start+1, str+ch));
    }
}

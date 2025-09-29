package september_learn;

public class FractionToDecimal {
    public static void main(String[] args) {
        long divisor = 2;
        long f = 1/divisor;
        long v = 1%divisor;
        String ap = "";
        while (v != 0) {
            ap += v +"";
            v *=10;
            v %= divisor;
            if(ap.length() > 3) break;
        }
        System.out.println(f + "." + ap);

    }
}

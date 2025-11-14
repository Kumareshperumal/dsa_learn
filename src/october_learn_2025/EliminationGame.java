package october_learn_2025;

public class EliminationGame {
    public static void main(String[] args) {
        int n = 3;
      int r=  eg(n, true);
        System.out.println("final result ?"+r);
    }

    private static int eg(int n, boolean leftToRight) {

        if(n==1) return 1;
        if(leftToRight){
            return 2 * eg(n/2, false);
        }
        else{
            if(n %2==0)
                return 2 * eg(n/2,true) -1;
            else return 2 * eg(n/2,true);
        }
    }
}

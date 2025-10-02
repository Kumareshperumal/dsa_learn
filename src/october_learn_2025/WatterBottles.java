package october_learn_2025;

public class WatterBottles {
    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;
        numWaterBottles(numBottles,numExchange);
    }

    private static void numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while((numBottles/numExchange) > 0){
            int temp = (numBottles % numExchange);
            numBottles = (numBottles/numExchange);
            sum += numBottles;
            numBottles += temp;


        }
        System.out.println("Total water bottles ? " + sum);
    }
}

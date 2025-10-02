package october_learn_2025;

public class WaterBottlesII {
    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        int total = calWaterBottles(numBottles,numExchange);
        System.out.println("Total water bottles used : " + total);
        calWaterBottles1(numBottles,numExchange);
    }

    private static void calWaterBottles1(int numBottles, int numExchange) {
        int total = numBottles;
        for(int empty = numBottles; empty >= numExchange; numExchange++){
            total +=1;
            empty -= numExchange-1;
        }
        System.out.println("Total water bottles using different approach ? " + total);
    }

    private static int calWaterBottles(int numBottles, int numExchange) {
        int newNumBottle=0, sum = numBottles;
        while(numBottles >= numExchange){
            numBottles = numBottles - numExchange;
            numExchange+= 1;
            newNumBottle +=1;
            sum +=1;
            if(numBottles < numExchange) {
                numBottles+= newNumBottle;
                newNumBottle = 0;
            }
        }
        return sum;
    }
}

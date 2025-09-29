package recursion_concepts;


public class BinaryySearch {
    public static void main(String[] args) {
        int[] data = {2, 4, 5 ,7 ,8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        boolean value = binarySearchh(data, 0, data.length, 22);
        System.out.println("data found ? " + value);
    }

    private static boolean binarySearchh(int[] data, int low, int high, int target) {
        if(low > high)  return false;
        else{
            while (low <= high) {
                int mid = (high + low) / 2;
                if(data[mid] == target){
                    System.out.println("data found ? " + target);
                    return true;
                }else if(data[mid] < target) binarySearchh(data, mid+1, high,target );
                else binarySearchh(data, low, mid-1,target);
            }
       return false;
        }
    }
}

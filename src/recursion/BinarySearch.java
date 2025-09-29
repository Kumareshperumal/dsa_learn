package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] data = {2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        int target = 22;
        int low = 0, high = data.length - 1;
        boolean result = binarySearchRecursion(data, target, low, high);
        System.out.println("data found ? " + result);
        result = binarySearchRecursion(data, 26, low, high);
        System.out.println("data found ? " + result);
    }

    private static boolean binarySearchRecursion(int[] data, int target, int low, int high) {
        if (low > high) return false;   //interval empty, no match.
        else {
            int mid = (low + high) / 2;
            if (data[mid] == target) return true;   //found a match.
            else if (data[mid] > target) return binarySearchRecursion(data, target, low, mid - 1);  //recur left of the middle
            else return binarySearchRecursion(data, target, mid + 1, high);     //recur right of the middle.
        }
    }
}

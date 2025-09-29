package recursion;

public class LinearSum {
    public static void main(String[] args) {
        int[] data = {4, 3, 6, 2, 8};
        int sum = sumOfArray(data, data.length);
        System.out.println("sum of list ? " + sum);
        sum = sumOfArray2(data, 0, data.length - 1);
        System.out.println("sum of list ? " + sum);
    }

    //Tamasa Notes.
    private static int sumOfArray2(int[] data, int low, int high) {
        if (low > high) return 0;
        else if (low == high) return data[low];
        else {
            int mid = (low + high) / 2;
            return sumOfArray2(data, low, mid) + sumOfArray2(data, mid + 1, high);
        }
    }

    private static int sumOfArray(int[] data, int length) {
        if (length == 0) return 0;
        else return sumOfArray(data, length - 1) + data[length - 1];
    }
}

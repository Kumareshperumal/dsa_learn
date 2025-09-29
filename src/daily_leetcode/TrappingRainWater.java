package daily_leetcode;



public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int count = trap(height);
        System.out.println("output ? " + count);
        height = new int[]{4, 2, 0, 3, 2, 5};
        count = trap1(height);
        System.out.println("output ? " + count);
    }

    private static int trap1(int[] height) {
        int l = 0, sum = 0, r = height.length - 1, leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            sum += leftMax < rightMax ? leftMax - height[l++] : rightMax - height[r--];
        }
        return sum;

    }

    public static int trap(int[] height) {
        int maxLeft = height[0], left = 0;
        int maxRight = height[height.length - 1], right = height.length - 1;
        int count = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                count += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                count += maxRight - height[right];
            }
        }
        return count;
    }
}

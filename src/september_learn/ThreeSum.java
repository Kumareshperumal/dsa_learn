package september_learn;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threesums(nums);

    }

    private static void threesums(int[] nums) {
        for(int i=0; i< nums.length;i++){
            int start = i+1, end = nums.length-1;
            while(start < end){
                if(0==nums[i] + nums[start] + nums[end]){
                    System.out.println(nums[i]+ ", " + nums[start]  +", " + nums[end]);
                    start = start + 1;
                    end = nums.length-1;
                }
                else if(0 > nums[i]+ nums[start] + nums[end]){
                    if(nums[start] > nums[end]){
                        end--;
                    }else{
                        start++;
                    }
                }else{
                    if(nums[start] > nums[end]){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
    }
    private static void checkNum(int[] nums, int start, int end){
        if(nums[start] > nums[end]){
            start++;
        }else{
            end--;
        }
    }
}

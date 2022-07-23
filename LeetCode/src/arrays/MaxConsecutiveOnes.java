package arrays;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1- Input: nums = [1,1,0,1,1,1],  Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2- Input: nums = [1,0,1,1,0,1],  Output: 2
 */
public class MaxConsecutiveOnes {
    private int findMaxConsecutiveOnes(int[] nums) {
        /**
         * 1. Start count and max from zero
         * 2. Loop through the item and when num is 1 then update counter(increase by 1)
         * 3. But when num is zero first update the max then update count = 0;
         * 4. Finally, return the max value of count and max
         */
        // Hint: Initialise and declare a variable here to
        int max = 0, count = 0;
        // keep track of how many 1's you've seen in a row.
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                max = Math.max(max, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(max, count);
    }

    private int findMaxConsecutiveOnes1(int[] nums) {
        /**
         * max is final output
         * count is counting the consecutive sub array.
         * The logic is moving from left to right:
         * If the number is 1, the count increase by 1. max will be the maximum value between previous maxCount and count.
         * This way we always have the latest count of the longest consecutive 1's.
         * If the number is 0, the count reset to 0
        */
        int max = 0, count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1; //Increment the count of 1's by one.
                max = Math.max(count, max);
            }else{
                count = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,1,0,1,1,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,0,1,1,0,1}));
    }
}

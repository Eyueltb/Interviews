package arrays101.introd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * (485-Easy) Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1- Input: nums = [1,1,0,1,1,1],  Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 *
 * Example 2- Input: nums = [1,0,1,1,0,1],  Output: 2
 * Hints
 * Hint 1- You need to think about two things as far as any window is concerned.
 * One is the starting point for the window. How do you detect that a new window of 1s has started?
 * The next part is detecting the ending point for this window. How do you detect the ending point
 * for an existing window? If you figure these two things out, you will be able to detect the windows of
 * consecutive ones. All that remains afterward is to find the longest such window and return the size.
 *
 *  Approach: One pass
 * Intuition
 *
 * The intuition is pretty simple. We keep a count of the number of 1's encountered. And reset the count whenever we encounter anything other than 1 (which is 0 for this problem). Thus, maintaining count of 1's between zeros or rather maintaining counts of contiguous 1's. It's the same as keeping a track of the number of hours of sleep you had, without waking up in between.
 *
 * Algorithm
 *
 * Maintain a counter for the number of 1's.
 * Increment the counter by 1, whenever you encounter a 1.
 * Whenever you encounter a 0
 *   a. Use the current count of 1's to find the maximum contiguous 1's till now.
 *   b. Afterwards, reset the counter for 1's to 0.
 *
 * Return the maximum in the end.
 *
 * In the above diagram we found out that the maximum number of consecutive 1's is 3.
 * There were two breaks in the count we encountered while iterating the array.
 * Every time the break i.e. 0 was encountered we had to reset the count of 1 to zero.
 *
 * Note - The maximum count is only calculated when we encounter a break i.e. 0, since thats where a subarray of 1's ends.
 *
 * Java
 *  class Solution {
 *   public int findMaxConsecutiveOnes(int[] nums) {
 *     int count = 0;
 *     int maxCount = 0;
 *     for(int i = 0; i < nums.length; i++) {
 *       if(nums[i] == 1) {
 *         // Increment the count of 1's by one.
 *         count += 1;
 *       } else {
 *         // Find the maximum till now.
 *         maxCount = Math.max(maxCount, count);
 *         // Reset count of 1.
 *         count = 0;
 *       }
 *     }
 *     return Math.max(maxCount, count);
 *   }
 * }
 * Python
 *  class Solution:
 *     def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
 *         count = max_count = 0
 *         for num in nums:
 *             if num == 1:
 *                 # Increment the count of 1's by one.
 *                 count += 1
 *             else:
 *                 # Find the maximum till now.
 *                 max_count = max(max_count, count)
 *                 # Reset count of 1.
 *                 count = 0
 *         return max(max_count, count)
 *
 *
 * Complexity Analysis
 * Time Complexity: O(N ), where NN is the number of elements in the array.
 * Space Complexity: O(1). We do not use any extra space.
 * Related topics - Array
 * Similar question -
 * Max Consecutive Ones II(487-- Medium)
 * Max Consecutive Ones III - Medium
 * Consecutive Characters - Easy
 * Longer Contiguous Segments of Ones than Zeros - Easy
 * Length of the Longest Alphabetical Continuous Substring - Medium
 *
 */
public class MaxConsecutiveOnes {
    private int findMaxConsecutiveOnes(int[] nums) {
        /**
         * 1. Initialise and declare a variable
         * 2. Loop through to keep track of how many 1's you've seen in a row.
         * 3. when num is 1 then update counter(increase by 1)
         * 4. But when num is zero first update the max then update count = 0;
         * 5. Finally, return the max value of count and max
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
    private int findMaxConsecutiveOnes2(int[] nums) {
        AtomicInteger max = new AtomicInteger();
        AtomicInteger count = new AtomicInteger();
        IntStream.range(0, nums.length).forEach(i ->{
            if(nums[i] == 1){
                count.addAndGet(1); //Increment the count of 1's by one.
                max.set(Math.max(count.get(), max.get()));
            }else{
                count.set(0);
            }
        });
        return max.get();
    }
    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,1,0,1,1,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes1(new int[]{1,0,1,1,0,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1,1,0,1,1,1}));
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes2(new int[]{1,0,1,1,0,1}));
    }
}

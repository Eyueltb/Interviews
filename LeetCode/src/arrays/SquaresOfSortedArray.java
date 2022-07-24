package arrays;

import java.util.Arrays;

/**
 * (977) Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquaresOfSortedArray {
    /** Create an array of the squares of each element, and sort them.
     * Time Complexity: O(N log N), where NN is the length of A.
     * Space complexity :O(N) or O(logN)
     */
    private int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int [] result = new int[N];
        for (int i = 0; i < N ; i++)
            result[i] = nums[i] * nums[i];
        Arrays.sort(result); //O(N logN).
        return result;
    }

    private int[] sortedSquares2(int[] nums) {
         return Arrays.stream(nums).map(num -> num * num).sorted().toArray();
    }

    /**
     * Two pointer
     * Time Complexity: O(N), where NN is the length of A.
     * Space Complexity: O(N) if you take output into account and O(1) otherwise.
     */
    private int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
    public static void main(String[] args) {
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        Arrays.stream(squaresOfSortedArray.sortedSquares(new int[] {-4,-1,0,3,10})).forEach(System.out::println);
        Arrays.stream(squaresOfSortedArray.sortedSquares(new int[] {-7,-3,2,3,11})).forEach(System.out::println);
        Arrays.stream(squaresOfSortedArray.sortedSquares2(new int[] {-4,-1,0,3,10})).forEach(System.out::println);
        Arrays.stream(squaresOfSortedArray.sortedSquares2(new int[] {-7,-3,2,3,11})).forEach(System.out::println);
    }
}

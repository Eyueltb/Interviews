package arrays;

import java.util.stream.IntStream;

/**
 * (1295) Given an array nums of integers, return how many of them contain an even number of digits.
 * Example 1:
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore, only 12 and 7896 contain an even number of digits.
 *
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 105
 *
 * Hint- 1. How to compute the number of digits of a number ?  2. Divide the number by 10 again and again to get the number of digits.
 */
public class FindNumbersWithEvenNumberOfDigits {

    private int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            int digit = 0;
            while (num > 0){
                num = num / 10;
                digit++;
            }
            if(digit % 2 == 0)
                count ++;
        }
        return count;
    }

    private int findNumbers1(int[] nums) {
        int count =0;
        for(int i=0; i < nums.length; i++) {
            //String valueOf(int i) -> a string representation of the int argument.
            if((String.valueOf(nums[i]).length()) % 2 == 0)
                count++;
        }
        return count;
    }
    private int findNumbersWithEvenNumberOfDigits(int[] nums) {
        return (int) IntStream.range(0, nums.length)
                    .filter(i -> (String.valueOf(nums[i]).length()) % 2 == 0).count();

    }
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits numbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers(new int[]{555,901,482,1771}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers1(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers1(new int[]{555,901,482,1771}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbersWithEvenNumberOfDigits(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbersWithEvenNumberOfDigits(new int[]{555,901,482,1771}));
    }
}

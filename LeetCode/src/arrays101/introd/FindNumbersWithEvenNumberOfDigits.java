package arrays101.introd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * (1295- easy) Given an array nums of integers, return how many of them contain an even number of digits.
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
 * Similar topic- Array
 * Finding 3-Digit Even Numbers(2094 -Easy)
 */
public class FindNumbersWithEvenNumberOfDigits {

    private int findNumbers(int[] nums) {
        //Here we need to counter to keep track of # even digits(count) and # of digits from each elements of array

        int count = 0;
        for(int num : nums) {
            int digit = 0; //for every element digit set to zero;
            //Algorithm to count the digits
            while (num > 0){
                num = num / 10; // to git a digit divided by 10.
                digit++;
            }
            //update the counter only if a given digit is an even.
            if(digit % 2 == 0)
                count ++;
        }
        return count;
    }

    private int findNumbers1(int[] nums) {
        int count =0;
        for(int i=0; i < nums.length; i++) {
            if((String.valueOf(nums[i]).length()) % 2 == 0)
                count++;
        }
        return count;
    }
    private int findNumbersUsingAtomicInteger(int[] nums) {
        AtomicInteger count = new AtomicInteger();
        IntStream.range(0, nums.length).forEach(i->{
            if((String.valueOf(nums[i]).length()) % 2 == 0)
                count.addAndGet(1);
        });
        return count.get();
    }
    private int countNumbersWithEvenNumberOfDigits(int[] nums) {
        /**
         * 1. filter even length of array elements and count by using String method valueOf()
         * 2. count()
         * String valueOf(int i) -> a string representation of the int argument.
         */
         return (int) IntStream.range(0, nums.length)
                    .filter(i -> (String.valueOf(nums[i]).length()) % 2 == 0).count();

    }
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits numbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers(new int[]{555,901,482,1771}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers1(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.findNumbers1(new int[]{555,901,482,1771}));
        System.out.println(numbersWithEvenNumberOfDigits.countNumbersWithEvenNumberOfDigits(new int[]{12,345,2,6,7896}));
        System.out.println(numbersWithEvenNumberOfDigits.countNumbersWithEvenNumberOfDigits(new int[]{555,901,482,1771}));
    }
}

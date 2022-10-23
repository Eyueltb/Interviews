package beginner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 412. Fizz Buzz(Easy)
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 * SRelated Topics-> Math, String, Simulation
 * Similar Questions -> Fizz Buzz Multithreaded  Medium
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();

        IntStream.rangeClosed(1, n).forEach(i-> {

            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);

            if (divisibleBy3 && divisibleBy5)
                ans.add("FizzBuzz");// Divides by both 3 and 5, add FizzBuzz
            else if (divisibleBy3)
                ans.add("Fizz"); // Divides by 3, add Fizz
            else if (divisibleBy5)
                ans.add("Buzz");// Divides by 5, add Buzz
            else
                ans.add(Integer.toString(i));    // Not divisible by 3 or 5, add the number
        });
        return ans;
    }
    public List<String> fizzBuzzStream(int n) {
        //First map to object then them map to string and finally collect as a list
        return IntStream.rangeClosed(1,n)
                .mapToObj(i->
                        (i % 5 == 0 && i % 3 == 0) ? "FizzBuzz": ( i % 3 == 0) ?
                                "Fizz": (i % 5==0 ) ?  "Buzz" : i).map(Objects::toString).collect(Collectors.toList());
    }
    public static void main(String[] args) {

    }
}

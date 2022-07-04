package simple;

import java.util.Arrays;
import java.util.List;

public class BobSledding {
    /**
     * Task 1: Return the farthest distance Bob can travel through the values
     * from a given starting point.
     */
    /**
     * Sub-Task 1: The farthest distance (4 points)
     * Your first task is to find the farthest distance Bob can travel sideways from a given starting point in the array.
     *
     * Example:
     *
     * Given the array [0,2,2,4,5,1,0] and the starting point 3, Bob can travel at most 1 step by going 4 -> 2. In the next step he cannot go 2 -> 2 because he can only go downhill.

     */
    public int farthestDistance(List<Integer> values, int startingPoint) {
        int count = 0;
        // Write your code here
        for(int i = startingPoint; i < values.size(); i++){
            if(values.get(i) > values.get(i+1))
                count+=1;
            else
                i = values.size();
        }
        for(int i = startingPoint; i > 0; i--) {
            if (values.get(i) > values.get(i - 1))
                count += 1;
            else
                i=0;
        }
        return count;
    }



    /**
     * Task 2: Return the optimal starting point for Bob if he wants to go as
     * far through the values as possible on his sled. If there are several
     * starting points which gives the same distance, return the one with the
     * lowest index. The values used are the same as those provided in task
     * 1.
     * Given the array [0,4,8,6,4,2,0], the optimal starting point is index 2 from which Bob can travel 4 steps sideways.
     */
    public int optimalStartingPoint(List<Integer> values) {
        int max = 0;
        for(int i=0;i< values.size();i++){
            if(max < values.get(i))
                max = i; // find the index where the number is max
        }
        // Write your code here
        return values.size() - max + 1;
    }
    public static void main(String[] args) {
        BobSledding sampleCode = new BobSledding();
        List<Integer> num1 = Arrays.asList(0,4,8,6,4,2,0);

        System.out.println(sampleCode.optimalStartingPoint(num1));//4
        List<Integer> num2= Arrays.asList(0,2,2,4,5,1,0);
        System.out.println(sampleCode.farthestDistance(num2,3 ));//1
    }
}

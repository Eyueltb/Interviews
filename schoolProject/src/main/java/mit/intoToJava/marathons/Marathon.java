package mit.intoToJava.marathons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Marathon {
    /**
     * Find the fastest marathon runners in the given data.
     * This method takes an integer array as an input.
     * The method will determine the smallest time in the array and return that index.
     * N.B-The function return the index of max value in the list
     */
    private static int findFastest(int[] times) {
        return  IntStream.range(0, times.length).reduce((i, j) -> times[i] > times[j] ? j : i).getAsInt();
    }

    /**
     * Find the second-fastest marathon runners in the given data.
     * N.B- The function return the index of min value in the list
     */

    private static int findSecondFastest(int[] times) {
        //Arrays.stream(times).distinct().sorted().skip(1).findFirst().getAsInt();
        int indexOfSecondFastest = 0;
        int secondFastestTime = times[0];
        int indexOfFastest = findFastest(times);
        int counter = 1, time = 0;
        while(counter < times.length) {
            if(counter == indexOfFastest)
            {
                counter += 1;
                continue;
            }

            time = times[counter];

            if(time < secondFastestTime)
            {
                secondFastestTime = time;
                indexOfSecondFastest = counter;
            }

            counter += 1;
        }
        return indexOfSecondFastest;
    }
    /**
     * Find the slowest marathon runners in the given data.
     * N.B- The function return the index of min value in the list
     */
    private static int findSlowest(int[] times) {
        return  IntStream.range(0,times.length).reduce((i, j) -> times[i] > times[j] ? i : j).getAsInt();
    }
    public static void main(String[] args) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };

        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };

        int indexOfFastest = findFastest(times);
        System.out.println("The fastest person was " + names[indexOfFastest] + " with a time of " + times[indexOfFastest] + " minutes.");

        int indexOfSlowest = findSlowest(times);
        System.out.println("The slowest person was " + names[indexOfSlowest] + " with a time of " + times[indexOfSlowest] + " minutes.");

        int indexOfSecondFastest = findSecondFastest(times);
        System.out.println("The second fastest person was " + names[indexOfSecondFastest] + " with a time of " + times[indexOfSecondFastest] + " minutes.");
    }


}

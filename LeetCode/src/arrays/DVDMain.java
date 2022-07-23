package arrays;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Array
 * Arrays are a simple data structure for storing lots of similar items.
 * An Array is a collection of items(The items could be integers, strings, DVDs, games, books—anything really).
 * The items are stored in neighboring (contiguous) memory locations. Because they're stored together.
 * The two most primitive Array operations are writing elements into them, and reading elements from them.
 * Array capacity-> The number items the array can hold, for instance, # of DVDs the box could hold, if it was full, or
 * Array Length -> The number of items currently the array hold, for instance, The number of DVDs currently in the box.
 */
public class DVDMain {
    public static void main(String[] args) {
        //write into array
        DVD [] dvdCollection = {
                new DVD("The Avengers", 2012, "Joss Whedon"),
                new DVD("The Incredibles", 2004, "Brad Bird"),
                new DVD("Finding Dory", 2016, "Andrew Stanton"),
                new DVD("The Lion King", 2019, "Jon Favreau"),
        };
        DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
        dvdCollection[3] = starWarsDVD;
        //read from array
        Arrays.stream(dvdCollection).map(dvd -> dvd.name).forEach(System.out::println);

        /** Writing Items into an Array with a Loop - create the first 10 square numbers */
        int [] squareNumbers = new int[10];
        IntStream.rangeClosed(0,9).forEach(i->
            squareNumbers[i] = (i+1) * (i+1)
        );
        //reading
        Arrays.stream(squareNumbers).forEach(System.out::println);

        int [] reverseOrder = new int[5];
        int to = 0, from = 5;
        reverseRange(to, from).forEach(i -> {
            reverseOrder[from - 1 - i] = i;
        });
        Arrays.stream(reverseOrder).forEach(System.out::println);

        /** Given a binary array, find the maximum number of consecutive 1s in this array.*/
        int [] binaryArray  = {0,1, 0, 1, 0, 1, 1};
        System.out.println(findMaxConsecutiveOnes(binaryArray));
    }
    static int findMaxConsecutiveOnes(int[] nums) {
        // Hint: Initialise and declare a variable here to
        int count = 0;
        // keep track of how many 1's you've seen in a row.
        for (int i = 0; i < nums.length; i++) {
            // Do something with element nums[i].
            if(nums[i]== 1)
                count++;
        }
        return count;
    }
    static IntStream reverseRange(int from, int to) {
        //int [] reverseOrder = new int[from-to];
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
               /* .forEach(i -> {
                    reverseOrder[5 - 1 - i] = i;
                });*/
        //return  reverseOrder;
    }
}

/**
 * Movie- The avengers
 * Year- 2012
 * Directors - Joss WHEDON
 * Description = This movie.....
 */
@Data
class DVD {
    String name;
    int releaseYear;
    String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

}

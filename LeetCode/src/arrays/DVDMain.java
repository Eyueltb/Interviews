package arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Array
 * Arrays are a simple data structure for storing lots of similar items.
 * An Array is a collection of items(The items could be integers, strings, DVDs, games, books—anything really).
 * The items are stored in neighboring (contiguous) memory locations. Because they're stored together.
 * The two most primitive Array operations are writing elements into them, and reading elements from them.
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
        IntStream.rangeClosed(0,9).forEach(i-> {
            squareNumbers[i] = (i+1) * (i+1);
        });
        //reading
        Arrays.stream(squareNumbers).forEach(System.out::println);
    }
}

/**
 * Movie- The avengers
 * Year- 2012
 * Directors - Joss WHEDON
 * Description = This movie.....
 */
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
package lnu.ds.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSum {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum1 = integers.stream().reduce(0, Integer::sum);
        Integer sum2 = integers.stream().mapToInt(Integer::intValue).sum();
        Integer sum3 = integers.stream().collect(Collectors.summingInt(Integer::intValue));

        List<Item> items = Arrays.asList(
                new Item(1, 10.6),
                new Item(2, 15.7),
                new Item(3, 25),
                new Item(4, 40.2));

        final Double sum4 = items.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);

        final Double sum5 = items.stream()
                .map(Item::getPrice)
                .reduce(0.0, (a,b)-> a + b);

        final Double sum6 = items.stream()
                .mapToDouble(Item::getPrice)
                .sum();

        String sentence = "Item1 10 Item2 25 Item3 30 Item4 45";

        Integer sum = Arrays.stream(sentence.split(" "))
                .filter(s-> s.matches("\\d+")) //\d+ is 1 or more digits
                .mapToInt(Integer::valueOf)
                .sum();

        System.out.println("Sum from string " +sum);
    }
}


@Data
@AllArgsConstructor
final class Item {

    private int id;
    private double price;

}


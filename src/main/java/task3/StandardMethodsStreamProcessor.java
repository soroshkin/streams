package task3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StandardMethodsStreamProcessor {
    private Stream<Integer> filterNumbers(Stream<String> stringStream) {
        return stringStream.filter(string -> {
            try {
                Integer.parseInt(string);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        })
                .map(Integer::parseInt);
    }

    public String countNumbersWithFilter(Stream<String> stream) {
        return "using filter: " + filterNumbers(stream)
                .count();
    }

    public String getMaxNumber(Stream<String> stream) {
        return "3.1 max: " + filterNumbers(stream)
                .max(Integer::compareTo);
    }

    public String countEvenNumbers(Stream<String> stream) {
        return "3.2 count even numbers: " + stream
                .filter(string -> {
                    try {
                        return Integer.parseInt(string) % 2 == 0;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .map(Integer::parseInt)
                .count();
    }

    public String sumStream(Stream<String> stream) {
        return "3.3 sum: " + filterNumbers(stream)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public String reduceToArray(Stream<String> stream) {
        return "3.4 into array: " + Arrays.toString(filterNumbers(stream)
                .toArray());
    }

    public String reduceToSet(Stream<String> stream) {
        return "3.5 into Set: " + filterNumbers(stream)
                .collect(Collectors.toSet());
    }

    public String reduceToMap(Stream<String> stream) {
        return "3.6 into Map<Boolean, List<Integer>>: " + filterNumbers(stream)
                .collect(Collectors.groupingBy(number -> number % 2 == 0 ? Boolean.TRUE : Boolean.FALSE));
    }
}

package task2;

import java.util.*;
import java.util.stream.Stream;

public class ReduceMethodStreamCalculator {
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
                .reduce(0, (first, second) -> first + 1, (first, second) -> 0);
    }

    public String countNumbers(Stream<String> stream) {
        return "without filter: " + stream
                .reduce(0, (first, second) -> {
                            try {
                                Integer.parseInt(second);
                            } catch (NumberFormatException e) {
                                return first;
                            }
                            return first + 1;
                        },
                        (first, second) -> 0);
    }

    public String getMaxNumber(Stream<String> stream) {
        return "3.1 with map, max: " + filterNumbers(stream)
                .reduce((first, second) -> first > second ? first : second);
    }

    public String countEvenNumbers(Stream<String> stream) {
        return "3.2 with map, count even numbers: " + stream
                .filter(string -> {
                    try {
                        return Integer.parseInt(string) % 2 == 0;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .map(Integer::parseInt)
                .reduce(0, (first, second) -> first + 1);
    }

    public String sumStream(Stream<String> stream) {
        return "3.3 with map, sum: " + filterNumbers(stream)
                .reduce(0, Integer::sum);
    }

    public String reduceToArray(Stream<String> stream) {
        return "3.4 with map, into array: " + Arrays.toString(
                filterNumbers(stream)
                        .reduce(new Integer[]{}, (numbersArray, nextNumber) -> {
                                    Integer[] arrayWithNextNumber = new Integer[numbersArray.length + 1];
                                    System.arraycopy(numbersArray, 0, arrayWithNextNumber, 0, numbersArray.length);
                                    arrayWithNextNumber[arrayWithNextNumber.length - 1] = nextNumber;
                                    return arrayWithNextNumber;
                                },
                                (numbersArray, second) -> numbersArray));
    }

    public String reduceToSet(Stream<String> stream) {
        return "3.5 with map, into Set: " + filterNumbers(stream)
                .reduce(new HashSet<Integer>(), (set, number) -> {
                    set.add(number);
                    return set;
                }, (set, number) -> set);
    }

    public String reduceToMap(Stream<String> stream) {
        return "3.6 with map, into Map<Boolean, List<Integer>>: " + filterNumbers(stream)
                .reduce(new HashMap<Boolean, List<Integer>>(), (map, number) -> {
                            boolean isEven = number % 2 == 0;
                            List<Integer> listOfNumbers = map.getOrDefault(isEven, new ArrayList<>());
                            listOfNumbers.add(number);
                            map.computeIfAbsent(isEven, aBoolean -> listOfNumbers);
                            return map;
                        },
                        (map, number) -> map);
    }
}


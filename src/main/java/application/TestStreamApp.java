package application;

import task2.ReduceMethodStreamCalculator;
import task3.StandardMethodsStreamProcessor;

import java.util.stream.Stream;

public class TestStreamApp {
    public static void main(String[] args) {
        ReduceMethodStreamCalculator reduceMethodStreamCalculator = new ReduceMethodStreamCalculator();

        System.out.println("=============== Reduce Method ===============");

        System.out.println(reduceMethodStreamCalculator.countNumbersWithFilter(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.countNumbers(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.getMaxNumber(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.countEvenNumbers(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.sumStream(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.reduceToArray(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.reduceToSet(createTestStream()));

        System.out.println(reduceMethodStreamCalculator.reduceToMap(createTestStream()));

        StandardMethodsStreamProcessor standardMethodsStreamProcessor = new StandardMethodsStreamProcessor();
        System.out.println("\n=============== Standard Methods ===============");

        System.out.println(standardMethodsStreamProcessor.countNumbersWithFilter(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.getMaxNumber(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.countEvenNumbers(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.sumStream(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.reduceToArray(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.reduceToSet(createTestStream()));

        System.out.println(standardMethodsStreamProcessor.reduceToMap(createTestStream()));
    }

    private static Stream<String> createTestStream() {
        return Stream.<String>builder()
                .add("1")
                .add("one")
                .add("10")
                .add("ten")
                .add("-10")
                .add("-one ten")
                .add("4")
                .add("four")
                .build();
    }
}

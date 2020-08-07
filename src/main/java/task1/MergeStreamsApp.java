package task1;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MergeStreamsApp {
    public static void main(String[] args) {
        MergeStreamsApp mergeStreamsApp = new MergeStreamsApp();
        Stream<Integer> firstStream = mergeStreamsApp.createStreamWithStreamBuilder();
        Stream<Integer> secondStream = mergeStreamsApp.createStreamWithOfMethod();
        Stream<Integer> thirdStream = mergeStreamsApp.createStreamWithGenerateMethod();

        Stream.of(firstStream, secondStream, thirdStream)
                .flatMap(i -> i)
                .forEach(System.out::print);
    }

    public Stream<Integer> createStreamWithStreamBuilder() {
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        return streamBuilder.add(1)
                .add(2)
                .add(3)
                .build();
    }

    public Stream<Integer> createStreamWithOfMethod() {
        return Stream.of(4, 5, 6);
    }

    public Stream<Integer> createStreamWithGenerateMethod() {
        return Stream.generate(new Supplier<Integer>() {
            private int nextInt = 7;

            @Override
            public Integer get() {
                return nextInt++;
            }
        }).limit(3);
    }
}

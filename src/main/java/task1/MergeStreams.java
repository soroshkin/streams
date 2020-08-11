package task1;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class MergeStreams {
    public static void main(String[] args) {
        MergeStreams mergeStreams = new MergeStreams();
        Stream<Integer> firstStream = mergeStreams.createStreamWithStreamBuilder();
        Stream<Integer> secondStream = mergeStreams.createStreamWithOfMethod();
        Stream<Integer> thirdStream = mergeStreams.createStreamWithGenerateMethod();

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

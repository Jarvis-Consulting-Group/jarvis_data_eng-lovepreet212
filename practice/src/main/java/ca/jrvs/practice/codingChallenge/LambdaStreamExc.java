package ca.jrvs.practice.codingChallenge;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface LambdaStreamExc {
    /**
     *
     * @param strings
     * @return
     */
    Stream<String> createStrStream(String ... strings);

    /**
     *
     * @param strings
     * @return
     */
    Stream<String> toUpperCase(String ... strings);

    /**
     *
     * @param stringStream
     * @param pattern
     * @return
     */
    Stream<String> filter(Stream<String> stringStream, String pattern);

    /**
     *
     * @param arr
     * @return
     */
    IntStream createIntStream(int[] arr);

    /**
     *
     * @param stream
     * @return
     * @param <E>
     */
    <E> List<E> toList(Stream<E> stream);

    /**
     *
     * @param intStream
     * @return
     */
    List<Integer> toList(IntStream intStream);

    /**
     *
     * @param start
     * @param end
     * @return
     */
    IntStream createIntStream(int start, int end);

    /**
     *
     * @param intStream
     * @return
     */
    DoubleStream squareRootIntStream(IntStream intStream);

    /**
     *
     * @param intStream
     * @return
     */
    IntStream getOdd(IntStream intStream);

    /**
     *
     * @param prefix
     * @param suffix
     * @return
     */
    Consumer<String> getLambdaPrinter(String prefix, String suffix);

    /**
     *
     * @param messages
     * @param printer
     */
    void printMessages(String[] messages, Consumer<String> printer);

    /**
     *
     * @param intStream
     * @param printer
     */
    void printOdd(IntStream intStream, Consumer<String> printer);

    /**
     *
     * @param ints
     * @return
     */
    Stream<Integer> flatNestedInt(Stream<List<Integer>> ints);



}

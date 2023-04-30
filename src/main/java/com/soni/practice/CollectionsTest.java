package com.soni.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionsTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4);



        //Lambda Expressions syntax is (argument) -> (body)

        /*Why do we need Lambda Expression
        - reduced lines of code
        - sequential and parallel execution support
        - passing behavior into methods
        - higher efficiency with laziness
         */

        Stream<Integer> intStream = Stream.of(1,2,3,4);

        //Converting Java Stream to List, Map using collect()
        List<Integer> intList = intStream.collect(Collectors.toList());
        System.out.println(intList); //prints [1, 2, 3, 4]

        Stream<Integer> intStream2 = Stream.of(1,2,3,4);
        Map<Integer,Integer> intMap = intStream2.collect(Collectors.toMap(i -> i, i -> i+10));
        System.out.println(intMap); //prints {1=11, 2=12, 3=13, 4=14}

        //Converting Java Stream to Array using toArray()
        Stream<Integer> intStream3 = Stream.of(1,2,3,4);
        Integer[] intArray = intStream3.toArray(Integer[]::new);
        System.out.println(Arrays.toString(intArray)); //prints [1, 2, 3, 4]

        Stream<List<String>> namesOriginalList = Stream.of(
                Arrays.asList("Pankaj"),
                Arrays.asList("David", "Lisa"),
                Arrays.asList("Amit"));
//flat the stream from List<String> to String stream
        Stream<String> flatStream = namesOriginalList
                .flatMap(strList -> strList.stream());

        flatStream.forEach(System.out::println);





        //Consumer
        /*
        * It represents an operation that accepts a single input argument and returns no result.
        * It can be used to perform some action on all the elements of the java stream.
        * Some of the Java 8 Stream methods where Consumer, BiConsumer or it’s primitive specialization interfaces are used are:
        * Stream<T> peek(Consumer<? super T> action)
        * void forEach(Consumer<? super T> action)
        * void forEachOrdered(Consumer<? super T> action)
        * */


        //Supplier
        /*
        * Supplier represent an operation through which we can generate new values in the stream.
        * Some of the methods in Stream that takes Supplier argument are:
        * public static<T> Stream<T> generate(Supplier<T> s)
        * <R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,BiConsumer<R, R> combiner)
        *
        * */

        //Function
        /*
        * Function represents a function that takes one type of argument and returns another type of argument.
        * Function<T, R> is the generic form where T is the type of the input to the function and
        * R is the type of the result of the function.
        * Some of the Stream methods where Function or it’s primitive specialization is used are:
        * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        * IntStream mapToInt(ToIntFunction<? super T> mapper) - similarly for long and double returning primitive specific stream.
        * IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) - similarly for long and double
        * <A> A[] toArray(IntFunction<A[]> generator)
        * <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        *
        * */


        //Predicate
        /*
        * It represents a predicate against which elements of the stream are tested.
        * This is used to filter elements from the java stream
        * Some of the Stream methods where Predicate or BiPredicate specializations are used are:
        * Stream<T> filter(Predicate<? super T> predicate)
        * boolean anyMatch(Predicate<? super T> predicate)
        * boolean allMatch(Predicate<? super T> predicate)
        * boolean noneMatch(Predicate<? super T> predicate)
        * */



        //Optional
        /*
        * Java Optional is a container object which may or may not contain a non-null value.
        * If a value is present, isPresent() will return true and get() will return the value.
        * Stream terminal operations return Optional object. Some of these methods are:
        * Optional<T> reduce(BinaryOperator<T> accumulator)
        * Optional<T> min(Comparator<? super T> comparator)
        * Optional<T> max(Comparator<? super T> comparator)
        * Optional<T> findFirst()
        * Optional<T> findAny()
        * */


        //sum of all numbers
        sumWithCondition(numbers, n -> true);
        //sum of all even numbers
        sumWithCondition(numbers, i -> i%2==0);
        //sum of all numbers greater than 5
        sumWithCondition(numbers, i -> i>5);

    }

    private static boolean isPrime(int number) {
        IntPredicate isDivisible = index -> number % index == 0;

        return number > 1
                && IntStream.range(2, number).noneMatch(
                isDivisible);
    }

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }
}

package core.CoreAdvance.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        // stream in  collection
        List<Integer> list = new ArrayList<>(List.of(4, 23, -10, 54, 9, 11, 18, 34, 44, 65, 89, 28));

        // getting stream object on data source
        Stream<Integer> stream = list.stream();

        // chain of operation
        stream = stream.filter(x -> x > 10);
        stream = stream.filter(x -> x % 2 == 0);
        stream = stream.map(x -> x * 2);
        stream.forEach(System.out::println);

        // next approach
        list.stream()
                .filter(x -> x > 10)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .forEach(System.out::println);

        //stream in array
        String[] name = {"Shyam", "Bhushan", "Ram", "Rupesh", "Balaram", "Samjhana"};
        Stream<String> s = Arrays.stream(name); // now you've data source to stream, could perform stream operations

        //stream : Stream.of()
        Stream<Integer> num = Stream.of(1, 3, 5, 7, 8, 9, 11, 12, 13, 14, 15);

        //Empty Stream
        Stream<Object> empty = Stream.empty();

        //infinite stream : 1. iterate() , 2. generate()
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1).limit(10);
        infinite.forEach(System.out::println);

        Stream<Double> generate = Stream.generate( Math :: random).limit(5);
        generate.forEach(System.out :: println);

        //primitives stream
        IntStream intStream = IntStream.of(1,2,3,4);
        LongStream longStream = LongStream.of(44,55,66,77);
        DoubleStream doubleStream = DoubleStream.of(101,303,404,55);

        // object to primitive
        IntStream iStream = num.mapToInt(x -> x);

        //primitive to object
        Stream<Integer> pToObj = iStream.boxed();

        //primitive to primitive
        LongStream lStream = intStream.mapToLong(x -> x);




    }
}

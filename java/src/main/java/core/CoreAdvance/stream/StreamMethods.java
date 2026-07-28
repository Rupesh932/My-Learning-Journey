package core.CoreAdvance.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMethods {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2, 13, 65, 32, 44, -20, 17, 27, 35, 7, 41, 12, 18, 34, 68, 102, 22, 16));

        //Intermediate Functions : Lazy Loading :  returns a stream hence we can apply another operation.
        list.stream() // pass element of list one by one
                .filter(x -> x > 10 && x % 2 == 0) // takes Predicate : test()
                .map(x -> x * 2)// takes Function : apply()
                .sorted() // needs all elements before sort

                // Terminal Functions : Eager Loading : once consumed stream is dead.
                .forEach(x -> System.out.print(x + " "));// takes Consumer : accept()

        System.out.println("\n*************************************************");
        List<List<Integer>> list1 = new ArrayList<>(List.of(
                List.of(1, 3, 5, 7),
                List.of(2, 4, 6, 8),
                List.of(2, 3, 5, 7, 11)

        ));

        list1.stream()
                .flatMap(x -> x.stream().map(y -> y * 2))
                .sorted((a, b) -> b - a)// descending order : Comparator<? super T> : compare(a,b)
                //.peek(x -> System.out.print(x+ " "))
                .distinct()
                .forEach(k -> System.out.print(k + " "));

        System.out.println("\n*************************************************");
        Stream.iterate(20, x -> x - 1)
                .limit(20)
                .peek(x -> System.out.print(x + " "))
                .skip(5)// skips first 5 elements
                .forEach(x -> System.out.print(x + " "));

        System.out.println("\n*************************************************");
        list.stream()
                .filter(x -> x > 10 && x % 2 == 0)
                .map(x -> x + 1)
                .forEach(x -> System.out.print(x + " "));
        //Terminal methods
        //basic collection
        System.out.println("\n************* COLLECTING RESULT(toList()) ************************************");
        List<Integer> iList = list.stream()
                .filter(x -> x > 10 && x % 2 == 0)
                .map(x -> x / 2)
                .toList();// immutable list
        for (Integer i : iList) {
            System.out.print(i + " ");
        }
        System.out.println("\n***************COLLECTING RESULT(toSet()) **********************************");
        Set<Integer> set = list.stream()
                .filter(x -> x % 3 == 0)
                .collect(Collectors.toSet());//mutable set/list
        set.add(9);
        for (Integer i : set) {
            System.out.print(i + " ");
        }

        System.out.println("\n***************COLLECTING RESULT(toMap()) **********************************");
        List<String> list2 = new ArrayList<>(List.of("A", "BB", "CCC", "DDDD"));
        Map<Integer, String> testMap = list2.stream()
                .collect(Collectors.toMap(String::length, x -> x));
        System.out.println(testMap);

        //special collection : groupingBy()
        System.out.println("\n***************COLLECTING RESULT(groupingBy()) **********************************");
        List<String> list3 = new ArrayList<>(List.of("A", "BB", "CCC", "DDDD", "R", "E", "XX", "FFF", "TTT", "KK"));
        Map<Integer, List<String>> grouping = list3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouping);
        //real time case
        // employee.collect(Collectors.groupingBy(Employee :: getDepartment)

        //partitioningBy : two group only either true or false
        System.out.println("\n***************COLLECTING RESULT(partitioningBy()) **********************************");
        Map<Boolean, List<Integer>> ptest = list.stream()
                .filter(x -> x > 2)
                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("even test : " + ptest);

        //groupingBy(mapper, collector) :
        System.out.println("\n***************COLLECTING RESULT(groupingBy(mapper,collector)) **********************************");
       Map<Integer,List<String>> mapperMap = list3.stream()
               .collect(Collectors.groupingBy(
                       String::length,
                       Collectors.mapping(String::toLowerCase,Collectors.toList())));
       //grouping by length, map to lowercase and result should be in list.
        System.out.println(mapperMap);

        System.out.println("\n***************COLLECTING RESULT(joining) **********************************");
        String result = list3.stream().collect(Collectors.joining("-"));// join via delimiter '-'
        System.out.println(result);


        System.out.println("\n******************REDUCING RESULT*******************************");
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Optional<Integer> sum = integerList.stream().reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);

        int sum1 = integerList.stream().reduce(0, (a, b) -> a + b);// 0 - is identity
        System.out.println(sum1);

        Long count = list.stream().map(x -> x + 3).count();
        System.out.println(count);

        System.out.println("\n***************** SEARCHING ELEMENT ********************************");
        Optional<Integer> num = integerList.stream()
                .filter(x -> x > 5)
                .findFirst();
        //.findAny();
        System.out.println(num.get());

        boolean test = integerList.stream()
                .filter(x -> x > 5)
                .anyMatch(x -> x % 2 == 0);
        //primitive Stream operation
        System.out.println("\n********************* PRIMITIVE STREAM **************************");
        System.out.println(test);
        int sum2 = integerList.stream()
                .mapToInt(x -> x)
                .sum();
        System.out.println(sum2);


    }
}
/*   LIST OF INTERMEDIATE OPERATION
    -  filter() : stateless -> no need all element
    -  map() : stateless
    -  fatMap()
    -  sorted() : stateful -> need all element -> boolean compare(int a, int b){ return a - b  }
    -  sorted(Comparator< ? super T> comp)
            sorted( (a,b) -> b - a => descending order : override compare method
    -  distinct() : keep unique values(internally use Hashing)
    -  limit() ;
    -  skip() :
    -  peek() : useful for debagging : looks in pipeline
    -  mapToInt():
    -  mapToDouble():
    -  mapToLong():
 */

/*   LIST OF TERMINAL OPERATION
  1. Collecting Result :
       - toList(): returns immutable list of stream
       - collect(): most powerful method in Stream Api, java provide Collector interface with plenty of methods.
                    we can collect our stream in multiple ways in multiple data structure. mutable collection.
                    - Collectors.toList()
                    - Collectors.groupingBy(...)
                    - Collectors.groupingBy(mapper,collector)
                    - Collectors.joining("delimiter")
  2. Reducing : reduce a stream to a particular value like min, max ...
        - reduce(): combine stream elements into single element.
        - sum(), max() , min(), avarage(),count()... => primitives stream
  3. Searching/Matching
        - findFirst() => returns first passed element from filter
        - findAny() => returns any element that pass through filer, useful in parallel stream.
        - anyMatch(), allMatch(), noneMatch() => returns boolean i.e. Predicate FI
  4. Iteration
        - forEach() => elements fetch one by one : sequential stream
        - forEachOrdered() : parallel stream uses threads => elements could fetch parallelly in a stream.


 */
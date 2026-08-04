package java8;



import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamsTest {
    public static void main(String[] args) {
        List<List<Integer>> nested = List.of(List.of(1,2), List.of(3,4));

// map keeps the nested structure: Stream<List<Integer>>
        nested.stream().map(l -> l).forEach(System.out::println);

// flatMap flattens into a single Stream<Integer>: 1 2 3 4
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        flat.forEach(System.out::print);

        int[] arr = {1,2,3,4};
        System.out.println(Stream.of(arr).toList());

        System.out.println(Arrays.toString(arr));

        Map<String, Integer> map = new HashMap<>();
        map.put("c", 3); map.put("a", 1); map.put("b", 2);

        Map<String, Integer> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);


        List<Integer> nums = List.of(1, 2, 3, 2, 4, 3, 5);
        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicates = nums.stream()
                .filter(n -> !seen.add(n))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(duplicates);
        nums.stream().collect(groupingBy(a->a,counting()))
                .entrySet().stream().filter(e -> e.getValue() >= 2)
                .map(Map.Entry::getKey)   // extract the duplicate element
                .toList().forEach(System.out::println);

       duplicates = nums.stream()
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .flatMap(e -> Stream.of(e.getKey()))   // flatten keys into the stream
                .collect(Collectors.toList());
       System.out.println(duplicates);


        //second highest

        nums = List.of(5, 1, 9, 3, 9, 7);
        System.out.println(nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


        Map<String, Integer> map1 = new HashMap<>(Map.of("a", 10, "b", 20));
        Map<String, Integer> map2 = new HashMap<>(Map.of("b", 5, "c", 30));

        Map<String, Integer> merged = Stream.of(map1, map2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, Integer::sum));



        System.out.println(merged);
        merged = Stream.of(map1, map2).flatMap(m->m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::max));
        System.out.println(merged);

       nums = List.of(1, 2, 3, 4, 5, 6, 7);

        Map<Boolean, List<Integer>> partitioned = nums.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitioned.get(true));  // [2, 4, 6]
        System.out.println(partitioned.get(false)); // [1, 3, 5, 7]

        int n = 8;

        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(n)
                .map(f -> f[0])
                .forEach(x -> System.out.print(x + " "));


        System.out.println(IntStream.range(1, 5).reduce(1, (a, b) -> a * b));
        System.out.println(LongStream.rangeClosed(1, 5).reduce(1, (a, b) -> a * b));

        //Find all  prime numbers
       // 1,3,5,7

        List<Integer> primes = IntStream.rangeClosed(2, 10)
                .filter(num -> IntStream.rangeClosed(2, (int) Math.sqrt(num))
                        .allMatch(div -> num % div != 0 || num == div))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(IntStream.rangeClosed(2, (int) Math.sqrt(20)).toArray()));

        System.out.println(primes);


        String input = "Java Streams";
        String vowels = "aeiouAEIOU";

        long vowelCount = input.chars()
                .filter(c -> vowels.indexOf(c) != -1)
                .count();

        long consonantCount = input.chars()
                .filter(Character::isLetter)
                .filter(c -> vowels.indexOf(c) == -1)
                .count();
        System.out.println(vowelCount);
        System.out.println(consonantCount);

        CompletableFuture.supplyAsync(() -> 10)
                .thenApply(x -> x * 2)          // 20, keeps value
                .thenAccept(System.out::println) // prints 20, no return value
                .thenRun(() -> System.out.println("Done"));










    }
}

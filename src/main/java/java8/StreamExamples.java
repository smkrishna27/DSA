package java8;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StreamExamples {
    public static void main(String[] args) {
        //1. Find duplicate elements in a List using streams.
        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());

        System.out.println(duplicates); // [1, 2]
       // 2. Count the occurrences of each character in a String.
                String input = "programming";

        Map<Character, Long> freq = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        freq.forEach((k, v) -> System.out.println(k + ": " + v));
       // 3. Find the second-highest number in a List using streams.
        List<Integer> nums = List.of(10, 5, 20, 8, 20, 3);

        Optional<Integer> second = nums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        second.ifPresent(System.out::println); // 10
       // 4. Group a list of employees by department, and find the highest-paid employee per department.
              List<Employee> employees = new ArrayList<>();
                Map<String, Optional<Employee>> topEarnerByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
      //  5. Sort a list of custom objects by multiple fields (e.g., by department, then by name).
                List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getName))
                .collect(Collectors.toList());
      //  6. Find the sum, average, max, and min of a list of numbers using IntStream.
        List<Integer> nums1 = List.of(4, 8, 15, 16, 23, 42);

        IntSummaryStatistics stats = nums1.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println("Sum: " + stats.getSum());
        System.out.println("Avg: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
      //  7. Convert a List<String> to a comma-separated String.
                List<String> names = List.of("Alice", "Bob", "Charlie");

        String joined = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(joined); // [Alice, Bob, Charlie]
       // 8. Check if a String is a palindrome using streams.
                String str = "madam";

        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));

        System.out.println(isPalindrome); // true
      //  9. Find the first non-repeated character in a String.
        String input1 = "swiss";

        Map<Character, Long> counts = input1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Character firstUnique = counts.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(firstUnique); // w
      //  10. Merge two Maps, summing values for duplicate keys.
        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
        Map<String, Integer> map2 = Map.of("b", 3, "c", 4);

        Map<String, Integer> merged = Stream.of(map1, map2)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum));

        System.out.println(merged); // {a=1, b=5, c=4}

    }
}

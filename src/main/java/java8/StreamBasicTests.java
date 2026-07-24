package java8;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class StreamBasicTests {

    public static void main(String[] args) {
        //find sum of all numbers java
        List<Integer> nums1 = List.of(4, 8, 15, 16, 23, 42);
        int sum = nums1.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum " + nums1.stream().reduce(0, Integer::sum));

        System.out.println("total Sum " + sum);
        //Find the Product of All Elements in a List
        List<Integer> products = List.of(1, 2, 3, 4);
        int product = products.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product " + product);
        //Find the Average of All Elements in a List
        List<Integer> products1 = List.of(1, 2, 3, 4);
        System.out.println("Average " + products1.stream().mapToInt(Integer::intValue).average().orElse(0));
        //Find the Maximum Element in a List
        List<Integer> elements = List.of(1, 5, 3, 4, 6, 2, 4);
        System.out.println("Maximum " + elements.stream().mapToInt(Integer::intValue).max().orElse(0));
        System.out.println("Maximum " + elements.stream().reduce(0, Integer::max));
        // Find the Minimum Element in a List
        System.out.println("Minimum " + elements.stream().mapToInt(Integer::intValue).min().orElse(0));
        //Count the Number of Elements in a List
        System.out.println("Count " + elements.stream().count());
        // Check if a List Contains a Specific Element
        System.out.println("3ElementPresent " + elements.stream().anyMatch(a -> a == 3));
        System.out.println("8ElementPresent " + elements.stream().anyMatch(a -> a == 8));
        //Filter Out Even Numbers from a List
        System.out.println("filterEventnumber " + elements.stream().filter(a -> a % 2 == 0).toList());
        //Convert a List of Strings to Uppercase
        List<String> strings = List.of("Hello", "World");
        System.out.println("strings " + strings.stream().map(s -> s.toUpperCase()).toList());
        //Convert a List of Integers to Their Squares
        System.out.println("squares " + elements.stream().map(a -> a * a).toList());
        //Find the First Element in a List
        System.out.println("firstElement " + elements.stream().findFirst().get());
        //Find the Last Element in a List
        System.out.println("lastElement " + elements.stream().reduce((a, b) -> b).get());
        //Check if All Elements in a List Satisfy a Condition
        System.out.println("condition satisfied " + elements.stream().allMatch(a -> a % 2 == 0));
        //Check if Any Element in a List Satisfies a Condition
        System.out.println("any match " + elements.stream().anyMatch(a -> a % 2 == 0));
        //Remove Duplicate Elements from a List
        System.out.println("remove Duplicates " + elements.stream().distinct().toList());
        //Sort a List of Integers in Ascending Order
        System.out.println("sort " + elements.stream().sorted().toList());
        // Sort a List of Integers in Descending Order
        System.out.println("desc sort " + elements.stream().sorted().toList().reversed());
        System.out.println("desc sort " + elements.stream().sorted(Comparator.reverseOrder()).toList());
        // Sort a List of Strings in Alphabetical Order
        List<String> strings1 = List.of("Hello", "Word", "Apples");
        System.out.println("strings Alphabet " + strings1.stream().sorted().toList());
        //Sort a List of Strings by Their Length
        System.out.println("sort by Length" + strings1.stream().sorted(Comparator.comparing(String::length)).toList());
        System.out.println("sort by length" + strings1.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) return -1;
                return 0;
            }
        }).toList());

        //Find the Sum of Digits of a Number
        int num = 12345;
        System.out.println("sum value " + String.valueOf(num).chars().map(Character::getNumericValue).sum());
        //Find the Factorial of a Number
        int number = 5;
        System.out.println("Factorial " + IntStream.rangeClosed(1, number).reduce((a, b) -> a * b).orElse(0));
        //Find the Second-Largest Element in a List
        //(1, 5, 3, 4,6,2,4)
        System.out.println("2ndLarget " + elements.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        //Find the Second-Smallest Element in a List
        System.out.println("2ndSmallest " + elements.stream().sorted().skip(1).findFirst().get());
        //Find the Longest String in a List
        System.out.println("longest String " + strings1.stream().max(Comparator.comparing(String::length)).get());
        //Find the Shortest String in a List
        System.out.println("smallest String " + strings1.stream().min(Comparator.comparing(String::length)).get());
        //Group a List of Strings by Their Length
        strings1 = List.of("Hello", "World", "Apples");
        System.out.println("groupOf List by size" + strings1.stream().collect(groupingBy(String::length)));

        //Group a List of Objects by a Specific Attribute
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 25)
        );
        Map<Integer, List<Person>> map = people.stream().collect(groupingBy(Person::getAge));
        System.out.println("group By Age" + map);
        //Partition a List of Integers into Even and Odd Numbers
        Map<Boolean, List<Integer>> partitioned = elements.stream().collect(Collectors.partitioningBy(a -> a % 2 == 0));
        System.out.println("partition " + partitioned);
        //Merge Two Lists into a Single List
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(5, 6, 7, 8);
        List<Integer> merge = Stream.concat(list1.stream(), list2.stream()).toList();
        System.out.println("merge " + merge);
        //Find the Intersection of Two Lists
        System.out.println("intersection " + list1.stream().filter(list2::contains).toList());
        //Find the Union of Two Lists
        System.out.println("union " + Stream.concat(list1.stream(), list2.stream()).distinct().toList());
        //Find the Difference Between Two Lists
        System.out.println("difference " + list1.stream().filter(n -> !list2.contains(n)).toList());
        //Count the Occurrences of Each Element in a List
        List<String> words = List.of("apple", "banana", "apple", "orange");
        Map<String, Long> word = words.stream().collect(Collectors.groupingBy(
                s -> s, Collectors.counting()
        ));
        System.out.println("word " + word);
        //Count the Occurrences of Each Character in a String
        String input = "hello";
        Map<Character, Long> charCounts = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Character Counts: " + charCounts);
        //Count the Occurrences of Each Word in a String
        String inputS = "hello world hello";
        Map<String, Long> stringsL = Arrays.stream(inputS.split(" ")).collect(groupingBy(s -> s, Collectors.counting()));
        System.out.println("stringsL " + stringsL);
        //Count the Occurrences of Each Vowel in a String
        inputS = "Hello How are you";
        Map<Character, Long> result = inputS.chars().mapToObj(c -> (char) c).filter(c1 -> "aeiou".contains(String.valueOf(c1))).collect(groupingBy(c -> c, Collectors.counting()));
        //Vowel Counts: {e=1, o=2}
        System.out.println("result " + result);
        // Count the Occurrences of Each Digit in a String
        input = "hello 123 world 456";
        System.out.println("allCounts " + input.chars().mapToObj(c -> (char) c).filter(Character::isDigit).count());
        Map<Character, Long> digitCounts = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Digit Counts: " + digitCounts);
        //Reverse a List Using Streams
        System.out.println("allCounts " + elements.stream().collect(Collectors.collectingAndThen(toList(), list -> {
            Collections.reverse(list);
            return list;
        })));
        //Reverse a String Using Streams
        inputS = "hello";
        System.out.println(inputS.chars().mapToObj(c -> String.valueOf((char) c)).reduce("", (a, b) -> b + a));
//        Advanced Level Questions (41–60)
//        41. Find the Most Frequent Element in a List
       words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
       //apple





    }

    @Data
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }


    }
}

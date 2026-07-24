package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAdvancedTests {
    public static void main(String[] args) throws IOException {
        //Find the Most Frequent Element in a List
        //apple
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())));
        String mostFrequent = words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("most repeated " + mostFrequent);
        //Find the Least Frequent Element in a List
        String mostInFrequent = words.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("most inFrequent " + mostInFrequent);
        //Find the First Non-Repeated Character in a String
        String word="hello";
       char first= word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c-> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("fist non Repeat " + first);
        // Find the First Repeated Character in a String
        char firstRepeated=word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c-> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("first Repeat " + firstRepeated);
        //Check if a String is a Palindrome
        String word1="smadams";
        boolean isPalindrome= IntStream.range(0, word1.length()/2).
                allMatch(i->word1.charAt(i)==word1.charAt(word1.length()-1-i));
        System.out.println("isPalindrome " + isPalindrome);
        //Find All Anagrams of a String from a List
         words = List.of("listen", "silent", "enlist", "google", "inlets");
        String target = "silent";
       List<String> anagrams= words.stream().filter(word2 -> Arrays.equals(word2.chars().sorted().toArray(),target.chars().sorted().toArray()))
                .toList();
        System.out.println("anagrams " + anagrams);
        //Generate the Fibonacci Sequence Using Streams
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]}).limit(5).
                map(fib -> fib[0]).forEach(System.out::println);
        //Generate a List of Random Numbers Using Streams
        List<Integer> numbers = Stream.generate(()->new Random().nextInt(100)).limit(5).toList();
        System.out.println("numbers " + numbers);
        //Flatten a List of Lists into a Single List
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> list = listOfLists.stream().flatMap(List::stream).toList();
        System.out.println("listOfList " + listOfLists);
        System.out.println("list " + list );
        // Find the Sum of All Even Numbers in a Nested List
        System.out.println("sum of Even "+ listOfLists.stream().flatMap(List::stream).filter(e -> e % 2 == 0)
                .mapToInt(Integer::intValue).sum());
        //Find the Sum of All Odd Numbers in a Nested List
        System.out.println("sum of Odd "+ listOfLists.stream().flatMap(List::stream).filter(e -> e % 2 != 0)
                .mapToInt(Integer::intValue).sum());
        //Find the Longest Palindrome in a List of Strings
        words = List.of("madam", "racecar", "apple", "banana", "level");
       String longest= words.stream().filter(word2->word2.equals(new StringBuilder(word2).reverse().toString())).
                max(Comparator.comparing(String::length)).orElse("");
       System.out.println("longest " + longest);
       //Find the Shortest Palindrome in a List of Strings
        String shortest= words.stream().filter(word2->word2.contentEquals(new StringBuilder(word2).reverse())).
                min(Comparator.comparing(String::length)).orElse("");
        System.out.println("shorted " + shortest);
        //Find the Longest Word in a String
        String input = "hello world this is a test";
         longest= Arrays.stream(input.split(" ")).max(Comparator.comparing(String::length)).orElse("");
        System.out.println("longest " + longest);
        //Find the Shortest Word in a String
        shortest= Arrays.stream(input.split(" ")).min(Comparator.comparing(String::length)).orElse("");
        System.out.println("shorted " + shortest);
        //Find the Number of Words in a String
        System.out.println("count "+ Arrays.stream(input.split(" ")).count());
        //Find the Number of Lines in a File
        Path path = Paths.get("src/main/resources/sample.txt");
        long lineCount = Files.lines(path).count();
        System.out.println("Line Count: " + lineCount);
        //Find the Number of Characters in a File
        System.out.println("charCount " +Files.lines(path).flatMapToInt(String::chars).count());
        //Find the Number of Words in a File
        System.out.println("wordCount " +Files.lines(path).flatMap(line -> Arrays.stream(line.split(" "))).count());
        //Find the Number of Unique Words in a File
        System.out.println("uniqueWords " +Files.lines(path).flatMap(line -> Arrays.stream(line.split(" "))).distinct().
                toList());
        System.out.println("uniqueWordCount " +Files.lines(path).flatMap(line -> Arrays.stream(line.split(" "))).distinct().
               count());










    }
}

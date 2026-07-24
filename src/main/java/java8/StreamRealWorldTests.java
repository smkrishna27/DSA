package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamRealWorldTests {
    public static void main(String[] args) {
        //Combine Multiple Asynchronous Tasks
        CompletableFuture<List<Integer>> future1 = CompletableFuture.supplyAsync(() -> List.of(1, 2, 3));
        CompletableFuture<List<Integer>> future2 = CompletableFuture.supplyAsync(() -> List.of(4, 5, 6));
        List<Integer> combined = Stream.of(future1, future2)
                .map(CompletableFuture::join)
                .flatMap(List::stream)
                .toList();
        System.out.println("Combined List: " + combined);

        //Process Large Datasets in Parallel
        List<Integer> numbers = IntStream.rangeClosed(1, 100000).boxed().toList();
        long start = System.currentTimeMillis();
        long sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("time: " + (System.currentTimeMillis() - start));
        System.out.println("Sum: " + sum);

        //Group Employees by Department and Calculate Average Salary
        //Average Salary by Department: {HR=52500.0, IT=60000.0}
        List<Employee1> employees = List.of(
                new Employee1("Alice", "HR", 50000),
                new Employee1("Bob", "IT", 60000),
                new Employee1("Charlie", "HR", 55000)
        );
        Map<String, Double> departments = employees.stream().
                collect(groupingBy(Employee1::getDepartment, Collectors.averagingInt(Employee1::getSalary)));
        System.out.println("departments: " + departments);
        //Find the Top N Highest-Paid Employees
        List<Employee1> employee1List = employees.stream().sorted(Comparator.comparingInt(Employee1::getSalary).reversed()).limit(2).toList();
        System.out.println("employeeNHighest-Paid : " + employee1List);
         employee1List = employees.stream().sorted(Comparator.comparingInt(Employee1::getSalary).reversed()).skip(1).toList();
        System.out.println("demployee2Highest-Paid : " + employee1List.stream().findFirst().get());
        //String Manipulation Questions (71–80)
        //71. Remove All Vowels from a String
          String input = "hello world";
          String output = input.chars().filter(c->!"aeiou".contains(String.valueOf((char)c)))
                  .mapToObj(c ->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("remove vowels: " + output);
        //Remove All Consonants from a String
        output =input.chars().filter(c->"aeiou".contains(String.valueOf((char)c)))
                .mapToObj(c ->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("remove Consonants: " + output);
        //Remove All Digits from a String
        input = "hello  123 world 456";
        output =input.chars().filter(c-> !Character.isDigit(c))
                .mapToObj(c ->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("remove digits: " + output);
        //Remove All Special Characters from a String
        input = "hello@123 world";
        output=input.chars().filter(c-> Character.isLetterOrDigit(c) || Character.isWhitespace(c))
                .mapToObj(c ->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("remove speical: " + output);
        //Extract All Digits from a String and Sum Them
        input = "hello  123 world 456";
        sum=input.chars().filter(c->Character.isDigit(c)).map(Character::getNumericValue).sum();

        System.out.println("sum: " + sum);
        //Extract All Words from a String and Count Their Occurrences
         input = "hello world hello";
        System.out.println(Arrays.stream(input.split(" ")).collect(groupingBy(s -> s, Collectors.counting())));
        //Extract All Unique Words from a String
        System.out.println( Arrays.stream(input.split(" ")).distinct().toList());
        //Extract All Palindromic Words from a String
        //Palindromes: [madam, racecar, level]
        input = "madam racecar apple banana level";
        List<String> strings = Arrays.stream(input.split(" "))
                .filter(s->s.contentEquals(new StringBuilder(s).reverse())).toList();
        System.out.println("matched palindrome: " + strings);
        //Extract All Words Starting with a Specific Letter
        input = "hello world this is a test";
        strings = Arrays.stream(input.split(" "))
                .filter(s->s.startsWith("t")).toList();
        System.out.println("matched start words: " + strings);
        //Extract All Words Ending with a Specific Letter
        strings = Arrays.stream(input.split(" "))
                .filter(s->s.endsWith("d")).toList();
        System.out.println("matched end words: " + strings);








    }
}

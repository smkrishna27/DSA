import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//import static java.lang.StringTemplate.STR;

record Employee(String name, int age) {}

public class MainJava21Features {
    public static void main(String[] args) {
        //java 21 features
        //switch case changes
        Object obj = 10;

        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            default -> "Unknown";
        };

        System.out.println(result);

        //record class
        Employee emp = new Employee("Rahul", 25);

        if (emp instanceof Employee(String name, int age)) {
            System.out.println(name + " " + age);
        }
     //String template
        String name1 = "Nisha";
        //System.out.println(STR."Hello \{name1}, welcome to GeeksForGeeks!");

        //Unnamed Patterns and Variables
       /* if (emp instanceof Employee(_, int age)) {
            System.out.println( age);
        }*/
        // JDK 21 has introduced virtual threads to the Java platform, where as they can do tasks quickly without allocating much resources and space in the memory


        //There are various advantages to using virtual threads:
        //
        //Increases the availability of applications
        //Enhances application throughput.
        //Reduces the occurrence of 'OutOfMemoryError: Unable to Create New Native Thread'.
        //Reduces the amount of memory used by the application
        //Enhances code quality
        //Platform Threads are completely compatible with them.

        AtomicInteger i= new AtomicInteger();
        Thread.startVirtualThread(() -> {
            for(int j=0;j<10;j++){
               i.getAndIncrement();
            }
            System.out.println("Virtual Thread Running");
        });


        System.out.println(i.getAndIncrement());


        //Performance Improvements
        //Z Garbage Collector (ZGC) cleans memory concurrently without stopping application threads.
        //Memory is divided into “new” and “old” objects.
        //New objects (short-lived) are cleaned frequently to free up space.
        //Old objects (long-lived) are retained to avoid unnecessary cleanup.
        //Ensures efficient memory management and keeps applications fast and responsive.


        List list = new ArrayList();
      //  list.stream().filter(s->null).collect(Collectors.toMap())
    }


}
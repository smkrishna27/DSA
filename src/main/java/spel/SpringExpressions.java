package spel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpringExpressions {


    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello, ' + 'World!'");
        String message = (String) exp.getValue();
        System.out.println(message); // Hello, World!


        Employee emp = new Employee();
        emp.setName("Krishna");
        emp.setSalary(95000);

        //ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(emp);

        String name = parser.parseExpression("name").getValue(context, String.class);
        Double salary = parser.parseExpression("salary * 1.10")
                .getValue(context, Double.class);

        System.out.println(name);   // Krishna
        System.out.println(salary); // 104500.0


        exp = parser.parseExpression("name.toUpperCase()");
        String upper = exp.getValue(context, String.class);
        System.out.println(upper);

// Constructor invocation
        Expression newObj = parser.parseExpression(
                "new String('SpEL Constructor Demo')");
        String created = newObj.getValue(String.class);
        System.out.println(created);

        // Inline list
        Expression listExp = parser.parseExpression("{1, 2, 3, 4, 5}");
        List<?> numbers = (List<?>) listExp.getValue();
        System.out.println(numbers);

// Inline map
        Expression mapExp = parser.parseExpression(
                "{name:'Krishna', role:'Architect'}");
        Map<?, ?> map = (Map<?, ?>) mapExp.getValue();
        System.out.println(map);

// Array creation
        Expression arrExp = parser.parseExpression("new int[]{10, 20, 30}");
        int[] arr = (int[]) arrExp.getValue();
        System.out.println(Arrays.toString(arr));

        List<Employee> employees = List.of(
                new Employee("A", 25, 40000),
                new Employee("B", 35, 60000),
                new Employee("C", 45, 90000)
        );

        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("employees", employees);

// Selection: employees older than 30
        List<?> senior = (List<?>) parser
                .parseExpression("#employees.?[age > 30]")
                .getValue(ctx);
        System.out.println(senior);

// Projection: extract just the names
        List<?> names = (List<?>) parser
                .parseExpression("#employees.![name]")
                .getValue(ctx);
        System.out.println(names);

// First/last match
        Employee first = (Employee) parser
                .parseExpression("#employees.^[age > 30]")
                .getValue(ctx);
        Employee last = (Employee) parser
                .parseExpression("#employees.$[age > 30]")
                .getValue(ctx);
        System.out.println(first);
        System.out.println(last);


        Person person = new Person();
        person.name = "Krishna";
// person.address is null

        EvaluationContext ctx2 = new StandardEvaluationContext(person);

// Safe navigation avoids NullPointerException
        String city = parser.parseExpression("address?.city")
                .getValue(ctx2, String.class); // null, no exception
        System.out.println(city);

// Elvis operator: fallback when null/empty
        String displayCity = parser.parseExpression("address?.city ?: 'Unknown'")
                .getValue(ctx2, String.class); // "Unknown"
        System.out.println(displayCity);


        String grade = parser.parseExpression(
                        "salary > 50000 ? 'Senior' : 'Junior'")
                .getValue(context, String.class);

        boolean isEmail = Boolean.TRUE.equals(parser.parseExpression(
                        "'krishna@example.com' matches " +
                                "'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'")
                .getValue(Boolean.class));
        System.out.println(isEmail);
        System.out.println(grade);
        class StringUtils {
            public static String reverse(String input) {
                return new StringBuilder(input).reverse().toString();
            }
        }

        StandardEvaluationContext ctx3 = new StandardEvaluationContext();
        ctx3.registerFunction("reverse",
                StringUtils.class.getDeclaredMethod("reverse", String.class));

        String reversed = parser
                .parseExpression("#reverse('SpEL')")
                .getValue(ctx3, String.class); // "LEpS"

        System.out.println(reversed);

// Setting and using variables
        ctx3.setVariable("bonus", 5000);
        Double total = parser.parseExpression("100000 + #bonus")
                .getValue(ctx3, Double.class);
        System.out.println(total);


    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private String name;
    private double salary;
    private int age;
    // getters/setters omitted
}

@Data
class Address {
    String city;
}

@Data
class Person {
    String name;
    Address address;
}


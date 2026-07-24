package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmails {

    public static void main(String[] args) {
        //abc.xyz@gmail.com
        //abcxy.z@gmail.com
        //abcxyz+1@gmail.com

        System.out.println(validEmails(new String[]{"abc.xyz@gmail.com", "abcxy.z@gmail.com", "abcxyz+1@gmail.com","abcxyz1@gmail.com"}));

    }

    public static List<String> validEmails(String[] emails) {
        Set<String> uniqueResults = new HashSet<>();
        for (String email : emails) {
            //abc.xyz arr[0] //abcxyz+1
            // gmail.com [1]
            String[] array = email.split("@");

            String result = array[0].replace(".", "");
            if (result.contains("+")) {
                result = result.substring(0, result.indexOf("+"));
            }
            result =result+"@"+array[1];

            uniqueResults.add(result);


        }


        return  uniqueResults.stream().toList();


    }
}

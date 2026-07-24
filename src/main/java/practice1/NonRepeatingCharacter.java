package practice1;

import java.util.HashMap;
import java.util.LinkedHashMap;

//First non-repeating character in a string.
public class NonRepeatingCharacter {
    public static void main(String[] args) {

        System.out.println(nonRepeatingCharacter("abacd"));

    }

    //First non-repeating character in a string.
    public static char nonRepeatingCharacter(String str) {

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return 0;

    }

}

package java8;

public class CountVowelsConsonants {

    public static void main(String[] args) {
        String str = "TCS Interview";
        String vowel = "aeiouAEIOU";
        int vowels=0;
        int consonants=0;

        for (char c :str.toCharArray()) {
            if (vowel.indexOf(c) != -1) {
                vowels++;
            }  else {
                consonants++;
            }
        }
        System.out.println(vowels+" "+consonants);
    }
}

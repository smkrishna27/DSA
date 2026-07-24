package java8;

public class PrimeCheck {

    public static void main(String[] args) {
        int num=27;
        boolean isprime=true;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                isprime = false;
                break;
            }
        }

        System.out.println(isprime);

    }
}

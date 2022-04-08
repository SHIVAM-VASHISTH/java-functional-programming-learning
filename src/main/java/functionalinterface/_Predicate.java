package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        // Normal Function
        System.out.println("Normal Function -----");
        System.out.println(isPhoneNumberValid("9123456789"));
        System.out.println(isPhoneNumberValid("7000000000"));

        // Functional Interface Predicate
        System.out.println("Functional Interface Predicate -----");
        System.out.println(isPhoneNumberValidPredicate.test("8888888888"));
        System.out.println(isPhoneNumberValidPredicate.test("9234588888"));

        // Predicate with and()
        System.out.println("Predicate with and() -----");
        System.out.println(containsNumber3.and(isPhoneNumberValidPredicate).test("9312344444"));
        System.out.println(containsNumber3.and(isPhoneNumberValidPredicate).test("8989398999"));
        System.out.println(containsNumber3.and(isPhoneNumberValidPredicate).test("9122222222"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("9") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("9") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

}

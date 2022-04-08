package combinatorpattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
                "alicegmail.com",
                "+08238499",
                LocalDate.of(2000, 1, 1));

        System.out.println(new CustomerValidateService().isValid(customer));
    }

}

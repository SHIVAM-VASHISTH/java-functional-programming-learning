package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

}

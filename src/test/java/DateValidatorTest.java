import com.sajan.calculator.dto.CustomDate;
import com.sajan.calculator.exceptions.DateValidationException;
import com.sajan.calculator.validators.DateValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DateValidatorTest {

    private DateValidator validator = new DateValidator();

    @Test()
    public void validate_should_return_true_for_valid_input_date() throws DateValidationException {
        assertTrue(validator.validate("2019-02-02"));
        assertTrue(validator.validate("2019-12-31"));
        assertTrue(validator.validate("2019-01-31"));
        assertTrue(validator.validate("1901-01-01"));
        assertTrue(validator.validate("2999-12-30"));
        assertTrue(validator.validate("2999-12-31"));
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_outside_date_range1() throws DateValidationException {
        validator.validate("1900-23-02");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_outside_date_range2() throws DateValidationException {
        validator.validate("3000-23-02");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date1() throws DateValidationException {
        validator.validate("2019-23-02");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date2() throws DateValidationException {
        validator.validate("2019-00-00");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date3() throws DateValidationException {
        validator.validate("2019-01-00");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date4() throws DateValidationException {
        validator.validate("123-13-02");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date5() throws DateValidationException {
        validator.validate("123-10-34");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date6() throws DateValidationException {
        validator.validate("abcd");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date7() throws DateValidationException {
        validator.validate("2013-12-03-01");
    }

    @Test(expected = DateValidationException.class)
    public void validate_should_throw_exception_for_invalid_date_range() throws DateValidationException {
        validator.validateDateRange(new CustomDate(03,12,2013),new CustomDate(02,12,2013));
    }
}

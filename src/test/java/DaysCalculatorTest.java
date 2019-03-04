import com.sajan.calculator.DaysCalculator;
import org.junit.Assert;
import org.junit.Test;

import static com.sajan.calculator.DaysCalculator.DAYS_RESULT_PREFIX;

public class DaysCalculatorTest {

    private DaysCalculator daysCalculator = new DaysCalculator();

    @Test
    public void test_calculate_days_should_throw_error_on_invalid_input(){
        String startDateInput = "";
        String endDateInput ="";
        String expectedOutput = "Invalid date format for input .  Please enter in yyyy-mm-dd format";
        Assert.assertEquals(expectedOutput, daysCalculator.calculateDays(startDateInput, endDateInput));
    }

    @Test
    public void test_calculate_days_should_return_correct_result_on_valid_input1(){
        String startDateInput = "2000-01-01";
        String endDateInput ="2000-01-03";
        String expectedOutput = String.format(DAYS_RESULT_PREFIX,startDateInput,endDateInput,1);
        Assert.assertEquals(expectedOutput, daysCalculator.calculateDays(startDateInput, endDateInput));
    }

    @Test
    public void test_calculate_days_should_return_correct_result_on_valid_input2(){
        String startDateInput = "1972-11-07";
        String endDateInput ="1972-11-08";
        String expectedOutput = String.format(DAYS_RESULT_PREFIX,startDateInput,endDateInput,0);
        Assert.assertEquals(expectedOutput, daysCalculator.calculateDays(startDateInput, endDateInput));
    }

    @Test
    public void test_calculate_days_should_return_correct_result_on_valid_input3(){
        String startDateInput = "1984-07-04";
        String endDateInput ="1984-12-25";
        String expectedOutput = String.format(DAYS_RESULT_PREFIX,startDateInput,endDateInput,173);
        Assert.assertEquals(expectedOutput, daysCalculator.calculateDays(startDateInput, endDateInput));
    }

    @Test
    public void test_calculate_days_should_return_correct_result_on_valid_input4(){
        String startDateInput = "1983-08-03";
        String endDateInput ="1989-01-03";
        String expectedOutput = String.format(DAYS_RESULT_PREFIX,startDateInput,endDateInput,1979);
        Assert.assertEquals(expectedOutput, daysCalculator.calculateDays(startDateInput, endDateInput));
    }
}
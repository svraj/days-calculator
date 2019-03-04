package com.sajan.calculator;

import com.sajan.calculator.dto.CustomDate;
import com.sajan.calculator.exceptions.DateValidationException;
import com.sajan.calculator.utils.DateUtils;
import com.sajan.calculator.validators.DateValidator;

import java.util.Scanner;

public class DaysCalculator {

    public static final String DAYS_RESULT_PREFIX = "Number of days in between %s and %s = %d ";

    private DateValidator dateValidator = new DateValidator();

    public static void main(String[] args) {
        System.out.println("Please enter start date in yyyy-mm-dd format...");
        Scanner scanner = new Scanner(System.in);
        String startDateInput = scanner.nextLine();
        System.out.println("Please enter end date in yyyy-mm-dd format...");
        String endDateInput = scanner.nextLine();

        DaysCalculator daysCalculator = new DaysCalculator();
        System.out.println(daysCalculator.calculateDays(startDateInput, endDateInput));
    }

    public String calculateDays(String startDate, String endDate) {
        String output = "";
        try {
            if (dateValidator.validate(startDate) && dateValidator.validate(endDate)) {
                CustomDate start = DateUtils.getCustomDate(startDate);
                CustomDate end = DateUtils.getCustomDate(endDate);
                if(dateValidator.validateDateRange(start,end)) {
                    output = String.format(DAYS_RESULT_PREFIX, startDate, endDate, DateUtils.calculateDays(start, end));
                }
            }
        } catch (DateValidationException e) {
            output = e.getMessage();
        }
        return output;
    }

}



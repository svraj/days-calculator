package com.sajan.calculator.validators;

import com.sajan.calculator.dto.CustomDate;
import com.sajan.calculator.exceptions.DateValidationException;

public class DateValidator {

    private static final String INVALID_INPUT_MSG_PREFIX = "Invalid date format for input %s. ";
    private static final String INVALID_DATE_RANGE_MSG = "Invalid date range. Start date must be before end date";

    private static final String INVALID_FORMAT_MSG_PREFIX = INVALID_INPUT_MSG_PREFIX + " Please enter in yyyy-mm-dd format";

    public boolean validate(String inputDate) throws DateValidationException {
        try {
            String[] dateTokens = inputDate.split("-");
            if (dateTokens.length != 3) {
                throw new DateValidationException(String.format(INVALID_FORMAT_MSG_PREFIX, inputDate));
            }
            int year = Integer.parseInt(dateTokens[0].trim());
            int month = Integer.parseInt(dateTokens[1].trim());
            int date = Integer.parseInt(dateTokens[2].trim());

            if (year < 1901 || year > 2999) {
                throw new DateValidationException(String.format(INVALID_INPUT_MSG_PREFIX, inputDate) + "Invalid Year");
            }
            if (month < 1 || month > 12) {
                throw new DateValidationException(String.format(INVALID_INPUT_MSG_PREFIX, inputDate) + "Invalid Month");
            }
            if (date < 1 || date > 31) {
                throw new DateValidationException(String.format(INVALID_INPUT_MSG_PREFIX, inputDate) + "Invalid Date");
            }
            return true;
        } catch (Exception e) {
            throw new DateValidationException(e.getMessage());
        }
    }

    public boolean validateDateRange(CustomDate startDate, CustomDate endDate) throws DateValidationException {
        if (startDate.getYear() > endDate.getYear()
                || (startDate.getYear() == endDate.getYear() && startDate.getMonth() > endDate.getMonth())
                || (startDate.getYear() == endDate.getYear() && startDate.getMonth() == endDate.getMonth()
                        && startDate.getDate() > endDate.getDate())) {
            throw new DateValidationException(INVALID_DATE_RANGE_MSG);
        }
        return true;
    }
}

package com.sajan.calculator.utils;

import com.sajan.calculator.dto.CustomDate;

public class DateUtils {

    private static int[] DAYS_IN_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static CustomDate getNextDate(CustomDate date) {
        int day = date.getDate();
        CustomDate nextDate;
        if (date.getMonth() == 2 && date.getDate() == 28) {
            int newMonth = date.getMonth();
            if (isLeapYear(date.getYear())) {
                day = 29;
            } else {
                day = 1;
                newMonth = 3;
            }
            nextDate = new CustomDate(day, newMonth, date.getYear());
        } else {
            if (day < DAYS_IN_MONTH[date.getMonth() - 1]) {
                day++;
                nextDate = new CustomDate(day, date.getMonth(), date.getYear());
            } else {
                int newDay = 1;
                if (date.getMonth() == 12) {
                    nextDate = new CustomDate(newDay, 1, date.getYear() + 1);
                } else {
                    nextDate = new CustomDate(newDay, date.getMonth() + 1, date.getYear());
                }
            }
        }
        return nextDate;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 || year % 100 == 0;
    }

    public static CustomDate getCustomDate(String startDate) {
        String[] split = startDate.split("-");
        return new CustomDate(Integer.parseInt(split[2]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[0]));
    }

    public static int calculateDays(CustomDate startDate, CustomDate endDate){
        CustomDate dateIndex = startDate;
        int totalDays = 0;
        while(!dateIndex.equals(endDate)){
            dateIndex = DateUtils.getNextDate(dateIndex);
            totalDays ++;
        }
        return totalDays>0?totalDays-1:0;
    }
}

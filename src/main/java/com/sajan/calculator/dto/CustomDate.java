package com.sajan.calculator.dto;

import java.util.Objects;

public class CustomDate {

    private int date;
    private int month;
    private int year;

    public CustomDate(int date, int month, int year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDate that = (CustomDate) o;
        return date == that.date &&
                month == that.month &&
                year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, month, year);
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "date=" + date +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public int getDate() {
        return date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
package com.epam.jmp.util;

public class RandomYear {
    private int year;
    private int startPeriod;
    private int endPeriod;

    public int getYear() {
        year = randBetween(startPeriod, endPeriod);
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(int startPeriod) {
        this.startPeriod = startPeriod;
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    /*
    * Generates random number
    */
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}

package com.epam.jmp.util;

public class RandomYear {
    private int year;

    public int getYear() {
        year = randBetween(2013, 2018);
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /*
    * Generates random number
    */
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}

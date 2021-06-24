package com.xyzcorp.instructor.library;

import java.time.LocalDate;
import java.util.StringJoiner;

public class Checkout {
    private String name;
    private String title;
    private LocalDate date;

    public Checkout(String name, String title, LocalDate date) {
        this.name = name;
        this.title = title;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Checkout.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("title='" + title + "'")
            .add("date=" + date)
            .toString();
    }
}

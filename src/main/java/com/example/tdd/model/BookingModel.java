package com.example.tdd.model;

import java.time.LocalDate;

public class BookingModel {

    private String id;
    private String reserveName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int NumberGuest;

    public BookingModel(String id, String reserveName, LocalDate checkIn, LocalDate checkOut, int numberGuest) {
        this.id = id;
        this.reserveName = reserveName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        NumberGuest = numberGuest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberGuest() {
        return NumberGuest;
    }

    public void setNumberGuest(int numberGuest) {
        NumberGuest = numberGuest;
    }
}

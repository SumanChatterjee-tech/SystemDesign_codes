package com.home.BookMyShowApplication;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    Shows show;
    List<Seats> bookedSeats = new ArrayList<>();
    Payment payment;

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public List<Seats> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seats> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

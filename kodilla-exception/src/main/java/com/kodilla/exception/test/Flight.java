package com.kodilla.exception.test;

public class Flight {
    private String arrivalAirport;
    private String departureAirport;

    public Flight(String arrivalAirport, String departureAirport) {
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }
}

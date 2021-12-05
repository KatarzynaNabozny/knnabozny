package com.kodilla.exception.test;

public class FlightSearchingAplication {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "Paris");
        try {
            if (new FlightSearchEngine().findFlight(flight)) {

                System.out.println("Flight is available");
            } else {
                System.out.println("Flight is unavailable");
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Works with exception");
        }
    }
}

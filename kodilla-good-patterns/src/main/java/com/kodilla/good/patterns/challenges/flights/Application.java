package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        List<Flight> from = flightFinder.getFlightsFrom("Kraków");
        showFlights(from, "From");
        List<Flight> to = flightFinder.getFlightsTo("Kraków");
        showFlights(to, "To");
        List<Flight> through = flightFinder.getFlightsThrough("Kraków", "Gdańsk");
        showFlights(through, "Through");
    }

    public static void showFlights(List<Flight> l, String desc) {
        System.out.println(desc);
        for (Flight f :
                l) {
            System.out.println(f);
        }
        System.out.println();
    }
}

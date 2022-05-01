package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {
    private List<Flight> db = new ArrayList<>();

    FlightFinder() {
        db.add(new Flight("Warszawa", "Kraków"));
        db.add(new Flight("Warszawa", "Rzeszów"));
        db.add(new Flight("Warszawa", "Poznań"));
        db.add(new Flight("Warszawa", "Gdańsk"));
        db.add(new Flight("Kraków", "Warszawa"));
        db.add(new Flight("Wrocław", "Warszawa"));
        db.add(new Flight("Poznań", "Warszawa"));
        db.add(new Flight("Gdańsk", "Warszawa"));
        db.add(new Flight("Kraków", "Gdańsk"));
        db.add(new Flight("Wrocław", "Gdańsk"));
    }

    public List<Flight> getFlightsFrom(String from) {
        return db.stream().filter(l -> l.getDeparture().equals(from)).collect(Collectors.toList());
    }

    public List<Flight> getFlightsTo(String to) {
        return db.stream().filter(l -> l.getArrival().equals(to)).collect(Collectors.toList());
    }

    public List<Flight> getFlightsThrough(String from, String to) {
        List<Flight> getFlightsFromAirport = getFlightsFrom(from);
        List<Flight> getFlightsToAirport = getFlightsTo(to);
        List<Flight> result = new ArrayList<>();
        for (Flight fromAirport :
                getFlightsFromAirport) {
            for (Flight toAirport :
                    getFlightsToAirport) {
                if (fromAirport.getArrival().equals(toAirport.getDeparture())) {
                    result.add(fromAirport);
                    result.add(toAirport);
                }
            }
        }
        return result;
    }
}
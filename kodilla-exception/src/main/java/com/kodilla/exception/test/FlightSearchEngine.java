package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {
    Map<String, Boolean> freeAirport;

    public Boolean findFlight(Flight flight) throws RouteNotFoundException {

        freeAirport = new HashMap<>();

        freeAirport.put("Warsaw", true);
        freeAirport.put("Berlin", true);
        freeAirport.put("Paris", false);
        freeAirport.put("Amsterdam", true);
        freeAirport.put("Roma", false);
        freeAirport.put("Vienna", true);

        Boolean isArrivalAirportAvailable = freeAirport.get(flight.getArrivalAirport());
        Boolean isDepartureAirportAvailable = freeAirport.get(flight.getDepartureAirport());
        if (isArrivalAirportAvailable == null) {
            throw new RouteNotFoundException("ArrivalAirport was null");
        }

        if (isDepartureAirportAvailable == null) {
            throw new RouteNotFoundException("DepartureAirport was null");
        }

        if (isArrivalAirportAvailable && isDepartureAirportAvailable) {
            return true;
        } else {
            return false;
        }

    }
}


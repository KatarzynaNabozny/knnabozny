package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MovieStore {

    public Map<String, List<String>> getMovies() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        booksTitlesWithTranslations.values().stream()
                .flatMap(Collection::stream)
                .map(a-> a + "!")
                .peek(System.out::print)
                .collect(Collectors.toList());

        return booksTitlesWithTranslations;
    }
}


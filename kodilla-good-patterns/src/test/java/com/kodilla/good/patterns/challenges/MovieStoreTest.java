package com.kodilla.good.patterns.challenges;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MovieStoreTest {
    private MovieStore movieStore;


    @Test
    void testGetMovies() {
        //given
        movieStore = new MovieStore();
        //when
        Map<String, List<String>> movies = movieStore.getMovies();
        //then
        Assertions.assertNotNull(movies);

    }


}
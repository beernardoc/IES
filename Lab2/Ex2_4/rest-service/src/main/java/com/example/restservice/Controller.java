package com.example.restservice;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class Controller {

    public static Set<Show> shows = new HashSet<>();

    public static HashMap<String, List<Quote>> quotes = new HashMap<>();

    public static Set<Movie> movies = new HashSet<>();

    public static void add() {
        Show s1 = new Show("Stranger Things", 4);
        Show s2 = new Show("Game of Thrones", 5);

        Movie m1 = new Movie("The Matrix", 1);
        Movie m2 = new Movie("Inception", 2);
        Movie m3 = new Movie("Pulp Fiction", 3);

        shows.add(s1);
        shows.add(s2);

        movies.add(m1);
        movies.add(m2);
        movies.add(m3);

        quotes.put("Stranger Things", new ArrayList<>(Arrays.asList(new Quote("Demogorgon in the mist!"), new Quote("Eleven is the best!"))));
        quotes.put("Game of Thrones", new ArrayList<>(Arrays.asList(new Quote("Winter is coming."), new Quote("You know nothing, Jon Snow."))));
        quotes.put("The Matrix", new ArrayList<>(Arrays.asList(new Quote("There is no spoon."), new Quote("I know kung fu."))));
        quotes.put("Inception", new ArrayList<>(Arrays.asList(new Quote("You mustn't be afraid to dream a little bigger, darling."), new Quote("Dreams feel real while we're in them."))));
        quotes.put("Pulp Fiction", new ArrayList<>(Arrays.asList(new Quote("Say 'what' again!"), new Quote("Ezekiel 25:17"))));
    }

    public Quote RandomQuote() {
        Random rand = new Random();
        String randomKey = (String) quotes.keySet().toArray()[rand.nextInt(quotes.size())];
        List<Quote> randomQuoteList = quotes.get(randomKey);
        return randomQuoteList.get(rand.nextInt(randomQuoteList.size()));

    }


    @GetMapping("api/quote")
    public ResponseEntity<Quote> quote() {
        return ResponseEntity.ok(RandomQuote());
    }

    @GetMapping("api/shows")
    public ResponseEntity<Set<Show>> shows() {
        return ResponseEntity.ok(shows);
    }

    @GetMapping("api/movies")
    public ResponseEntity<Set<Movie>> movies() {
        return ResponseEntity.ok(movies);
    }

    @GetMapping("api/quotes")
    public ResponseEntity<HashMap<String, List<Quote>>> quotes(@RequestParam(value = "show", required = false) Integer id){
        if(id == null) {
            return ResponseEntity.ok(quotes);
        }
        else {
            HashMap<String, List<Quote>> QuotesResults = new HashMap<>();
            for (Show show: shows){
                if (show.getID() == id){
                    QuotesResults.put(show.getName(), quotes.get(show.getName()));
                    return ResponseEntity.ok(QuotesResults);
                }
            }
            for(Movie movie :movies){
                if (movie.getID() == id){
                    QuotesResults.put(movie.getName(), quotes.get(movie.getName()));
                    return ResponseEntity.ok(QuotesResults);
                }
            }
            return ResponseEntity.notFound().build();
        }
    }

}
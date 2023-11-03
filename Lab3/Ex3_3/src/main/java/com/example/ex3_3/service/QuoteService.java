package com.example.ex3_3.service;

import com.example.ex3_3.entity.Quote;

import java.util.List;


public interface QuoteService {

    Quote createQuote(Quote quote);

    Quote getQuoteByID(Long id);

    Quote updateQuote(Quote quote);

    List<Quote> getAllQuotes();

    void deleteQuote(Long id);

    Quote findByMovie(String movie);


}

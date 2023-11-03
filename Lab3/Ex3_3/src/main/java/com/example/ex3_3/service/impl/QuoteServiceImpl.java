package com.example.ex3_3.service.impl;


import com.example.ex3_3.entity.Quote;
import com.example.ex3_3.repository.QuoteRepository;
import com.example.ex3_3.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;


    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }


    public Quote getQuoteByID(Long id) {
        return quoteRepository.findById(id).get();
    }


    public Quote updateQuote(Quote quote) {
        Quote existingQuote = quoteRepository.findById(quote.getId()).get();
        existingQuote.setMovie(quote.getMovie());
        existingQuote.setAval(quote.getAval());
        existingQuote.setMovie(quote.getMovie());
        return quoteRepository.save(existingQuote);
    }


    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }


    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }


    public Quote findByMovie(String movie) {
        return quoteRepository.findByMovie(movie);
    }
}

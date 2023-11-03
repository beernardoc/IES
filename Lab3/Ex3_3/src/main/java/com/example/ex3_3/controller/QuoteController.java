package com.example.ex3_3.controller;


import com.example.ex3_3.entity.Quote;
import com.example.ex3_3.service.QuoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/quotes")
public class QuoteController {

    private QuoteService quoteService;


    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote createdQuote = quoteService.createQuote(quote);
        return new ResponseEntity<>(createdQuote, org.springframework.http.HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<java.util.List<Quote>> getAllQuotes(){
        java.util.List<Quote> quotes = quoteService.getAllQuotes();
        return new ResponseEntity<>(quotes,org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long quoteId) {
        Quote quote = quoteService.getQuoteByID(quoteId);
        return new ResponseEntity<>(quote, org.springframework.http.HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") Long quoteId,
                                               @RequestBody Quote quote){
        quote.setId(quoteId);
        Quote updatedQuote = quoteService.updateQuote(quote);
        return new ResponseEntity<>(updatedQuote, org.springframework.http.HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable("id") Long quoteId){
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>("Quote successfully deleted!", org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/bymovie")
    public ResponseEntity<Quote> findByMovie(@RequestParam String movie){
        if(movie == null || movie.isEmpty()){
            return new ResponseEntity<>(org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        Quote quote = quoteService.findByMovie(movie);
        return new ResponseEntity<>(quote, org.springframework.http.HttpStatus.OK);
    }







}

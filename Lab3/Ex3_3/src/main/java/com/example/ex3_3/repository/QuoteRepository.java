package com.example.ex3_3.repository;

import com.example.ex3_3.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Quote findByMovie(String movie);


}

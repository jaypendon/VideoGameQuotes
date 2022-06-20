package com.jpendon.videogamequotes.service;

import java.util.List;

import com.jpendon.videogamequotes.entity.Quote;

public interface QuoteService {

	public List<Quote> getQuotes(); 
	
	public void saveQuote(Quote quote); 
	
	public Quote getQuote(int id); 
	
	public Quote getRandomQuote(); 
		
	public void deleteQuote(int id); 
	
}

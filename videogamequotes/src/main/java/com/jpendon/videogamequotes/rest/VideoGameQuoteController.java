package com.jpendon.videogamequotes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpendon.videogamequotes.entity.Quote;
import com.jpendon.videogamequotes.service.QuoteService;

@RestController
@RequestMapping("/videogamequote/api/quotes")
public class VideoGameQuoteController {
	
	@Autowired
	private QuoteService quoteService; 

	@GetMapping("/")
	public List<Quote> getQuotes() {
		
		return quoteService.getQuotes();
	}
	
	@GetMapping("/random")
	public Quote getRandomQuote() {	
		
		return quoteService.getRandomQuote(); 
	}
	
	@GetMapping("/{quoteId}")
	public Quote getQuote(@PathVariable("quoteId") int id) {
		
		return quoteService.getQuote(id);
	}
	
	@PostMapping("/")
	public Quote addQuote(@RequestBody Quote quote) {
		quote.setId(0); 
		quoteService.saveQuote(quote);
		
		return quote;
	}
	
	@PutMapping("/")
	public Quote updateQuote(@RequestBody Quote quote) {
		quoteService.saveQuote(quote);
		return quote; 
	}
	
	@DeleteMapping("/{quoteId}")
	public String deleteQuote(@PathVariable("quoteId") int id) {
		quoteService.deleteQuote(id);
		
		return "Successfully delete quote Id - " + id;
	}
	
}

package com.jpendon.videogamequotes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpendon.videogamequotes.dao.QuoteDAO;
import com.jpendon.videogamequotes.entity.Quote;

@Service
public class QuoteServiceImplementation implements QuoteService {

	@Autowired
	private QuoteDAO quoteDAO; 
	
	@Override
	@Transactional
	public List<Quote> getQuotes() {
		return quoteDAO.getQuotes();
	}

	@Override
	@Transactional
	public void saveQuote(Quote quote) {
		quoteDAO.saveQuote(quote);
	}

	@Override
	@Transactional
	public Quote getQuote(int id) {
		return quoteDAO.getQuote(id);
	}

	@Override
	@Transactional
	public Quote getRandomQuote() {
		return quoteDAO.getRandomQuote();
	}

	@Override
	@Transactional
	public void deleteQuote(int id) {
		quoteDAO.deleteQuote(id);
	}

}

package com.jpendon.videogamequotes.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpendon.videogamequotes.entity.Quote;

@Repository
public class QuoteDAOImplementation implements QuoteDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Quote> getQuotes() {
		Session session = sessionFactory.getCurrentSession(); 
		
		Query<Quote> query = session.createQuery("from Quote order by id",
				Quote.class);
		
		List<Quote> result = query.getResultList(); 
		
		return result;
	}

	@Override
	public void saveQuote(Quote quote) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(quote);
	}

	@Override
	public Quote getQuote(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		
		Quote quote = session.get(Quote.class, id);
		
		return quote; 
	}
	
	@Override
	public Quote getRandomQuote() {
		Session session = sessionFactory.getCurrentSession(); 
		
		Query<Quote> query = session.createQuery("from Quote", Quote.class);
		
		List<Quote> result = query.getResultList(); 
		
		int size = result.size(); 
		
		Random random = new Random(); 
		
		int randomNum = random.nextInt(size); 
		
		return result.get(randomNum);
	}

	@Override
	public void deleteQuote(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Quote where id=:id");
		query.setParameter("id", id);
		
		query.executeUpdate();	
	}


}

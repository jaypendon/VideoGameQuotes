package com.jpendon.videogamequotes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="video_game_quote")
public class Quote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	
	@Column(name="quote")
	private String quote; 
	
	@Column(name="character_name")
	private String characterName; 
	
	@Column(name="video_game_title")
	private String videoGameTitle; 
	
	public Quote() {
		
	}

	public Quote(String quote, String characterName, String videoGameTitle) {
		this.quote = quote;
		this.characterName = characterName;
		this.videoGameTitle = videoGameTitle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getVideoGameTitle() {
		return videoGameTitle;
	}

	public void setVideoGameTitle(String videoGameTitle) {
		this.videoGameTitle = videoGameTitle;
	}
	
	
}

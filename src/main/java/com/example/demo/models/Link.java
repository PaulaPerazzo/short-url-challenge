package com.example.demo.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String link;
	
	@Column
	private String shortLink;
	
	@Column
	private int cliks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public int getCliks() {
		return cliks;
	}

	public void setCliks(int cliks) {
		this.cliks = cliks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliks, id, link, shortLink);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return Objects.equals(cliks, other.cliks) && Objects.equals(id, other.id) && Objects.equals(link, other.link)
				&& Objects.equals(shortLink, other.shortLink);
	}
	
}

package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
	
	Link findByShortLink(String shortLink);

	Link findByLink(String link);

}

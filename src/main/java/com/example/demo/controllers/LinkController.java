package com.example.demo.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Link;
import com.example.demo.repositories.LinkRepository;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/link")
public class LinkController {
	
	Map<String, Link> shortUrlList = new HashMap<>();

	@Autowired
	private LinkRepository linkRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Link> readAll() {
		return linkRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@RequestBody Link link) {
		
		String url = link.getLink();
		
		UrlValidator urlValidator = new UrlValidator(
			new String[] {"http", "https"}
		);
		
		if (urlValidator.isValid(url)){
			String newRandomUrl = generateRandomStr();
			String newUrl = setShortLink(newRandomUrl, link);
			
			linkRepository.save(link);
			
			return newUrl;
		}
		
		throw new RuntimeException("invalid url " + url);
		
	}
	
	private String generateRandomStr() {
		String str = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabscdefghijklmnopqrstuvwxyz";
		
		for (int i = 0; i < 5; i++)
			str += possibleChars.charAt((int) Math.floor(Math.random()*possibleChars.length()));
		
		return str;
	}
	
	private String setShortLink(String randomUrl, Link link) {
		link.setShortLink("http://localhost:8080/link/cat.me/"+randomUrl);
		
		return link.getShortLink();
	}
	
	@GetMapping(value = "/cat.me/{shortUrl}")
	@ResponseStatus(code = HttpStatus.OK)
	public void redirectLink(HttpServletResponse response, @PathVariable("shortUrl") String shortUrl) throws IOException {
		
		String newLink = "http://localhost:8080/link/cat.me/"+shortUrl;
		Link newObject = linkRepository.findByShortLink(newLink);
		
		newObject.setCliks(newObject.getCliks()+1);
		linkRepository.save(newObject);
		
		String redirectedLink = newObject.getLink();
		
		response.sendRedirect(redirectedLink);

	}
	
	@GetMapping(value = "/statistic/{shortLink}")
	public String readStatistic(@PathVariable String shortLink) {
	
		String findLink = "http://localhost:8080/link/cat.me/"+shortLink;
		Link linkObject = linkRepository.findByShortLink(findLink);
		
		String shortLinkName = linkObject.getShortLink();
		int access = linkObject.getCliks();
		
		return "the short link "+ shortLinkName + " had " + access + " clicks";
	}

}

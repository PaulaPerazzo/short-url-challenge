package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.models.Link;

@SpringBootTest
@AutoConfigureMockMvc
public class LinkTest {

	@Test
	public void emptyLink() {
		
		Link link = new Link();
		link.setLink("http://www.google.com");
		
		assertEquals(null, link.getShortLink());
		assertEquals(0, link.getCliks());
					
	}
	
	@Test
	public void filledLink() {
		
		Link link = new Link();
		link.setLink("https://google.com");
		link.setShortLink("http://localhost:8080/link/cat.me/abcde");
		
		System.out.println(link.getLink());
		System.out.println(link.getShortLink());
		System.out.println(link.getCliks());
		
		assertEquals("https://google.com", link.getLink());
		assertEquals("http://localhost:8080/link/cat.me/abcde", link.getShortLink());
		assertEquals(0, link.getCliks());
		
		assertNotNull(link.getLink());

	}
}

package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.models.Link;
import com.example.demo.repositories.LinkRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class LinkRepositoryTest {
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Test
	public void saveLink() {
		Link link = new Link();
		link.setLink("https://www.google.com");
		link.setShortLink("http://localhost:8080/link/cat.me/abcde");
		
		Link res = this.linkRepository.save(link);
		
		assertNotNull(res);
		assertTrue(link.equals(res));
	}
	
}

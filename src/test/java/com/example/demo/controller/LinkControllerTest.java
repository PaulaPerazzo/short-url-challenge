package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.models.Link;
import com.example.demo.repositories.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class LinkControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private LinkRepository linkRepository;
	
	@Test
	public void readAll() throws Exception {
		mockMvc.perform(get("/link"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void createUser() throws Exception {
	    ObjectMapper mapper = new ObjectMapper();
	    Link link = new Link();
	    link.setLink("https://www.google.com");
	    link.setShortLink("http://localhost:8080/link/cat.me/abcde");
	
	    Mockito.when(this.linkRepository.save(ArgumentMatchers.eq(link))).thenReturn(link);
	    RequestBuilder request = MockMvcRequestBuilders
	      .post("/link")
	      .contentType(MediaType.APPLICATION_JSON)
	      .content(mapper.writeValueAsString(link));
	
	    MvcResult result = this.mockMvc.perform(request).andReturn();
	
	    int type = HttpStatus.CREATED.value();
	    
	    assertEquals(type, 201);
	  }

}

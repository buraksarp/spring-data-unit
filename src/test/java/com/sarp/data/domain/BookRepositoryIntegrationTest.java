package com.sarp.data.domain;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryIntegrationTest{
	
	@Autowired
	BookRepository bookRepository;
	
	Book elveda, konstantiniyye;
	
	@Before
	public void setUp(){
		bookRepository.deleteAll();
		
		elveda = bookRepository.save(new Book("Elveda", "Ahmet"));
		konstantiniyye = bookRepository.save(new Book("konstantiniyye", "Zulfu"));
	}
	
	@Test
	public void shouldMatchSize(){
		List<Book> books = (List<Book>) bookRepository.findAll();
		assertThat(books, hasSize(2));
	}
	
	@Test
	public void shouldPerformConversionDuringStreamProcessing(){
		Stream<Book> result = bookRepository.findAllByCustomQueryWithStream();
		result.forEach(System.out::println);
	}

}

package com.sarp.data.domain;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	Book findByAuthor(String author);
	
	@Query("select b from Book b")
	Stream<Book> findAllByCustomQueryWithStream();
}

package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Book;
import com.adminportal.repository.BookRepository;
import com.adminportal.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		List<Book> bookList= (List<Book>) bookRepository.findAll();
		return bookList;
	}

	@Override
	public Book findOne(Long id) {
		Book book = bookRepository.findById(id).get();
		return book;
	}

	@Override
	public void removeOne(Long id) {
		bookRepository.deleteById(id);
		
	}

}

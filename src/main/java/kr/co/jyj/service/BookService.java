package kr.co.jyj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.jyj.dto.AdminDto;
import kr.co.jyj.dto.BookDto;
import kr.co.jyj.mapper.AdminMapper;
import kr.co.jyj.mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<BookDto> bookList() {
		return mapper.bookList();
	}

	public void bookInsert(BookDto bookDto) {
		mapper.bookInsert(bookDto);
	}

	public BookDto bookOne(int isbn) {
		return mapper.bookOne(isbn);
		
	}

	public void bookUpdate(BookDto bookDto) {
		mapper.bookUpdate(bookDto);
		
	}

	public void deleteBook(int isbn) {
		mapper.deleteBook(isbn);
	}
	

}

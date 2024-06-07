package kr.co.jyj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jyj.dto.AdminDto;
import kr.co.jyj.dto.BookDto;
import kr.co.jyj.service.AdminService;
import kr.co.jyj.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/bookList")
	public String bookList(Model model) {
		List<BookDto> bookDtos = bookService.bookList();
		model.addAttribute("bookDtos", bookDtos);
		return "/book/book_list";
	}
	
	@GetMapping("/registerBookForm")
	public String registerBookForm() {
		return "/book/register_book_form";
	}
	
	@PostMapping("/registerBookConfirm")
	public String registerBookConfirm(BookDto bookDto) {
		bookService.bookInsert(bookDto);
		return "redirect:/book/bookList";
	}
	
	@GetMapping("/updateBookForm")
	public String updateBookForm(@Param("isbn")int isbn,
								 Model model) {
		BookDto bookDtos = bookService.bookOne(isbn);
		System.out.println("================"+bookDtos);
		model.addAttribute("bookDtos", bookDtos);
		return "/book/update_book_form";
	}
	
	@PostMapping("/updateBookConfirm")
	public String updateBookConfirm(BookDto bookDto) {
		System.out.println(bookDto);
		bookService.bookUpdate(bookDto);
		return "redirect:/book/bookList";
	}
	
	@GetMapping("deleteBook")
	public String deleteBook(@Param("isbn")int isbn) {
		bookService.deleteBook(isbn);
		return "redirect:/book/bookList";
	}
}

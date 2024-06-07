package kr.co.jyj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.jyj.dto.AdminDto;
import kr.co.jyj.dto.BookDto;

@Mapper
public interface BookMapper {

	List<BookDto> bookList();

	void bookInsert(@Param("bookDto")BookDto bookDto);

	BookDto bookOne(@Param("isbn")int isbn);

	void bookUpdate(@Param("bookDto")BookDto bookDto);

	void deleteBook(@Param("isbn")int isbn);

	

}

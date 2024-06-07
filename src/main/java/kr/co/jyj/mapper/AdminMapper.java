package kr.co.jyj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.jyj.dto.AdminDto;

@Mapper
public interface AdminMapper {

	void adminInsert(@Param("adminDto")AdminDto adminDto);

	AdminDto loginConfirm(@Param("adminDto")AdminDto adminDto);

	List<AdminDto> adminList();

	void updateApproval(@Param("a_id")String a_id);

	void modifyAccount(@Param("adminDto")AdminDto adminDto);

	List<AdminDto> searchAdminConfirm(@Param("keyword")String keyword, @Param("category")String category);

}

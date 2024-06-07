package kr.co.jyj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.jyj.dto.AdminDto;
import kr.co.jyj.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	AdminMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void adminInsert(AdminDto adminDto) {
		adminDto.setA_pw(passwordEncoder.encode(adminDto.getA_pw()));
		if(adminDto.getA_id().equals("admin")) {
			adminDto.setA_approval(1);
		}
		mapper.adminInsert(adminDto);
	}

	public AdminDto loginConfirm(AdminDto adminDto) {
		AdminDto dto = new AdminDto();
		
		dto = mapper.loginConfirm(adminDto);
		return dto;
	}

	public List<AdminDto> adminList() {
		return mapper.adminList();
	}

	public void updateApproval(String a_id) {
		mapper.updateApproval(a_id);
		
	}

	public void modifyAccount(AdminDto adminDto) {
		mapper.modifyAccount(adminDto);
	}

	public List<AdminDto> searchAdminConfirm(String keyword, String category) {
		return mapper.searchAdminConfirm(keyword, category);
	}
	

}

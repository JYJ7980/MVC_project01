package kr.co.jyj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jyj.dto.AdminDto;
import kr.co.jyj.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminSevice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public String mainView() {
		return "/admin/main";
	}
	
	@GetMapping("/createAccountForm")
	public String createAccountForm() {
		return "/admin/create_account_form";
	}
	
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminDto adminDto) {
		System.out.println("createAccountConfirm : " + adminDto.toString());
		adminSevice.adminInsert(adminDto);
		return "/admin/create_account_form";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "/admin/login_form";
	}
	
	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminDto adminDto, HttpSession session) {
		String nextPage = "/admin/login_ok";
		AdminDto adminLoginedDto = adminSevice.loginConfirm(adminDto);
		if(adminLoginedDto == null) {
			nextPage = "/admin/login_ng";
			return nextPage;
		}
		if(passwordEncoder.matches(adminDto.getA_pw(), adminLoginedDto.getA_pw())) {
			session.setAttribute("adminLoginedDto", adminLoginedDto);
			session.setMaxInactiveInterval(60*30);	// 60초*30 = 30분
			return nextPage;
		} else {
			nextPage = "/admin/login_ng";
			return nextPage;
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	@GetMapping("listupAdmin")
	public String listupAdmin(Model model) {
		String nextPage = "/admin/admin_list";
		List<AdminDto> adminDtos = adminSevice.adminList();
		model.addAttribute("adminDtos", adminDtos);
		return nextPage;
	}
	
	@GetMapping("/setAdminApproval")
	public String updateApproval(@RequestParam("id")String a_id) {
		String nextPage = "redirect:/admin/listupAdmin";
		adminSevice.updateApproval(a_id);
		return nextPage;
	}
	
	@GetMapping("/modifyAccountForm")
	public String modifyAccountForm(HttpServletRequest request, Model model) {
		String nextPage = "/admin/modify_account_form";
		HttpSession session = request.getSession(false);
		// 현재 로그인 상태인지 확인
		// 로그인 상태 : 수정페이지 이동
		// 로그아웃상태(세션 만료) : 로그인 페이지로 이동
		if(session == null) {
			nextPage = "redirect:/admin/loginForm";
			return nextPage;
		}
		AdminDto adminLoginedDto = (AdminDto)session.getAttribute("adminLoginedDto");
		System.out.println(adminLoginedDto);
		if(adminLoginedDto == null) {
			nextPage = "redirect:/admin/loginForm";
			return nextPage;
		} else {
			model.addAttribute("dto", adminLoginedDto);
			return nextPage;
		}
	}
	
	@PostMapping("/modifyAccountConfirm")
	public String modifyAccountConfirm(AdminDto adminDto, HttpSession session) {
		String nextPage = "redirect:/admin/listupAdmin";
		adminSevice.modifyAccount(adminDto);
		AdminDto adminLoginedDto = adminSevice.loginConfirm(adminDto);
		System.out.println(adminLoginedDto);
		session.setAttribute("adminLoginedDto", adminLoginedDto);
		session.setMaxInactiveInterval(60*30);	// 60초*30 = 30분
		// 수정 후 관리자 리스트 페이지로 이동
		return nextPage;
	}
	
	@GetMapping("/searchAdminConfirm")
	public String searchAdminConfirm(@RequestParam("keyword")String keyword,
									 @RequestParam("category")String category,
									 Model model) {
		String nextPage = "/admin/admin_list";
		List<AdminDto> adminDtos = adminSevice.searchAdminConfirm(keyword, category);
		model.addAttribute("adminDtos", adminDtos);
		return nextPage;
	}
	
	@GetMapping("/handlerInterceptor")
	public String handlerInterceptor() {
		return "/admin/handlerInterceptor";
	}
}

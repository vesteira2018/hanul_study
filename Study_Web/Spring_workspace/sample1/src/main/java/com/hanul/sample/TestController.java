package com.hanul.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.MemberVO;

@Controller
public class TestController {
	
	@RequestMapping("/login_result")
	public String login(String id, String pw) {
		//hanul / 0000 �̸� �α��� ����, �ƴϸ� �α��� ����
		//�α��� �����ϸ� Ȩ ȭ������ ����, �����ϸ� �α���ȭ������
		if (id.equals("hanul") && pw.equals("0000")) {
			//return "home";	//forward
			return "redirect:/";
		} else {
			//return "member/login";
			return "redirect:login";
		}
	}
	
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("/joinPath/{name}/{gender}/{email}/{age}")
	public String signup(Model model, @PathVariable String name, @PathVariable String gender, 
			@PathVariable String email, @PathVariable int age) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@PathVariable");
		
		return "member/myInfo";
	}
	
	@RequestMapping("/signupDataObject")
	public String signup(MemberVO vo, Model model) {
		model.addAttribute("vo", vo);
		model.addAttribute("method", "�����Ͱ�ü");
		
		return "member/myInfo";
	}
	
	@RequestMapping("/signupRequestParam")
	public String signup(@RequestParam String name, 
			@RequestParam String gender,
			String email, int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("email", email);
		model.addAttribute("age", age);
		model.addAttribute("method", "@RequestParam");
		
		
		return "member/myInfo";
	}
	
	@RequestMapping("/signupRequest")
	public String signup(HttpServletRequest request, Model model) {
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("gender", request.getParameter("gender"));
		model.addAttribute("email", request.getParameter("email"));
		int age = request.getParameter("age")==null ? 0 :
				Integer.parseInt(request.getParameter("age"));
		model.addAttribute("age", age == 0? "" : age);
		model.addAttribute("method", "HttpServletRequest");
		
		return "member/myInfo";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member/signup";
	}
	
	@RequestMapping("/second")
	public ModelAndView second() {
		ModelAndView model = new ModelAndView();
		SimpleDateFormat df = new SimpleDateFormat("a hh�� mm�� ss��");
		String now = df.format(new Date());
		model.addObject("now", now);
		model.setViewName("view");
		return model;
	}
	
	@RequestMapping("/first")
	public String aaa(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		String today = sdf.format(new Date());
		model.addAttribute("today", today);
//		model.addAttribute("today", "ȫ�浿");
		
		return "view";
	}
}

package com.hanul.iot;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import employee.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired private EmployeeServiceImpl service;
	
	//������� ��ȸ
	@RequestMapping("/detail.hr")
	public String detail(Model model, int id) {
		//������ ����� ������ ��ȸ�ؿ� ���������ȭ�鿡 ���
		model.addAttribute("vo", service.employee_detail(id));
		return "employee/detail";
	}
	
	//������ ��ȸ
	@RequestMapping("/list.hr")
	public String list(Model model, String depts, HttpSession session) {
		session.setAttribute("category", "hr");
		//����� �Ҽӵ� �μ����� ��ȸ�Ͽ� ���������ȭ�鿡 ���
		model.addAttribute("depts", service.employee_department());
		//DB���� �������� ��ȸ�ؿ� ���ȭ�鿡 ���
		//�μ��� ������ ��� �ش� �μ��� ���� �������� ��ȸ�Ѵ�.
		//null: depts �Ķ���Ͱ� ���� ���
		//all: depts �Ķ���Ͱ� ���ڿ��� ��ü�� ���
		//�� �ܴ� ������ �μ��ڵ忡 �ش��ϴ� ���
		if( depts == null || depts.equals("all") )
			model.addAttribute("list", service.employee_list() );
		else
			model.addAttribute("list", service.employee_list(depts) );

		model.addAttribute("dept_id", 
				(depts == null || depts.equals("all")) ? "all" : depts);
		return "employee/list";
	}
}







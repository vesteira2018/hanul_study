package com.csslect.app.raspcontroller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.csslect.app.command.AInsertMultiCommand;
import com.csslect.app.raspcommand.RaspCommand;
import com.csslect.app.raspcommand.RaspGetDataCommand;
import com.csslect.app.raspcommand.RaspSetDataCommand;

@Controller
public class RaspController {
	
	RaspCommand command;
	
	@RequestMapping(value="/raspGetData", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String arduGetLed(HttpServletRequest req, Model model){
		System.out.println("raspGetData()");
		
		command = new RaspGetDataCommand();
		command.execute(model);
		
		return "raspGetData";
	}
	
	@RequestMapping(value = "/raspSetData", method = {RequestMethod.GET, RequestMethod.POST})
	public String arduSetLed(HttpServletRequest req, Model model) {
		
	     System.out.println("store_id : " + req.getParameter("store_id"));     
	     System.out.println("store_name : " + req.getParameter("store_name")); 
	     System.out.println("table_num : " + req.getParameter("table_num")); 
	     System.out.println("table_value : " + req.getParameter("table_value")); 
	     
	     String store_id = req.getParameter("store_id");
	     String store_name = req.getParameter("store_name");
	     String table_num = req.getParameter("table_num");
	     String table_value = req.getParameter("table_value");
	     
	     model.addAttribute("store_id", store_id);
	     model.addAttribute("store_name", store_name);
	     model.addAttribute("table_num", table_num);
	     model.addAttribute("table_value", table_value);
	     
	     command = new RaspSetDataCommand();
	     command.execute(model); 
		
	     return "raspSetData";
	}
	
	@RequestMapping(value="/raspUploadfile", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String raspUploadfile(HttpServletRequest req, Model model){
		System.out.println("raspUploadfile()");
		
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("media");
		
			
		if(file != null) {
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			// ���丮 �������� ������ ����
			makeDir(req);	
				
			if(file.getSize() > 0){			
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/");
				
				System.out.println( fileName + " : " + realImgPath);
				System.out.println( "fileSize : " + file.getSize());					
												
			 	try {
			 		// �̹������� ����
					file.transferTo(new File(realImgPath, fileName));										
				} catch (Exception e) {
					e.printStackTrace();
				} 
									
			}else{
				// �̹������� ���н�
				fileName = "FileFail.jpg";
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/" + fileName);
				System.out.println(fileName + " : " + realImgPath);
						
			}			
			
		}
		
		// �̹��� ���� �ڵ��� ��ȣ ���� �� 
		// �����ͺ��̽��� �ִ¹�ȣ�� ���� : true 
		// ���¹�ȣ�� ���� : false
		// �ϴ� �ִٴ�  �����Ͽ� ���Ͻ�Ŵ
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("returnValue", "true");
		model.addAttribute("raspUploadfile", map);
				
		return "raspUploadfile";
	}
	
	public void makeDir(HttpServletRequest req){
		File f = new File(req.getSession().getServletContext()
				.getRealPath("/resources"));
		if(!f.isDirectory()){
		f.mkdir();
		}	
	}

}

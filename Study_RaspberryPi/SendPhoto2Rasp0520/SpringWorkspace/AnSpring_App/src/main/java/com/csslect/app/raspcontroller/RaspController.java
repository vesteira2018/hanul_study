package com.csslect.app.raspcontroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.csslect.app.command.ADeleteMultiCommand;
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
	
	@RequestMapping(value="/raspSendPhoto", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String anInsertMulti(HttpServletRequest req, Model model){
		System.out.println("raspSendPhoto()");	
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("image");
		MultipartFile file2 = multi.getFile("video");
			
		if(file != null) {
			String fileName = file.getOriginalFilename();
			System.out.println(fileName);
			
			// ???????? ???????? ?????? ????
			makeDir(req);	
				
			if(file.getSize() > 0){			
				String realImgPath = req.getSession().getServletContext()						
						.getRealPath("/resources/");
				
				//System.out.println( fileName + " : " + realImgPath);
				System.out.println( "fileSize : " + file.getSize());					
												
			 	try {
			 		// ?????????? ????
					file.transferTo(new File(realImgPath, "MyPicture.jpg"));										
				} catch (Exception e) {
					e.printStackTrace();
				} 
									
			}else{
				// ?????????? ??????
				fileName = "FileFail.jpg";
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/" + fileName);
				System.out.println(fileName + " : " + realImgPath);
						
			}			
			
		}
		
		if(file2 != null) {
			// ?????? ???? ???? 1024X768?? ?????? ????????
			//ffmpeg -i input.avi -vf scale=320:240 output.avi			
			
			String fileName = file2.getOriginalFilename();
			System.out.println(fileName);	
			
			// ???????? ???????? ?????? ????
			makeDir(req);	
				
			if(file2.getSize() > 0){			
				String realVideoPath = req.getSession().getServletContext()						
						.getRealPath("/resources/");
				
				//System.out.println( fileName + " : " + realImgPath);
				System.out.println( "fileSize : " + file2.getSize());					
												
			 	try {
			 		// ?????????? ????
					file2.transferTo(new File(realVideoPath, "MyVideo_tmp.mp4"));										
				} catch (Exception e) {
					e.printStackTrace();
				} 
			 	
			 	convert(realVideoPath + "\\MyVideo_tmp.mp4", realVideoPath + "MyVideo.mp4");
			 	
			 	File delfile = new File(realVideoPath, "MyVideo_tmp.mp4");
			 	if(delfile.exists()) {
		            System.out.println("Sub1Del:pDelImagePath " + delfile.exists());
		            boolean deleteFile = false;
		            while(deleteFile != true){
		            	deleteFile = delfile.delete();
		            }     
		        }	
									
			}else{
				// ?????????? ??????
				fileName = "FileFail.mp4";
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/" + fileName);
				System.out.println(fileName + " : " + realImgPath);
						
			}			
			
		}
		
		return "raspSendPhoto";
	}
		
	public void makeDir(HttpServletRequest req){
		File f = new File(req.getSession().getServletContext()
				.getRealPath("/resources"));
		if(!f.isDirectory()){
			f.mkdir();
		}	
	}
	
	@RequestMapping(value="/raspDelFile", method = {RequestMethod.GET, RequestMethod.POST})
	public void anDeleteMulti(HttpServletRequest req, Model model){
		System.out.println("raspDelFile()");	
		
		String id = req.getParameter("id");
		System.out.println((String)req.getParameter("id"));	
		
		// ???? ???? ????
		String delDbImgPath = "";
		if(id.equals("PIC")) {
			delDbImgPath = req.getSession().getServletContext().getRealPath("/resources/MyPicture.jpg");	
		}else if(id.equals("VIDEO")) {
			delDbImgPath = req.getSession().getServletContext().getRealPath("/resources/MyVideo.mp4");	
		}
		
		// ?????? ??????????
		File delfile = new File(delDbImgPath);
		System.out.println(delfile.getAbsolutePath());
		
        if(delfile.exists()) {
            System.out.println("Sub1Del:pDelImagePath " + delfile.exists());
            boolean deleteFile = false;
            while(deleteFile != true){
            	deleteFile = delfile.delete();
            }     
        }	        
				
	}
	
	// ?????? ???? 1024X768?? ??????????
	public void convert(String fOriginal, String fResult) {

		String ffmpegPath = "D:\\CHOSS21\\ffmpeg-20200515\\bin\\ffmpeg.exe";  //"ffmpeg ?????? ???? ????";    //??) /work/ffmpeg
		//String fOriginal = "/work/upload.mp4";  //?????????? ?????????? ????
		//String fResult = "/work/upload.flv";      // ?????????? ???? ?? ????????

		String[] cmdLine = new String[]{ffmpegPath,
                                           "-i",                           // ???????? ????????
                                           fOriginal,      
                                           "-ar",
                                           "44100",     
                                           "-ab",
                                           "32",                      
                                           "-s",
                                           "1024x768",     //???? ??????
                                           "-b",
                                           "768k",          //??????????
                                           "-r",
                                           "24",           //???? ??????
                                           "-y",
                                           "-f",
                                           "mp4",            // flv???? ?????? ????
                                           fResult};  // ???????? ??????????.
		 
		// ???????? ?????? ???????? ProcessBuilder ????.
		ProcessBuilder pb = new ProcessBuilder(cmdLine);
		pb.redirectErrorStream(true);
		Process p = null;
		try { 
		     // ???????? ?????? ????
		     p = pb.start();
		} catch (Exception e) {         
		     e.printStackTrace();
		     p.destroy();
		     //return null;
		}

    	exhaustInputStream(p.getInputStream());   // ???? ???????????? ???????? inputstrem?? ????????????????.

		try {
            // p?? ???? ?????????? ?????? ?????? ???? p?? ????????
	        p.waitFor();

	    } catch (InterruptedException e) {
            p.destroy();
    	}


		// ???? ?????? ???? ?????? ????
		if (p.exitValue() != 0) {
	        System.out.println("???? ?? ???? ????");
	        //return null;
	    }

		// ?????? ???? ?? ?????? ???????? ?????? ?????? 0?? ????
		if (fResult.length() == 0) {
		    System.out.println("?????? ?????? ???????? 0??");
		    //return null;
		}
	
		p.destroy();
		
		//return new File(fResult);

	}

	private void exhaustInputStream(final InputStream is) {
	    // InputStream.read() ???? ?????????? ?????? ?????? ???? ???????? ???????? ???????? ????????
	    try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String cmd = null;

            while((cmd = br.readLine()) != null) { // ???????? ?????? ?????????? ???? ????
                //System.out.println(cmd);
            }

            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

   }

			/*
			 * public static void main(String[] args) { File f = new
			 * File("?????????? ???????? ????????"); if(f.exists()){ convert(); }
			 * 
			 * }
			 */

}

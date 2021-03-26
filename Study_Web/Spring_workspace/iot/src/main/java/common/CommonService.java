package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {

	//���ϴٿ�ε�
	public File fileDownload(String filename, String filepath
							, HttpSession session
							, HttpServletResponse response) {
		//�ٿ�ε��� ���ϰ�ü�� ����
		File file = new File( session.getServletContext().getRealPath("resources")
					+ "/" + filepath );
		//content type ������ ���� ������ ����Ÿ��
		String mime = session.getServletContext().getMimeType(filename);
		
		response.setContentType(mime);
		try {
			filename = URLEncoder.encode(filename, "utf-8")
							.replaceAll("\\+", "%20");
			
			response.setHeader("content-disposition"
							, "attachment; filename=" + filename);
			
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy( new FileInputStream(file), out);
			out.flush();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return file;
	}
	
	
	//���Ͼ��ε�
	public String fileUpload(HttpSession session
							, MultipartFile file, String category) {
		//������ ��������ġ 
		String resources 
			= session.getServletContext().getRealPath("resources");
		//D://Study_Spring/...... /iot/resources
		//  /upload/notice/2021/02/03/erf32e33_abc.txt
		String upload = resources + "/upload";
		String folder = upload + "/" + category + "/" 
						+ new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		
		File f = new File( folder );
		if( ! f.exists() ) f.mkdirs();
		
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		try {
			file.transferTo( new File(folder, uuid) );
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return folder.substring(resources.length()+1) + "/" + uuid;
	}
	
	
	public void sendEmail(HttpSession session, String email, String name) {
		
		//�⺻�̸�������
		//sendSimple(email, name);
		
		//����÷���̸�������
		//sendAttach(session, email, name);
		
		//HTML�����̸�������
		sendHtml(session, email, name);
		
	}
	private void sendHtml(HttpSession session, String email, String name) {
		HtmlEmail mail = new HtmlEmail();
		mail.setHostName("smtp.naver.com");
		mail.setDebug(true);
		mail.setCharset("utf-8");
		
		mail.setAuthentication("�������̸���", "�����ڸ��Ϻ��");
		mail.setSSLOnConnect(true);
		
		try {
		mail.setFrom("�ѿ�����ڸ���", "�ѿ������");
		mail.addTo(email, name);
		
		mail.setSubject("ȸ���������� -HTML");
		StringBuffer msg = new StringBuffer();
		msg.append("<html>");
		msg.append("<body>");
		msg.append("<a href='http://hanuledu.co.kr/'><img src='http://hanuledu.co.kr/data/menu/LOGO_cYFn10oGM70UkjkExmRP1610075399.jpg'/></a>");
		msg.append("<hr>");
		msg.append("<h2>�ѿ� IoT���� ���� ����</h2>");
		msg.append("<p>ȸ�������� �����մϴ�</p>");
		msg.append("<p>÷�ε� ������ �� Ȯ���� �ֽð�</p>");
		msg.append("<p>������Ʈ���� �������ؼ� </p>");
		msg.append("<p>����� �����Ͻñ� �ٶ��ϴ�</p>");
		msg.append("</body>");
		msg.append("</html>");
		mail.setHtmlMsg(msg.toString());
		
		EmailAttachment file = new EmailAttachment();
		file.setPath( session.getServletContext().getRealPath("resources")
				  	+ "/css/common.css");
		mail.attach(file);
		
		file = new EmailAttachment();
		file.setURL( new URL("http://hanuledu.co.kr/data/menu/LOGO_cYFn10oGM70UkjkExmRP1610075399.jpg") );
		mail.attach(file);
		
		mail.send();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private void sendAttach(HttpSession session, String email, String name) {
		MultiPartEmail mail = new MultiPartEmail();
		mail.setHostName("smtp.naver.com");
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		mail.setAuthentication("�������̸����ּ�", "�ѿ������");
		mail.setSSLOnConnect(true);
		
		try {
			mail.setFrom("�������̸����ּ�", "�ѿ������");
			mail.addTo(email, name);
			
			mail.setSubject("ȸ���������� �޽���-÷������Ȯ�ο��");
			mail.setMsg("ȸ�������� �����մϴ�. ÷�ε� ������ Ȯ���ϼ���!");
			//����÷���ϱ�
			EmailAttachment file = new EmailAttachment();
			file.setPath("D:\\Study_Web\\workspace\\02.MVC\\src\\HelloServlet.java");
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setPath( session.getServletContext().getRealPath("resources")
							+ "/images/kakao_login.png" );
			mail.attach(file);
			
			file = new EmailAttachment();
			file.setURL( new URL("https://imgnews.pstatic.net/image/003/2021/01/29/NISI20201120_0016911427_web_20201120144403_20210129161430828.jpg?type=w647") );
			mail.attach(file);
			
			mail.send();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void sendSimple(String email, String name) {
		SimpleEmail mail = new SimpleEmail();
		
		mail.setHostName("smtp.naver.com"); //���ϼ�������
		mail.setCharset("utf-8");
		mail.setDebug(true);
		
		//�α����ϱ� ���� ���̵�/��� ����
		mail.setAuthentication("ojink2", "��й�ȣ");
		mail.setSSLOnConnect(true);
		
		try {
		//���ϼ۽��� ����
		mail.setFrom("ojink2@naver.com", "�ѿ������");
//		mail.setFrom("admin@hanul.co.kr", "�ѿ������");
		//���ϼ����� ����
		mail.addTo(email, name); //���������� �������� addTo �� �߰�
		
		//��������, ����
		mail.setSubject("ȸ���������� �޽���");
		mail.setMsg(name + "��! �ѿ�IoT ���� �Ա��� �����մϴ�");
		
		//�������۹�ư Ŭ��
		mail.send();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String requestAPI(StringBuffer url, String property) {
		String result = url.toString();
		try {
			HttpURLConnection conn 
			= (HttpURLConnection)new URL( result ).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setRequestProperty("Authorization", property);
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300 ) {
				reader = new BufferedReader( new InputStreamReader(
										conn.getInputStream(), "utf-8" ) );
			}else {
				reader = new BufferedReader( new InputStreamReader(
										conn.getErrorStream(), "utf-8" ) );
			}
			url = new StringBuffer();
			while( (result = reader.readLine())!=null ) {
				url.append(result);
			}
			reader.close();
			conn.disconnect();
			result = url.toString();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public String requestAPI(StringBuffer url) {
		String result = url.toString();
		try {
			HttpURLConnection conn 
			= (HttpURLConnection)new URL( result ).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			BufferedReader reader;
			if( conn.getResponseCode()>=200 && conn.getResponseCode()<=300 ) {
				reader = new BufferedReader( new InputStreamReader(
										conn.getInputStream(), "utf-8" ) );
			}else {
				reader = new BufferedReader( new InputStreamReader(
										conn.getErrorStream(), "utf-8" ) );
			}
			url = new StringBuffer();
			while( (result = reader.readLine())!=null ) {
				url.append(result);
			}
			reader.close();
			conn.disconnect();
			result = url.toString();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Object json_list(String list) {
		JSONObject json = null;
		
		json = new JSONObject(list);
		json = (JSONObject)json.get("response");
		json = (JSONObject)json.get("body");
		int count = 0;
		if( json.has("totalCount") ) {
			count = json.getInt("totalCount");
		}
		if(json.get("items") instanceof JSONObject ) {
			json = (JSONObject)json.get("items");
		}else {
			json.put("item", "");
		}
		json.put("count", count);
		return json.toString();
	}
	
	
	
	
	
	
}
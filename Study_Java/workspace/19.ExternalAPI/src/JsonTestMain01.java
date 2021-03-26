import java.io.BufferedWriter;
import java.io.FileWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTestMain01 {
	public static void main(String[] args) {
		JsonDTO dto1 = new JsonDTO(10, "홍길동", 33, "광주시 서구 농성동", "010-1111-1111");
		JsonDTO dto2 = new JsonDTO(20, "박문수", 30, "광주시 남구 봉선동", "010-2222-2222");
		JsonDTO dto3 = new JsonDTO(30, "이순신", 50, "광주시 북구 용봉동", "010-3333-3333");
		
		JSONArray array = new JSONArray();		//JSON Array 객체 생성
		JSONObject object = new JSONObject();	//JSON Object 객체 생성
		
		object.put("member", dto1);	//DTO 객체를 JSON Object 객체로 변환
		array.add(object);	//JSON Object를 JSON Array에 등록
		
		object.put("member", dto2);
		array.add(object);
		
		object.put("member", dto3);
		array.add(object);
		
		
		String json = array.toString();	//JSON 형식의 내용을 화면에 출력
		System.out.println(json);
		
		//결과를 화면에 출력 : JSON Array → JSON Object → JsonDTO
		for (int i = 0; i < array.size() ; i++) {
			JSONObject obj = array.getJSONObject(i);
			obj = obj.getJSONObject("member");
			JsonDTO dto = (JsonDTO) JSONObject.toBean(obj, JsonDTO.class);
			System.out.print(dto.getNum() + "\t");
			System.out.print(dto.getName() + "\t");
			System.out.print(dto.getAge() + "\t");
			System.out.print(dto.getAddr() + "\t");
			System.out.print(dto.getTel() + "\n");
		}//for
		
		//결과를 파일에 저장
		try {
			FileWriter fw = new FileWriter("member.json");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(json);
			bw.flush();
			bw.close();
			fw.close();
			System.out.println("member.json 파일이 생성되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//main()
}//class

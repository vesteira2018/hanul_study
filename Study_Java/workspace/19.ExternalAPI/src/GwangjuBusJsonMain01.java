import java.io.BufferedReader;
import java.io.FileReader;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GwangjuBusJsonMain01 {
	public static void main(String[] args) {
		String jsonData = getJsonData();
		//System.out.println(jsonData);
		
		JSONArray array = JSONArray.fromObject(jsonData);
		for (int i = 0; i < array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			GjBusDTO dto = (GjBusDTO) JSONObject.toBean(object, GjBusDTO.class);
			
		}
		
	}//main()
	
	//gjBus.json 파일의 내용을 읽어서 JSON 구조 형태로 만드는 메소드
	public static String getJsonData() {
		String line = null;
		String jsonData = "";
		try {
			FileReader fr = new FileReader("gjBus.json");
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				jsonData += line;
			}//while
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getJsonData() Exception!");
		}
		return jsonData;
		
	}//getJsonData()
	
}//class

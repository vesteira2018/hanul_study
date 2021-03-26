import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class GwangjuBusJsonMain02 {
	public static void main(String[] args) {
		String jsonData = GwangjuBusJsonMain01.getJsonData();
		
		JSONArray array = JSONArray.fromObject(jsonData);
		for (Object object : array) {
			JSONObject obj = (JSONObject) JSONSerializer.toJSON(object);
			System.out.print("노선이름 : " + obj.get("LINE_NAME") + "\t");
			System.out.print("출발지 : " + obj.get("DIR_UP_NAME") + "\n");
		}
		
	}//main()
}//class

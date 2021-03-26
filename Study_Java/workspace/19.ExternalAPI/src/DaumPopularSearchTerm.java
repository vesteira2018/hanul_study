import java.net.URL;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

public class DaumPopularSearchTerm {
	public static void main(String[] args) {
		//다음 도메인 가져오기
		String addr = "https://www.daum.net/";
		try {
			URL url = new URL(addr);
			Source source = new Source(url);
			List<Element> list = source.getAllElements(HTMLElementName.LI);
			
			//인기 검색어
			String html = null;
			
			for (int i = 0; i < list.size(); i++) {
				String data = list.get(i).getContent().toString();
				//System.out.println(data);
				
				if (data.contains("class=\"link_favorsch")) {
					html = data;
					//System.out.println(html);
					
					int spos = html.indexOf(">");
					//String favorsch = html.substring(spos + 1);
					//System.out.println(favorsch);
					
					int epos = html .indexOf("</a>");
					String favorsch = html.substring(spos + 1, epos);
					if (i < 9) {
						System.out.println("Rank. 0" + (i + 1) + " : " + favorsch);
					} else {
						System.out.println("Rank. " + (i + 1) + " : " + favorsch);
					}//inner if
				}//outer if
			}//for
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
	}//main()
}//class

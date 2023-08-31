package opendata.test.ljy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class opendata {


	public static final String SERVICEKEY = "tgsexJsoT70XL7QhJyVbu3oIAFAOij%2FhkBsA%2BB4lPQgf567fDoQxwep%2FeclXgua3OJhj%2FUVxmfy%2BwS9l3UMlqQ%3D%3D";

	@RequestMapping(value="shelter", produces = "text/xml; charser=UTF-8")
	@ResponseBody
	public String test() throws IOException {

		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";

		url += "?servicekey="+ SERVICEKEY;
		url += "&requestType=xml";
		url += "&numOf?Rows=2";
		url += "&location="+URLEncoder.encode("location","UTF-8");

		URL requstUrl= new URL(url);
		
		HttpURLConnection urlConn = (HttpURLConnection)requstUrl.openConnection();
		
		urlConn.setRequestMethod("GET"); 
		
		BufferedReader br= new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String resultText= "";
		String line = null;
		
		
		while ((line = br.readLine()) != null) {
			
			resultText += line;
		
		}
		
		br.close();
		urlConn.disconnect();
		
		
		return resultText;



	}


}

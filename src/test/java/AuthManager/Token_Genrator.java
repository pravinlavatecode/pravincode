package AuthManager;

import java.io.IOException;
import java.util.HashMap;

import Utility.configReader_property;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Token_Genrator {

	public static String renew_token() throws IOException {
		
		configReader_property cr=new configReader_property();
		
		
		HashMap<String, String>	 param=new HashMap<String, String>();
		
		param.put("grant_type", "refresh_token");
		param.put("refresh_token", cr.Raad_pro_Data("refreshtoken"));
		
		param.put("client_id", cr.Raad_pro_Data("clientID"));
		param.put("client_secret", cr.Raad_pro_Data("clientSecret"));
		
		
		
		RestAssured.baseURI="https://accounts.spotify.com";
		
		Response response = given()
		.contentType(ContentType.URLENC)
		.formParams(param)
		.when()
		.post("/api/token")
		.then()
		.extract()
		.response();
		
		
		String Acess_token = response.path("access_token");
		
		if (response.statusCode()!=200) {
			
			throw new RuntimeException("Failed to ganrate acess token .");	
		}
		
		return Acess_token;
		
		
	}
}

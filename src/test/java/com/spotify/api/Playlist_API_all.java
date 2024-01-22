package com.spotify.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.spotify.pojo.Playlist;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Playlist_API_all {

	public static Response post_request(Playlist reqplaylist,String token ) {
		
		 return  given()
				 
		.headers("Authorization", "Bearer "+token)
		 
        .spec(SpecBuilder_comman.ReqSpecBuilder())
        
		.body(reqplaylist)
		
		.when()
		
		.post("/users/31zth34d7jud5yno2bg2tdsrsp64/playlists")
		
		.then()
		
		.spec(SpecBuilder_comman.ResponseSpecBuilder())
		
		.extract()
		
		.response();
	
	}
	public static Response GET_request(String playlistId ,String token) {
		
		return given()
				
	   .headers("Authorization", "Bearer "+token)
		 
        .spec(SpecBuilder_comman.ReqSpecBuilder())
        
        .pathParam("pID", playlistId)
        		
		.when()
		
		.get("/playlists/{pID}")
		
		.then()
		
		.spec(SpecBuilder_comman.ResponseSpecBuilder())
		
		.extract()
		
		.response();
		
	}
	public static Response update(Playlist reqPlaylist, String playlistId ,String token)
	{
	return	given()
		
		.headers("Authorization", "Bearer "+token)
		
		.spec(SpecBuilder_comman.ReqSpecBuilder())
		
		.body(reqPlaylist)
		
		.when()
		
		.put("playlists/"+playlistId)
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}
}

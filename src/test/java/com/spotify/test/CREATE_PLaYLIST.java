package com.spotify.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.spotify.api.SpecBuilder_comman;
import com.spotify.pojo.Playlist;



public class CREATE_PLaYLIST {
	static String playlistId;
	
	@Test(priority = 1)
	public void create_playlist() {

	Playlist reqplaylist =new Playlist();
	
	reqplaylist.setName("bhajan song new");
	
	reqplaylist.setDescription("Spiritual content new");
	
	reqplaylist.setPublic(false);
	
	         Playlist playlist = given()
	        		 
	        .spec(SpecBuilder_comman.ReqSpecBuilder())
	        
			.body(reqplaylist)
			
			.when()
			
			.post("/users/31zth34d7jud5yno2bg2tdsrsp64/playlists")
			
			.then()
			
			.spec(SpecBuilder_comman.ResponseSpecBuilder())
			
			.extract()
			
			.response()
			
			.as(Playlist.class);
	         
	         playlistId=playlist.getId();
		
	}
	
	@Test(priority = 2)
	public void GETplay_list() {
		given()
		 
        .spec(SpecBuilder_comman.ReqSpecBuilder())
        
        .pathParam("pID", playlistId)
        		
		.when()
		
		.get("/playlists/{pID}")
		
		.then()
		
		.spec(SpecBuilder_comman.ResponseSpecBuilder())
		
		.extract()
		
		.response();
		
		
		
	}
}

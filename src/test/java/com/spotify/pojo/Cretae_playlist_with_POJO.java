package com.spotify.pojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Cretae_playlist_with_POJO {
	
	@Test
	public void create_playlist() {
		
		Playlist reqplaylist =new Playlist();
		
		reqplaylist.setName("palylist test usinmg pojo");
		reqplaylist.setDescription("Spiritual content");
		reqplaylist.setPublic(false);
	
		
		RestAssured.baseURI  = "https://api.spotify.com/v1";
		given()
		.headers("Authorization","Bearer BQCS5C_crb8XQZAE347ysJ_9fY8cBo67-jP2WXtn1Vu5EIm29UDQCgDngYzT_qQbrtMjizTvA1AJs87wSNuxRiroE694yltkRPj4y9m7q5fQ8rdBW93ZGcTYsL7X-XCVbnQzOiPSWBgTMoYGTgUmWuHEp3rys02YQ2clbKu7MLikMfGVLZnDCUso30VuGratdUaJUsGDfb8A7lTSgOjfRhl2Kjuc5m-0nKA0Gj3ePLAfUIRNMQ4rrROnMNROfoEu9ubitCcrumjgv_hk")
		.headers("Content-Type","application/json")
		.body(reqplaylist)
		.when()
		.post("/users/31zth34d7jud5yno2bg2tdsrsp64/playlists")
		.then()
		
		.body("name", equalTo("palylist test usinmg pojo"));
	
		
	}

	
	

}

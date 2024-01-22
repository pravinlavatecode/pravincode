package com.spotify.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.spotify.api.Playlist_API_all;
import com.spotify.pojo.Playlist;

import AuthManager.Token_Genrator;
import Utility.configReader_property;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

@Epic("spotify auth 2.0")
@Feature("playlist APIs")
public class PLAYLIST_REUSABLE_CALL {
	
	static String playlistID; // reusable value ahe ,mhnun globally 
	
	@Story("SPS-01-Create a playlist")
	@Description("Creation of playlist using valid test data")
          @Test(priority = 1)	
	     public void CreatePlaylist() throws IOException {
        	  
        	  configReader_property cr=new configReader_property(); //property file object 
        	  
	    	 
	    	 //Data pahila pojo madhun ghych ahe 
	
                         Playlist reqplaylist =new Playlist();
	
                         reqplaylist.setName(cr.Raad_pro_Data("name"));
	
                         reqplaylist.setDescription(cr.Raad_pro_Data("discreption"));
	
                         reqplaylist.setPublic(false);
                         
                         
                         //call karacyci first kutli method pahije te ...commamon madhun
               		  
    
                         Response response = Playlist_API_all.post_request(reqplaylist,Token_Genrator.renew_token());
    
                          Playlist responseplaylist = response.as(Playlist.class);
  
                          playlistID=responseplaylist.getId();
  
                          //validation 
                           String reqname = reqplaylist.getName();
                           
                            String resname = responseplaylist.getName();
  
	                       Assert.assertEquals(resname, reqname);
	                       
	                       
	          }
	
	@Story("SPS-02-GET a playlist")
	@Description("fetch created playlist data")
	
          @Test(priority = 2)
	  public void GET_api_playlist() throws IOException {
		
		  //call karacyci first kutli method pahije te ...commamon madhun
		  
		  
		Response response = Playlist_API_all.GET_request(playlistID,Token_Genrator.renew_token()); // end point made playlist pahije 
		
		Playlist respplaylist = response.as(Playlist.class); //response faetch kela ahe playlist madhun
		
		String descrption = respplaylist.getDescription();
		
		System.out.println(descrption);
		
		
		
	}
	@Story("SPS-03-update a playlist")
	@Description("updated  playlist with valid  data")
     @Test(priority = 3)
	 public  void put_method () throws IOException {
    	 
    	 configReader_property cr=new configReader_property();//property file 
		 
			Playlist reqplaylist =new Playlist();
			
			reqplaylist.setName(cr.Raad_pro_Data("name")+"updated playlist data");
			
			reqplaylist.setDescription(cr.Raad_pro_Data("discreption"));
			
			reqplaylist.setPublic(false);
			
			
			Response response = Playlist_API_all.update(reqplaylist, playlistID,Token_Genrator.renew_token());
			
			int stscode = response.statusCode();
			
			Assert.assertEquals(stscode, 200);
			
			System.out.println("test for new commit -jenkins");
	 }
	@Story("SPS-04- resgression -not authrozied test case")
	@Description("valiated negetive test  data")
     @Test(priority = 4)	
     public void should_not_be_authrozied() {
    	 
    	 //Data pahila pojo madhun ghych ahe 

                     Playlist reqplaylist =new Playlist();

                     reqplaylist.setName("15 aug independeance playlist");

                     reqplaylist.setDescription("palyloist 15 aug");

                     reqplaylist.setPublic(false);
                     
                     
                     //call karacyci first kutli method pahije te ...commamon madhun
           		  

                     Response response = Playlist_API_all.post_request(reqplaylist,"expiredtokenwrwrwrg");

                     //******************************************
//                      Playlist responseplaylist = response.as(Playlist.class);
//
//                      playlistID=responseplaylist.getId();

                      //validation
//                       String reqname = reqplaylist.getName();
//                       
//                        String resname = responseplaylist.getName();
//
//                       Assert.assertEquals(resname, reqname);
                       //************************************************
              
                   int stscode = response.statusCode();
                   
                   Assert.assertEquals(stscode, 401);
                     
                    
          }
	
	
}

package com.spotify.api;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder_comman {
	
	@Step
	public static RequestSpecification ReqSpecBuilder() {
		
         return    new RequestSpecBuilder()
		
	 	.setBaseUri("https://api.spotify.com")
	 	
	 	.setBasePath("/v1")
	 //	.addHeader("Authorization", "Bearer BQDWre4EEYZsfeLAqis9Dj4s-OMeHgR_EHW-mSfFZ95EYHSbnQNeBGehoTVXZR65YPxHqcQDdNEX3Dc28nGzFd-EPprrE-7WFqS4ZXI_4xuzMjGuoweDFviD3zBZ0xEITmpCmtD9zv17SW03H7MwkeaDa9A7_NcBw6CFngMRgRtmOKZZJrx7_XgCmnkDCNE_C5x_H0JhlZ15GeZX4VTBvxLMwF5WO22lgWAf-O4rz2-iulSBcmQk7LLVqfvxQvd2ZNljYwHRutLI2C_r")
	 	
	 	.addFilter(new AllureRestAssured())
	 	
	 	.setContentType(ContentType.JSON)
		
         .log(LogDetail.ALL)
         
         .build();
		
	}
	
	@Step
	public static  ResponseSpecification ResponseSpecBuilder()
	{
		
        return new ResponseSpecBuilder()
		
		
	    .expectContentType(ContentType.JSON)
		
		.log(LogDetail.ALL)
		
	    .build();
		
	}
	

}

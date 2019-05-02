package com.mertkan.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public interface ResponseService {
	
	String getDynamicResponse(String response);
	String getMirroredResponse(String response);
	String fakerValue(String pattern);
	MediaType getMIME(String contentType);
	HttpStatus getStatus(int statusCode);
	String prettyPrintXML(String xml);
	String prettyPrintJSON(String json);

}

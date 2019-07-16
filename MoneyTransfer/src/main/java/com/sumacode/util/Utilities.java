package com.sumacode.util;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Utilities {

	
	public static String randomGenerator(String name){
		String uuid = "";
		
		String date = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
		
		uuid = name.substring(0, 3).concat(date.toString());
				
		return uuid;
	}
	 
	
	 public static void main(String[] args) {  
	    
		 System.out.println(randomGenerator("Suman Dutta"));
	}  
	
}

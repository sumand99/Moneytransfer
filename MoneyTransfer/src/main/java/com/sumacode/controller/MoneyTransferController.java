package com.sumacode.controller;

import java.sql.SQLException;

import com.sumacode.model.Transfer;
import com.sumacode.persist.PersistTransfer;

public class MoneyTransferController {

	public String initateTransfer(Transfer transfer){
		String response = "";
		String uuid = "";
		boolean validationResult = false;
		
		
		//Call External API to do validation of the Object 
		// abcAPI.validate(transfer || or some other object);
		validationResult = true;
		
		try {
			if(validationResult){
				uuid = PersistTransfer.insertInMoneyTable(transfer);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		if(!"".equals(uuid)) {			
			response = "{'response':'Success', 'uuid': '"+ uuid +"','code':'0'}";
		}else {
			//code will explain specific issue. We do not want to expose exact cause.
			response = "{'response':'Failure', 'code':'104'}";  
		}

		return response;
	}
	
	
	public String getTransferStatus(String transactionId){
		Transfer transfer = null;
		String responseString = "";
		
		try {
			 transfer = PersistTransfer.getTransferStatus(transactionId);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(transfer.getTransfer_status().equals("In Progress")){
			responseString = "{'response':'In Progress','code':'100'}";
		}else if(transfer.getTransfer_status().equals("Not a valid Transaction")){
			responseString = "{'response':'Not a valid Transaction','code':'99'}";
		}else {
			responseString = "{'response':'Transaction Completed','code':'0'}";
		}

		
		return responseString;
	}

	
	public String updateTransferStatus(String transactionId, String status){
		String response = "";
		try {
			if(status.equals("00")){
				status =  "Completed";
			}else{
				status = "In Progress";
			}
			response = PersistTransfer.updateTransferStatus(transactionId,status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(response.equals("Success")){
			return "{'response':'Status Updated','code':'0'}";
		}else {
			return "{'response':'Failed to Update','code':'98'}";
		}

	}
}

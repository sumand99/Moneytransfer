package com.sumacode.res;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sumacode.controller.MoneyTransferController;

@Path("/paymentgateway")
public class Gateway {
	
	@PUT
	@Path("/updatetransfer/{transid}/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updateTransferStatus(@PathParam("transid") String transactionId ,@PathParam("status")String status){
		MoneyTransferController mtransferCtr = new MoneyTransferController();	
		return mtransferCtr.updateTransferStatus(transactionId,status);
	}

}

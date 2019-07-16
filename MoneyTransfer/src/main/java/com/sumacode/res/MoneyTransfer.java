package com.sumacode.res;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sumacode.controller.MoneyTransferController;
import com.sumacode.model.Transfer;


@Path("/moneytransfer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoneyTransfer {

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String initateTransfer(Transfer transfer){
		
		MoneyTransferController mtransferCtr = new MoneyTransferController();
		return mtransferCtr.initateTransfer(transfer);
		
	}

	
	@GET
	@Path("/{transid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTransferStatus(@PathParam("transid") String transactionId){		
		MoneyTransferController mtransferCtr = new MoneyTransferController();		
		return mtransferCtr.getTransferStatus(transactionId);
		
	}

	
}

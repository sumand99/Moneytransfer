package com.sumacode.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sumacode.model.Transfer;
import com.sumacode.util.Utilities;

public class PersistTransfer {
 
	 static Connection conn;
 

  private static  void connectionToDerby() throws SQLException {
    // -------------------------------------------
    // URL format is
    // jdbc:derby:<local directory to save data>
    // -------------------------------------------
    String dbUrl = "jdbc:derby:db/moneytransfer;create=true";
    conn = DriverManager.getConnection(dbUrl);
  }

 
  
  public static String insertInMoneyTable(Transfer transfer) throws SQLException  {
	  String UUID = "";
	  try {
			connectionToDerby();
			PreparedStatement initiateTransferQuery = conn.prepareStatement( "insert into moneytransfer (transaction_id,transfer_amount,sender_name,sender_bankname,"
					+ "sender_acc_num,sender_routing_num,sender_address,sender_phone,recipient_name,recipient_bank_name,recipient_bank_address,"
					+ "recipient_bank_acc_number,recipient_bank_routing_number,recipient_phone_number,transfer_status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );

			
			 UUID = Utilities.randomGenerator(transfer.getSender_name());
			 initiateTransferQuery.setString(1, UUID);
			 initiateTransferQuery.setString(2, transfer.getAmount());
			 initiateTransferQuery.setString(3, transfer.getSender_name());
			 initiateTransferQuery.setString(4, transfer.getSender_bank_name());		 
			 initiateTransferQuery.setString(5, transfer.getSender_acc_num());
			 initiateTransferQuery.setString(6, transfer.getSender_routing_num());
			 initiateTransferQuery.setString(7, transfer.getSender_address());
			 initiateTransferQuery.setString(8, transfer.getSender_phone());
			 initiateTransferQuery.setString(9, transfer.getRecipient_name());
			 initiateTransferQuery.setString(10, transfer.getRecipient_bank_name());
			 initiateTransferQuery.setString(11, transfer.getRecipient_bank_address());
			 initiateTransferQuery.setString(12, transfer.getRecipient_bank_acc_num());
			 initiateTransferQuery.setString(13, transfer.getRecipient_bank_routing_num());
			 initiateTransferQuery.setString(14, transfer.getRecipient_phone_num());
			 initiateTransferQuery.setString(15, "In Progress");
			 
			 initiateTransferQuery.executeUpdate();
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}finally{
			conn.close();
		}
	    return UUID;
	  }
  
  
  public static Transfer getTransferStatus(String transactionId) throws SQLException {
	  Transfer transfer = null;
	  try {
		connectionToDerby();
		PreparedStatement pstmt = conn.prepareStatement("select * from moneytransfer where transaction_id=?");
		  pstmt.setString(1, transactionId);
		  ResultSet rs = pstmt.executeQuery();
		    // print out query result
		    while (rs.next()) { 
		      System.out.println(rs.getInt("id") +" -- " + rs.getString("sender_name") +" --" +rs.getString("recipient_name") + " --" +rs.getString("transfer_status"));
		      transfer = new Transfer();
		      transfer.setAmount(rs.getString("transfer_amount"));
		      transfer.setSender_name(rs.getString("sender_name"));
		      transfer.setRecipient_bank_name(rs.getString("recipient_name"));
		      transfer.setTransfer_status(rs.getString("transfer_status"));
		    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		conn.close();
	}
	  
	  if(null==transfer){
		  transfer = new Transfer();
		  transfer.setTransfer_status("Not a valid Transaction");
	  }
	 
	  return transfer;
	  		  
  }
  
  public static String updateTransferStatus(String transactionId, String status) throws SQLException {
	  String query  = "update moneytransfer set transfer_status=? where transaction_id=?";
	  try {
		connectionToDerby();
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, status);
		pstmt.setString(2, transactionId);		
		pstmt.executeUpdate();		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return "Failure";
	}finally{
		conn.close();
	}
	  
	  return "Success";
  }
  
 
}

package com.sumacode.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHouseCleaning {

    Connection conn;
	
	public DBHouseCleaning() {
		// TODO Auto-generated constructor stub
	}

	 public static void main(String[] args) throws SQLException {
		   DBHouseCleaning app = new DBHouseCleaning();
		    app.connectionToDerby();
		    app.normalDbUsage();
		    app.createMoneyTable();
		    app.insertInMoneyTable();
		  }

	    private void connectionToDerby() throws SQLException {
		    // -------------------------------------------
		    // URL format is
		    // jdbc:derby:<local directory to save data>
		    // -------------------------------------------
		    String dbUrl = "jdbc:derby:db/moneytransfer;create=true";
		    conn = DriverManager.getConnection(dbUrl);
		  }

 	 
    	 private void normalDbUsage() throws SQLException {
		    Statement stmt = conn.createStatement();

		    // drop table
		    // stmt.executeUpdate("Drop Table users");

		    // create table
		    // stmt.executeUpdate("Create table users (id int primary key, name varchar(30))");

		    // insert 2 rows
		    // stmt.executeUpdate("insert into users values (1,'tom')");
		    // stmt.executeUpdate("insert into users values (2,'peter')");

		    // query
		    ResultSet rs = stmt.executeQuery("SELECT * FROM users");

		    // print out query result
		    while (rs.next()) { 
		      System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
		    }
		  }
		  
		  private void createMoneyTable() throws SQLException {
			 Statement stmt = conn.createStatement();
			 stmt.executeUpdate("Drop Table moneytransfer");
			 conn.commit();

			 stmt.executeUpdate("Create table moneytransfer (id int primary key not null generated always as identity (start with 1, increment BY 1), transaction_id varchar(20), transfer_amount int, sender_name varchar(30), sender_bankname varchar(50), sender_acc_num varchar(20), sender_routing_num varchar(20), sender_address varchar(50), sender_phone varchar(10),recipient_name varchar(50), recipient_bank_name varchar(30), recipient_bank_address varchar(50), recipient_bank_acc_number varchar(20),recipient_bank_routing_number varchar(20), recipient_phone_number varchar(10), transfer_status varchar(15))");	  
		  }
		 
		  
		  private void insertInMoneyTable() throws SQLException {
				 Statement stmt = conn.createStatement();

				 stmt.executeUpdate("insert into moneytransfer (transaction_id,transfer_amount,sender_name,sender_bankname,sender_acc_num,sender_routing_num,sender_address,sender_phone,recipient_name,recipient_bank_name,recipient_bank_address,recipient_bank_acc_number,recipient_bank_routing_number,recipient_phone_number,transfer_status) values ('adf3233',1000, 'Tom', 'BOFA','19991','1000101','Sunnyvale,CA', '666222000','Aaron','Chase','Seattle, WA','10001','1033333','4085555556','In Progress')");
				 stmt.executeUpdate("insert into moneytransfer( transaction_id,transfer_amount,sender_name,sender_bankname,sender_acc_num,sender_routing_num,sender_address,sender_phone,recipient_name,recipient_bank_name,recipient_bank_address,recipient_bank_acc_number,recipient_bank_routing_number,recipient_phone_number,transfer_status) values ('abc8880',3000, 'Tom', 'BOFA','19991','1000101','Sunnyvale,CA', '666222000','Daniel','Citibank','SFO, CA','109000','4033333','4044448880','In Progress')");

				 ResultSet rs = stmt.executeQuery("SELECT * FROM moneytransfer");

				    // print out query result
				    while (rs.next()) { 
				      System.out.println(rs.getInt("id") +" -- " + rs.getString("sender_name") +" --" +rs.getString("recipient_name")+ " --" +rs.getString("transfer_status"));
				    }
			  }

}

package com.sumacode.model;

public class Transfer {

	public Transfer() {
		// TODO Auto-generated constructor stub
	}

	private String amount = "";
	private String sender_name = "";
	private String sender_bank_name = "";
	private String sender_acc_num = "";
	private String sender_routing_num = "";
	private String sender_address = "";
	private String sender_phone = "";
	private String recipient_name = "";
	private String recipient_bank_name = "";
	private String recipient_bank_address = "";
	private String recipient_bank_acc_num = "";
	private String recipient_bank_routing_num = "";
	private String recipient_phone_num = "";
	private String transfer_status = "";
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public String getSender_bank_name() {
		return sender_bank_name;
	}
	public void setSender_bank_name(String sender_bank_name) {
		this.sender_bank_name = sender_bank_name;
	}
	public String getSender_acc_num() {
		return sender_acc_num;
	}
	public void setSender_acc_num(String sender_acc_num) {
		this.sender_acc_num = sender_acc_num;
	}
	public String getSender_routing_num() {
		return sender_routing_num;
	}
	public void setSender_routing_num(String sender_routing_num) {
		this.sender_routing_num = sender_routing_num;
	}
	public String getSender_address() {
		return sender_address;
	}
	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}
	public String getSender_phone() {
		return sender_phone;
	}
	public void setSender_phone(String sender_phone) {
		this.sender_phone = sender_phone;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	public String getRecipient_bank_name() {
		return recipient_bank_name;
	}
	public void setRecipient_bank_name(String recipient_bank_name) {
		this.recipient_bank_name = recipient_bank_name;
	}
	public String getRecipient_bank_address() {
		return recipient_bank_address;
	}
	public void setRecipient_bank_address(String recipient_bank_address) {
		this.recipient_bank_address = recipient_bank_address;
	}
	public String getRecipient_bank_acc_num() {
		return recipient_bank_acc_num;
	}
	public void setRecipient_bank_acc_num(String recipient_bank_acc_num) {
		this.recipient_bank_acc_num = recipient_bank_acc_num;
	}
	public String getRecipient_bank_routing_num() {
		return recipient_bank_routing_num;
	}
	public void setRecipient_bank_routing_num(String recipient_bank_routing_num) {
		this.recipient_bank_routing_num = recipient_bank_routing_num;
	}
	public String getRecipient_phone_num() {
		return recipient_phone_num;
	}
	public void setRecipient_phone_numb(String recipient_phone_num) {
		this.recipient_phone_num = recipient_phone_num;
	}
	public String getTransfer_status() {
		return transfer_status;
	}
	public void setTransfer_status(String transfer_status) {
		this.transfer_status = transfer_status;
	}
	
}

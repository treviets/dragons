package net.dragons.dto;

import net.dragons.jpa.entity.Booking;
import net.dragons.jpa.entity.Customer;
import net.dragons.jpa.entity.Transaction;

public class BookingEmailDto {
	
	private Customer customer;
	
	private Transaction transaction;
	
	private Booking booking;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	
}

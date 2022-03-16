package com.mtit.osgi.service;

public interface Service {

	public boolean checkVehicle(Object vehicleObj);
	public void calculateParkingTicket(String inDate, String outDate, String inTime, String outTime, double parkingTicketPrice);
}

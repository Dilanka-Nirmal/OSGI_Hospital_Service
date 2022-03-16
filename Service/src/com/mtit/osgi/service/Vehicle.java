package com.mtit.osgi.service;

public class Vehicle {

	private String vehicleNo;
	private String vehicleOwner;
	private String idNo;
	private String address;

	public Vehicle(String vehicleNo, String vehicleOwner, String idNo, String address) {
		this.vehicleNo = vehicleNo;
		this.vehicleOwner = vehicleOwner;
		this.idNo = idNo;
		this.address = address;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public String getVehicleOwner() {
		return vehicleOwner;
	}

	public String getIdNo() {
		return idNo;
	}

	public String getAddress() {
		return address;
	}
	
}

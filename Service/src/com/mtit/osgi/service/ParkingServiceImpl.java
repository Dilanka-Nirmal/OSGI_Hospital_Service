package com.mtit.osgi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingServiceImpl implements Service {

	@Override
	public boolean checkVehicle(Object vehicleObj) {
		
		Vehicle[] vehicle = {new Vehicle("CAB-1225", "Upul Dissanayake", "842243125V", "No: 12/A, Walawwatta Rd, Panadura"),
		new Vehicle("CBD-4235", "Faizil Hamid", "922246325V", "No: 138, Alubomulla Rd, Moratuwa"),
		new Vehicle("BCF-1135", "Kanchana Nanayakkara", "912343125V", "No: 42, Lorence Rd, Borella"),
		new Vehicle("BGF-2575", "Geetha Hariharan", "922263124V", "No: 3/C, Alfred Rd, Colombo")};

		
		for (int i = 0; i < vehicle.length; i++)
        {
            if (vehicle[i].getVehicleNo().equals(vehicleObj))
            {
            	System.out.println("\n" + vehicle[i].getVehicleNo());
            	System.out.println(vehicle[i].getVehicleOwner());
            	System.out.println(vehicle[i].getIdNo());
            	System.out.println(vehicle[i].getAddress()+ "\n");
                return true;
            }
        }
        return false;
		
	}
	
	public void calculateParkingTicket(String inDate, String outDate, String inTime, String outTime, double parkingTicketPrice) {
		
		String timeIn = inDate + inTime;
		String timeOut= outDate + outTime;
		
		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/ddHH:mm");  

		Date d1 = null;
		Date d2 = null;
		
		try {
		    d1 = format.parse(timeIn);
		    d2 = format.parse(timeOut);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    

		// Get time from each, and subtract.
		long diff = d2.getTime() - d1.getTime(); 
		long diffHours = diff / (60 * 60 * 1000);        
		System.out.println("\n" + "You parked your vehicle nearly: " + diffHours + " hours.");
		
		//Adding payment according to the parked duration
		double parkingPayment = 0;
		
		for(int i = 1; i <= diffHours; i++) {
			parkingPayment += parkingTicketPrice;
		}
		
		System.out.println("Your parking ticket price: Rs."+ parkingPayment + "\n");	

	}

}

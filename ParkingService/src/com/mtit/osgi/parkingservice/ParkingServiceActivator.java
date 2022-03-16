package com.mtit.osgi.parkingservice;

import com.mtit.osgi.service.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ParkingServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(Service.class.getName());
		Service service = (Service) context.getService(serviceReference);
		System.out.println("Parking Service has started...");
		
		
		try
        {
            System.out.println("\n" + "Enter a blank line to exit.");
            String vehicleObj;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            // Loop endlessly.
            while (true)
            {
                // Ask the user to enter a vehicle no.
            	System.out.println("_______________________________________________________________" + "\n");
                System.out.print("Enter the Vehicle no: ");
                vehicleObj = in.readLine();

                // If the user entered a blank line, then
                // exit the loop.
                if (vehicleObj.length() == 0)
                {
                    break;
                }
                // If there is no vehicle no, then say so.
                else if (service == null)
                {
                    System.out.println("No Vehicle data having on Service...");
                }
                // Otherwise print whether the vehicle no is available or not.
                else if (service.checkVehicle(vehicleObj))
                {
                    System.out.println("Vehicle data have been loaded Successfully...");
                    
                    try
                    {
                    BufferedReader dateIn = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader dateOut = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader timeIn = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader timeOut = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader parkingTicket = new BufferedReader(new InputStreamReader(System.in));
                    
                    String inDate;
                    
                    System.out.print("\n" + "Enter the In Date [YY/MM/DD]: ");
                    inDate = dateIn.readLine();
                    
                    String outDate;
                    
                    System.out.print("\n" + "Enter the Out Date [YY/MM/DD]: ");
                    outDate = dateOut.readLine();
                    
                    String inTime;
                    
                    System.out.print("\n" + "Enter the In Time [HH/MM]: ");
                    inTime = timeIn.readLine();
                    
                    String outTime;
                    
                    System.out.print("\n" + "Enter the Out Time [HH/MM]: ");
                    outTime = timeOut.readLine();
                    
                    String price;
                    
                    System.out.print("\n" + "Enter the parking price per hour : ");
                    price = parkingTicket.readLine();
                    
                    double parkingTicketPrice = Double.valueOf(price).doubleValue();
                    
                    service.calculateParkingTicket(inDate, outDate, inTime, outTime, parkingTicketPrice);
                    }catch(Exception ex) {
                    	ex.printStackTrace();
                    }
                    
                }
                else
                {
                    System.out.println("Please enter a valid Vehicle no, again...");
                    System.out.println("----------------------------------------------------------");
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}

	public void stop(BundleContext context) throws Exception {
		context.ungetService(serviceReference);
		System.out.println("Parking Service has stopped, Good Bye...");
	}

}

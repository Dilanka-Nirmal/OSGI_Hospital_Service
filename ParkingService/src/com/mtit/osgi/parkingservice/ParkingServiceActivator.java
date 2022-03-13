package com.mtit.osgi.parkingservice;

import com.mtit.osgi.service.Service;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ParkingServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Parking Service has started...");
		serviceReference = context.getServiceReference(Service.class.getName());
		
		Service service = (Service) context.getService(serviceReference);
		System.out.println(service.publishParking());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Parking Service has stopped...\nGood Bye");
		context.ungetService(serviceReference);
	}

}

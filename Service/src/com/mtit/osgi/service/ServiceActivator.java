package com.mtit.osgi.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		
		//ParkingServiceImpl class has registered as a service 
		Service parkingService = new ParkingServiceImpl();
		serviceRegistration = context.registerService(Service.class.getName(), parkingService, null);
		
		System.out.println("Hospital service has started...");
		
		
	}

	public void stop(BundleContext context) throws Exception {
		serviceRegistration.unregister();
		System.out.println("Hospital service has stopped...");
	}

}

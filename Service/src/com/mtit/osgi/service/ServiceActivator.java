package com.mtit.osgi.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Hospital service has started...");
		Service service = new ParkingServiceImpl();
		
		serviceRegistration = context.registerService(Service.class.getName(), service, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Hospital service has stopped...");
		serviceRegistration.unregister();
	}

}

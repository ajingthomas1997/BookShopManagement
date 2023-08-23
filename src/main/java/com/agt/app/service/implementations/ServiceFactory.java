package com.agt.app.service.implementations;

public class ServiceFactory {

	private static final UserServiceImplementation USER_SERVICE_IMPLEMENTATION = new UserServiceImplementation();

	private static final BookServiceImplementation BOOK_SERVICE_IMPLEMENTATION = new BookServiceImplementation();

	private static final OrderServiceImplementation ORDER_SERVICE_IMPLEMENTATION = new OrderServiceImplementation();
	
	private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
	
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getServiceFactory() {
		
		return SERVICE_FACTORY;
		
	}
	

	public UserServiceImplementation getUserServiceImplementation() {

		return USER_SERVICE_IMPLEMENTATION;

	}

	public BookServiceImplementation getBookServiceImplementation() {

		return BOOK_SERVICE_IMPLEMENTATION;

	}

	public OrderServiceImplementation getOrderServiceImplementation() {

		return ORDER_SERVICE_IMPLEMENTATION;

	}

}

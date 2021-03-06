package com.revature;


import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.TicketController;
import com.revature.daos.TicketDAO;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		TicketController TC = new TicketController(); 
		LoginController LC = new LoginController();
		EmployeeController EC = new EmployeeController();
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		
		app.get("/tickets", TC.getAllTicketsHandler);
		app.get("/tickets/:id", TC.getTicketsByEmployeeHandler);
		app.get("/tickets/active", TC.getActiveTicketsHandler);
		app.get("/tickets/active/:id", TC.getActiveTicketsByEmployeeHandler);
		app.post("/tickets/new", TC.newTicketHandler);
		app.post("/login", LC.loginHandler);
		app.get("/employees", EC.getAllEmployeesHandler);
		app.get("/employees/:id", EC.getEmployeeByIdHandler);

	}
	
	
	
}

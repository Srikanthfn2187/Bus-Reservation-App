package org.jsp.SpringBootDemo.controller;

import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.jsp.SpringBootDemo.dto.Ticket;
import org.jsp.SpringBootDemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TicketController 
{
	@Autowired
	private TicketService service;
	
	
	@PostMapping("/tickets/{bus_id}/{user_id}")
	public ResponseEntity<ResponseStructure<Ticket>> bookTicket(@PathVariable int bus_id,@PathVariable int user_id,@RequestBody Ticket ticket)
	{
		return service.bookTicket(bus_id,user_id,ticket);
		
	}
	@PutMapping("/tickets/{bus_id}/{user_id}")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@PathVariable int bus_id,@PathVariable int user_id,@RequestBody Ticket ticket)
	{
		return service.updateTicket(bus_id,user_id,ticket);	
	}
	
	@GetMapping("/tickets/{id}")
	public ResponseEntity<ResponseStructure<String>> cancelBooking(@PathVariable int id)
	{
		return service.cancelBooking(id);	
	}
}

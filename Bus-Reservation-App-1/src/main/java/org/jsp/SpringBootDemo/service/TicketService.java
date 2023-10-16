package org.jsp.SpringBootDemo.service;

import java.util.Optional;

import org.jsp.SpringBootDemo.Exception.IdNotFoundException;
import org.jsp.SpringBootDemo.dao.BusDao;
import org.jsp.SpringBootDemo.dao.TicketDao;
import org.jsp.SpringBootDemo.dao.UserDao;
import org.jsp.SpringBootDemo.dto.Bus;
import org.jsp.SpringBootDemo.dto.EmailConfiguration;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.jsp.SpringBootDemo.dto.Ticket;
import org.jsp.SpringBootDemo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketService
{
	@Autowired
	private TicketDao dao;
	
	
	@Autowired
	private UserDao udao;
	
	
	@Autowired
	private BusDao bdao;
	
	@Autowired
	private EmailConfiguration configuration;
	
	@Autowired
	private ReservationApiEmailService service;
	
	
	public ResponseEntity<ResponseStructure<Ticket>> bookTicket(int bus_id, int user_id, Ticket ticket)
	{
		ResponseStructure<Ticket> structure=new ResponseStructure<>();
		Optional<User> recUser=udao.findById(user_id);
		Optional<Bus> recBus=bdao.findById(bus_id);
		if(recUser.isPresent()&&recBus.isPresent())
		{
			User u=recUser.get();
			Bus b=recBus.get();
			ticket.setCost(b.getCost_per_seat()*ticket.getNo_of_seats());
			u.getTickets().add(ticket);
			b.getTickets().add(ticket);
			ticket.setBus(b);
			ticket.setUser(u);
			udao.updateUser(u);
			bdao.updateBus(b);
			
			configuration.setTo(u.getEmail());
			configuration.setSubject("Confirmation on Ticket Booking!");
			configuration.setText("Hi Mr."+u.getName()+"\n Thank You for choosing "+b.getName()+"as your top priority!!! "+"\n ----------Ticket Details----------"+"\n Name:"+ u.getName()+"\n  "+ "Number of seats booked:"+ticket.getNo_of_seats()+"\n"+"Seat No:"+ticket.getSeat_number()+"\n Bus Number: "+b.getBus_no()
			+"\n Total Cost:"+ticket.getCost());
			
			String message=service.sendEmail(configuration);
			
			structure.setData(dao.bookTicket(ticket));
			structure.setMessage("Ticket is booked!");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(int bus_id, int user_id, Ticket ticket)
	{
		ResponseStructure<Ticket> structure=new ResponseStructure<>();
		Optional<User> recUser=udao.findById(user_id);
		Optional<Bus> recBus=bdao.findById(bus_id);
		if(recUser.isPresent()&&recBus.isPresent())
		{
			User u=recUser.get();
			Bus b=recBus.get();
			ticket.setCost(b.getCost_per_seat()*ticket.getNo_of_seats());
			ticket.setBus(b);
			ticket.setUser(u);
			udao.updateUser(u);
			bdao.updateBus(b);
			
			configuration.setTo(u.getEmail());
			configuration.setSubject("Confirmation on Ticket Booking!");
			configuration.setText("Hi Mr."+u.getName()+"\n Thank You for choosing "+b.getName()+"as your top priority!!! "+"\n ----------Ticket Details----------"+"\n Name:"+ u.getName()+"\n  "+ "Number of seats booked:"+ticket.getNo_of_seats()+"\n"+"Seat No:"+ticket.getSeat_number()+"\n Bus Number: "+b.getBus_no()
			+"\n Total Cost:"+ticket.getCost());
			
			String message=service.sendEmail(configuration);
			
			structure.setData(dao.bookTicket(ticket));
			structure.setMessage("Ticket details are updated!");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	

	public ResponseEntity<ResponseStructure<String>> cancelBooking(int id)
	{
		ResponseStructure<String > structure=new ResponseStructure<>();
		Optional<Ticket> recTicket=dao.findById(id);
		if(recTicket.isEmpty())
		{
			throw new IdNotFoundException();
		}
		dao.cancelBooking(recTicket.get());
		structure.setData("Booking Cancelled!");
		structure.setMessage("Your is successfully cancelled!!");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	}

}

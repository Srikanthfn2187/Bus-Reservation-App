package org.jsp.SpringBootDemo.dao;

import java.util.Optional;

import org.jsp.SpringBootDemo.dto.Ticket;
import org.jsp.SpringBootDemo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDao 
{
	@Autowired
	private  TicketRepository repo;

	public Ticket bookTicket(Ticket ticket) 
	{
		return repo.save(ticket);
	}

	public Optional<Ticket> findById(int id) {
		return repo.findById(id);
	}

	public void cancelBooking(Ticket ticket)
	{
		repo.delete(ticket);
	}
}

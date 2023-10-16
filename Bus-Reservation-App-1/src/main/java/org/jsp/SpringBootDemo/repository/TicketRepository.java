package org.jsp.SpringBootDemo.repository;

import org.jsp.SpringBootDemo.dto.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>
{

}

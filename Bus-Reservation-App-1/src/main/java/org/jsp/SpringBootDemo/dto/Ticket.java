package org.jsp.SpringBootDemo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Ticket 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int ticket_no;
	
	@Column(nullable = false)
	private double cost;
	
	@CreationTimestamp
	private LocalDateTime time_of_booking;
	
	
	@Column(nullable = false)
	private int no_of_seats;
	
	@Column(nullable = false)
	private String seat_number;
	
	
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Bus bus;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;
	
	
}

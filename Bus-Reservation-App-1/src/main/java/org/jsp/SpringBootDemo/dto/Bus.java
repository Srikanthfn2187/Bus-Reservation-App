package org.jsp.SpringBootDemo.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Bus 
{
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(nullable = false,name="BUS_NAME")
	private String name;
	
	
	@Column(nullable = false,name = "FROM_LOCATION")
	private String from;
	
	
	@Column(nullable = false,  name = "TO_LOCATION")
	private String to;
	
	
	@Column(name="DATE_OF_DEPARTURE",nullable = false)
	private String dop;
	
	
	@Column(name="BUS_NO",nullable = false)
	private String bus_no;
	
	
	@Column(name="NO_OF_SEATS",nullable = false)
	private int nseats;
	
	@Column(nullable = false)
	private double cost_per_seat;
	
	
	@Column(nullable = false)
	private String dept_time;
	
	
	@Column(nullable = false)
	private String arrival_time;
	
	
	@Column(nullable = false)
	private String image_url;
	
	
	@ManyToOne
	@JoinColumn(name="admin_id")
	@JsonIgnore
	private Admin admin;
	
	
	
	@OneToMany(mappedBy = "bus")
	private List<Ticket> tickets;
	
	
}

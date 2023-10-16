package org.jsp.SpringBootDemo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootDemo.dto.Bus;
import org.jsp.SpringBootDemo.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao
{
	@Autowired
	private BusRepository repo;
	
	public Bus saveBus(Bus bus)
	{
		return repo.save(bus);
	}
	
	
	public List<Bus> filter(String from, String to, String dop) 
	{
		return repo.filter(from,to,dop);
	}

	
	public Optional<Bus> findById(int id)
	{
		return repo.findById(id);
	}


	public Bus updateBus(Bus b)
	{
		return repo.save(b);
	}


	public List<Bus> findAll(int admin_id)
	{
		return repo.findAll(admin_id);
	}


	public void deleteBus(int bus_id) {
         repo.deleteById(bus_id);
	}
	
	
}

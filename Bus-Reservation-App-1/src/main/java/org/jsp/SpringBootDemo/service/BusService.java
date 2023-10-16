package org.jsp.SpringBootDemo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.jsp.SpringBootDemo.Exception.IdNotFoundException;
import org.jsp.SpringBootDemo.dao.AdminDao;
import org.jsp.SpringBootDemo.dao.BusDao;
import org.jsp.SpringBootDemo.dto.Admin;
import org.jsp.SpringBootDemo.dto.Bus;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	AdminDao adao;
	
	@Autowired
	BusDao dao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus, int adminid)
	{
		ResponseStructure<Bus> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adao.findById(adminid);
		if(recAdmin.isPresent())
		{
			Admin a=recAdmin.get();
			a.getBuses().add(bus);
			adao.updateAdmin(a);
			bus.setAdmin(a);
			structure.setData(dao.saveBus(bus));
			structure.setMessage("Bus is ready to move!!");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure,HttpStatus.CREATED);
			
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus bus, int adminid)
	{
		ResponseStructure<Bus> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adao.findById(adminid);
		if(recAdmin.isPresent())
		{
			Admin a=recAdmin.get();
//			List<Bus> bs=a.getBuses();
//			int index=-1;
//			for(Bus b:bs)
//			{
//				if(b.getId()==bus.getId())
//				{
//					index=bs.indexOf(b);
//					break;
//				}
//			}
//				if(index!=-1) 
//				{
//					a.getBuses().set(index, bus);
//					adao.updateAdmin(a);
					bus.setAdmin(a);
//		            System.out.println(index);			
				    structure.setData(dao.updateBus(bus));
				    structure.setMessage("Bus details are updated");
				    structure.setStatuscode(HttpStatus.CREATED.value());
				    return new ResponseEntity<ResponseStructure<Bus>>(structure,HttpStatus.CREATED);
//				}
				
			
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Bus>>> filter(String from, String to, String dop)
	{
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		structure.setData(dao.filter(from,to,dop));
		structure.setMessage("List of buses");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Bus>> findById(int id)
	{
		ResponseStructure<Bus> structure=new ResponseStructure<>();
	  Optional<Bus> recBus=dao.findById(id);
	if(recBus.isPresent())
	{
		structure.setData(recBus.get());
		structure.setMessage("Bus details are found!!");
		structure.setStatuscode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Bus>>(structure,HttpStatus.OK);
	}
	throw new IdNotFoundException();	
	}

	public ResponseEntity<ResponseStructure<List<Bus>>> findAll(int admin_id) 
	{
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adao.findById(admin_id);
		if(recAdmin.isPresent())
		{
			structure.setData(dao.findAll(admin_id));
			structure.setMessage("Buses are Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteBus(int admin_id, int bus_id) 
	{
		ResponseStructure<String>  structure=new ResponseStructure<>();
		Optional<Admin> recAdmin=adao.findById(admin_id);
		Optional<Bus> recBus=dao.findById(bus_id);
		if(recAdmin.isPresent()&&recBus.isPresent())
		{
			dao.deleteBus(bus_id);
		     structure.setData("Bus is found");
		     structure.setMessage("Bus is deleted!!!");
		     structure.setStatuscode(HttpStatus.OK.value());
		     return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	
}

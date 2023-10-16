package org.jsp.SpringBootDemo.controller;


import java.util.List;

import org.jsp.SpringBootDemo.dto.Bus;
import org.jsp.SpringBootDemo.dto.ResponseStructure;
import org.jsp.SpringBootDemo.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class BusController {

	@Autowired
	private BusService service;
	
	
	@PostMapping("/buses/{adminid}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus,@PathVariable int adminid)
	{
		return service.saveBus(bus,adminid);
	}
	
	@PutMapping("/buses/{adminid}")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus,@PathVariable int adminid)
	{
		return service.updateBus(bus,adminid);
	}
	
	@GetMapping("/buses/findall/{admin_id}")
	public ResponseEntity<ResponseStructure<List<Bus>>> busList(@PathVariable int admin_id)
	{
	   return service.findAll(admin_id);	
	}
	
	@GetMapping("/buses/filter")
	public ResponseEntity<ResponseStructure<List<Bus>>> filter(@RequestParam String from,@RequestParam  String to,@RequestParam String dop)
	{
		return service.filter(from, to, dop);
	}
	
	@GetMapping("/buses/{id}")
	public ResponseEntity<ResponseStructure<Bus>> verifyById(@PathVariable  int id)
	{
		return service.findById(id);
	}
	
	@DeleteMapping("/buses/{admin_id}/{bus_id}")
	public ResponseEntity<ResponseStructure<String>> deleteBus(@PathVariable int admin_id,@PathVariable int bus_id)
	{
		return service.deleteBus(admin_id,bus_id);
	}
}

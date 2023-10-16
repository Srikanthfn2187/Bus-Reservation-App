package org.jsp.SpringBootDemo.repository;


import java.util.List;

import org.jsp.SpringBootDemo.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository  extends JpaRepository<Bus, Integer>
{

	@Query("select b from Bus b where b.from=?1 and b.to=?2 and b.dop=?3")
	List<Bus> filter(String from, String to, String dop);

	@Query("select b from Bus b where b.admin.id=?1")
	List<Bus> findAll(int admin_id);
	
	
	
}

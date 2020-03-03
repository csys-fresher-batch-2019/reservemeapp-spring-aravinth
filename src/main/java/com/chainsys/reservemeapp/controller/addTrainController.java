package com.chainsys.reservemeapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import trainticket.AdminRole.AdminListOfTrains;
import trainticket.AdminRole.AdminListOfTrainsDAO;
import trainticket.AdminRole.AdminListOfTrainsImpl;
import trainticket.Exception.DbException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class addTrainController {
	@PostMapping("/addtrains")
	public void addTrains(@RequestBody AdminListOfTrains l) {
		AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		try {
			// System.out.println(l);
			dao.addTrains(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/updatetraintimings")
	public void updateTiming(@RequestParam("trainnum") int trainnum,
			@RequestParam("travellingTime") String travellingtime) {
		AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
		try {
			dao.updateTimings(trainnum, travellingtime);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

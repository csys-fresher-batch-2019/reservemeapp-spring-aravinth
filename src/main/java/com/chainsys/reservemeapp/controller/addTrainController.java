package com.chainsys.reservemeapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.reservemeapp.dao.TrainsDAO;
import com.chainsys.reservemeapp.dao.impl.TrainsDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.Trains;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class addTrainController {
	@PostMapping("/addtrains")
	public void addTrains(@RequestBody Trains l) {
		TrainsDAO dao = new TrainsDAOImpl();
		try {
			// System.out.println(l);
			dao.addTrain(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostMapping("/deletetrains")
	public void deleteTrains(@RequestParam("trainnum") int trainNum) {
		TrainsDAO dao = new TrainsDAOImpl();
		try {
			dao.removeTrain(trainNum);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

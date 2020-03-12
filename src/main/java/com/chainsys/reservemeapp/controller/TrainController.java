package com.chainsys.reservemeapp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.reservemeapp.dao.TrainDtoDAO;
import com.chainsys.reservemeapp.dao.impl.TrainDtoDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.TrainDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class TrainController {

	@GetMapping("/trains")
	public ArrayList<TrainDto> list(@RequestParam("source") String source,
			@RequestParam("destination") String destination, @RequestParam("journeyDate") String journeyDate) {
		TrainDtoDAO dao = new TrainDtoDAOImpl();
		ArrayList<TrainDto> list = null;
		try {
			list = dao.searchTrains(source, destination, journeyDate);

		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

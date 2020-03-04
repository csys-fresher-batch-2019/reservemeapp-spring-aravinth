package com.chainsys.reservemeapp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.reservemeapp.dao.findTrainDAO;
import com.chainsys.reservemeapp.dao.impl.findTrainIMPL;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.findTrain;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class TrainController {

	@GetMapping("/trains")
	public ArrayList<findTrain> list(@RequestParam("source") String source, @RequestParam("destination") String destination,
			@RequestParam("journeyDate") String journeyDate) {
		findTrainDAO dao = new findTrainIMPL();
		ArrayList<findTrain> list = null;
		try {
			list = dao.SearchTrain(source,destination,journeyDate);
			
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}


package com.chainsys.reservemeapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.reservemeapp.adminrole.AdminListOfTrainsDAO;
import com.chainsys.reservemeapp.adminrole.AdminListOfTrainsImpl;
import com.chainsys.reservemeapp.exception.DbException;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api")
public class deleteTrainController {
	@PostMapping("/deletetrains")
	public void deleteTrains(@RequestParam("trainnum")int trainNum)
	{
		AdminListOfTrainsDAO dao = new AdminListOfTrainsImpl();
        try {
			dao.removeTrain(trainNum);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

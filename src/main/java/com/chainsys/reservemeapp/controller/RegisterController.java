package com.chainsys.reservemeapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.reservemeapp.dao.AccountDAO;
import com.chainsys.reservemeapp.dao.impl.AccountDAOImpl;
import com.chainsys.reservemeapp.exception.DbException;
import com.chainsys.reservemeapp.model.Account;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class RegisterController {
	@PostMapping("/adduser")
	public int addUser(@RequestBody Account a) {
		int userId = 0;
		AccountDAO dao = new AccountDAOImpl();
		try {
			userId = dao.addUser(a);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return userId;

	}

}

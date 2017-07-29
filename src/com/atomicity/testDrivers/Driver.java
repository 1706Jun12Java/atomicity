package com.atomicity.testDrivers;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.atomicity.dao.UsersDAO;
import com.atomicity.domain.Users;

public class Driver {

	public static void main(String args[]) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		UsersDAO dao = (UsersDAO) ac.getBean("usersDAO");

		List<Users> lst = dao.getAllUsers();
		for (Users u : lst) {
			System.out.println(u);
		}

		((AbstractApplicationContext) ac).close();
	}

}

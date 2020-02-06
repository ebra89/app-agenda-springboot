package com.aton.informatica.appagendaspringboot;


import com.aton.informatica.appagendaspringboot.entities.Task;
import com.aton.informatica.appagendaspringboot.entities.User;
import com.aton.informatica.appagendaspringboot.services.TaskService;
import com.aton.informatica.appagendaspringboot.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppAgendaSpringbootApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;

	@Before
	public void initDb() {
		{
			User newUser = new User("testUser@gmail.com", "testUser", "user", "123456");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@gmail.com", "testAdmin", "admin", "123456");
			userService.createUser(newUser);
		}

		Task userTask = new Task("26/04/2019", "11:10", "12:00", "devi fare la spesa");
		User user = userService.findOne("testUser@gmail.com");
		taskService.addTask(userTask, user);
	}

	@Test
	public void testUser() {
		User user = userService.findOne("testUser@gmail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@gmail.com");
		assertEquals(admin.getEmail(), "testAdmin@gmail.com");

	}

	@Test
	public void testTask() {

		User user = userService.findOne("testUser@gmail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);


	}

}


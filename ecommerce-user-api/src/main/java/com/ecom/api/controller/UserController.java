package com.ecom.api.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.api.model.User;
import com.ecom.api.service.UserService;

@RestController
@RequestMapping("/accounts")
public class UserController {
	
	static
	{
		System.out.println("controller ------");
	}

	Logger logger = LoggerFactory.getLogger("UserController");

	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		logger.info("User Saved :" + user.toString());
		User UserSaved = userService.save(user);

		logger.info("User Saved :" + UserSaved.toString());
		return user;
	}

	@GetMapping("/user/{id}")
	public User get(@PathVariable("id") Long id) {

		Optional<User> UserRetreived = userService.getUser(id);
		User User = UserRetreived.get();
		return User;
	}

//	@GetMapping("solcommerce/pdp-service/User/bypage")
//	Page<User> getUsersByPage(
//			@RequestParam(value = "pagenumber", required = true, defaultValue = "0") Integer pageNumber,
//			@RequestParam(value = "pagesize", required = true, defaultValue = "20") Integer pageSize) {
//		return UserService.getUserByPage(pageNumber, pageSize);
//	}

	@PutMapping("/user/{id}")
	@ResponseBody
	public User updateUser(@RequestBody User User) {
		User UserUpdated = userService.save(User);

		logger.info("User Saved :" + UserUpdated.toString());
		return User;
	}

	/*---Delete a User by id---*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return ResponseEntity.ok().body("User has been deleted successfully.");
	}
	
	@GetMapping("/user")
	public List<User> getAllUser()
	{
		System.out.println("This is User++++++++++++++++");
		List<User> catgories=userService.getAllUser();
		return catgories;
	}
}

package lv.dll.password.controller;

import java.util.Collections;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lv.dll.password.model.Password;



@RestController
public class AppController {

	@RequestMapping(value = "/erroris", method = RequestMethod.GET, produces = "application/json")
	public Object generateErrorResponse()
	{
		return Collections.singletonMap("password", "Error");
	}
	
	@GetMapping("/doit")
	public String doIt() {
		return "Do it";
	}
	
	@RequestMapping(value = "/{type}/{size}", method = RequestMethod.GET, produces = "application/json")
	public Object generatePassword(@PathVariable(value = "type") int type, @PathVariable(value = "size") int size)
	{
		if (type == 1) {
			return Collections.singletonMap("password", Password.generateRandomPassword(size, false, false, false));
		}
		
		else if (type == 2) {
			return Collections.singletonMap("password", Password.generateRandomPassword(size, true, false, false));
		}
		
		else if (type == 3) {
			return Collections.singletonMap("password", Password.generateRandomPassword(size, true, true, false));
		}
		
		else {
			return Collections.singletonMap("password", Password.generateRandomPassword(size, true, true, true));
		}
		
}
	
	
}


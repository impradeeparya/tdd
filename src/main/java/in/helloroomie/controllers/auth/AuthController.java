package in.helloroomie.controllers.auth;

import in.helloroomie.domain.user.User;
import in.helloroomie.dto.user.ChangePasswordDto;
import in.helloroomie.dto.user.UserDto;
import in.helloroomie.service.auth.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Pradeep Arya on 7/10/2015.
 */

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody UserDto login(@RequestBody UserDto user) {
		return authService.authenticateUser(user);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean signup(@RequestBody User user) {
		return authService.signupUser(user);
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public @ResponseBody Boolean login(
			@RequestHeader("Authorization") String token,
			@RequestBody ChangePasswordDto changePasswordDto) {
		return authService.updatePassword(token, changePasswordDto);
	}
}

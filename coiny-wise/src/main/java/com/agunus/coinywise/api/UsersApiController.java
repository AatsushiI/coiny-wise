package com.agunus.coinywise.api;

import com.agunus.coinywise.domain.services.UserService;
import com.agunus.coinywise.model.User;
import com.agunus.coinywise.model.UserList;
import com.agunus.coinywise.model.UserSignUp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import javax.validation.Valid;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-09T12:56:41.729656Z[Etc/UTC]")
@Controller
@RequestMapping("${openapi.coinyWise.base-path:}")
public class UsersApiController implements UsersApi {

	private final NativeWebRequest request;

	@Autowired
	public UsersApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Autowired
	UserService userService;

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<User> usersPost(UserSignUp userSignUp) {
		User result = userService.create(userSignUp);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserList> usersGet() {
		UserList result = userService.getUsers();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> usersIdGet(String id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> usersIdPatch(String id, @Valid User user) {
		User result = userService.update(id, user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> usersIdDelete(String id) {
		userService.userDelete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

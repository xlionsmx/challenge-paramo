package sat.recruitment.api.controller.v1;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import sat.recruitment.api.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sat.recruitment.api.dto.UserDto;
import sat.recruitment.api.factories.UserFactory;
import sat.recruitment.api.mappers.UserMapper;
import sat.recruitment.api.services.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/v1")
public class SatRecruitmentController {

	@Autowired
        UserServiceImpl userService;
        
        @Autowired
        UserMapper userMapper;
        
        @Autowired
        UserFactory userFactory;

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
        @SuppressWarnings("empty-statement")
	public User createUser(@Valid @RequestBody UserDto messageBody) throws InstantiationException, IllegalAccessException {
            
            
            if(userService.isUserDuplicated(messageBody)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is duplicated");
            }

            User newUser =  UserFactory.getUserByType(messageBody.getUserType());
            userMapper.dtoToUser(messageBody, newUser);
            System.out.println(newUser.getMoney());
            return newUser;
         
	}

	
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
            
            Object errorsWrapped = new Object();
            Map<String, String> errors = new HashMap<>();

            ex.getBindingResult().getFieldErrors().forEach(error -> 
                errors.put(error.getField(), error.getDefaultMessage()));

            return errors;
        }

}

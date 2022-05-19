/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.services;

import java.util.List;
import sat.recruitment.api.domain.user.User;
import sat.recruitment.api.dto.UserDto;

/**
 *
 * @author lsanmartin
 */
public interface UserService {
    
    public abstract boolean isUserDuplicated(UserDto user);
    
    public abstract List<User> getUsers();
    
}

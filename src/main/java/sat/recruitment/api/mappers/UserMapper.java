/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sat.recruitment.api.mappers;

import org.springframework.stereotype.Component;
import sat.recruitment.api.domain.user.User;
import sat.recruitment.api.dto.UserDto;

/**
 *
 * @author lsanmartin
 */
@Component
public class UserMapper {
    public void dtoToUser(UserDto dto, User newUser){
        newUser.setName(dto.getName());
        newUser.setEmail(dto.getEmail());
        newUser.setAddress(dto.getAddress());
        newUser.setPhone(dto.getPhone());
        newUser.setUserType(dto.getUserType());
        newUser.setMoney(dto.getMoney());     
    }
    
    public void arrayStringToUser(String[] arrayString, User newUser){
        newUser.setName(arrayString[0]);
        newUser.setEmail(arrayString[1]);
        newUser.setPhone(arrayString[2]);
        newUser.setAddress(arrayString[3]);
        newUser.setUserType(arrayString[4]);
        newUser.setMoney(Double.valueOf(arrayString[5]));
    }
    
}
